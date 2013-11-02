# -*-encoding:utf-8-*-
import csv
import re
import nltk
import MeCab
import sys


#---本文取得---
def getSiteData(row):
    title=row[0]
    content = row[2]
    return title,content

#---出現回数取得---
def getWordCount(content):
    wc={}
    words = extractNouns(content)
    for word in words:
        wc.setdefault(word,0)
        wc[word]+=1
    return words,wc

#---形態素解析---
def extractNouns(content):
    tagger=MeCab.Tagger()
    node=tagger.parseToNode(content)
    re_word = re.compile("助詞|接尾|BOS|EOS|記号|名詞,数|助動詞|動詞|形容詞|サ変接続|接続詞|副詞|接頭詞|非自立| ")#除外する品詞
    nouns = []#単語のリスト
    while node:
        if not re_word.findall(node.feature) and not node.surface.isspace():
            #print node.surface,":",node.feature
            nouns.append(node.surface)
        node = node.next 
    return nouns

#---TF-IDF計算---
def tf_idf(docs):
    tokens=[]
    for doc in docs:
        tokens+=doc
    tf_idf={}
    A=nltk.TextCollection(docs)
    token_types=set(tokens)
    for token_type in token_types:
        #print token_type,'=', A.tf_idf(token_type,tokens)
        tf_idf[token_type]=A.tf_idf(token_type,tokens)
    return tf_idf

#---メイン---
if __name__ == "__main__":
    argv=sys.argv
    dir = argv[1]
    #dir = '/Users/yusuke/Dropbox/workspace/JavaEE/DocSim/'
    csv_path = dir + "cache/cache.csv"
    data_path = dir + "cache/data.txt"

    doclist=[]
    wordcounts={}
    apcount={}
    wordlist=[]
        
    print "================"
    print csv_path
    print data_path
    print "================"
    
    csvfile = open(csv_path)
    list = [line for line in file (csv_path)]
    line = csv.reader(csvfile,delimiter='\t')
    

    for row in line:
        print row
        title,content = getSiteData(row)
        docs,wc=getWordCount(content)
        doclist.append(docs)
        wordcounts[title]=wc
        for word,count in wc.items():
            apcount.setdefault(word,0)
            if count > 1:
                apcount[word]+=1
    tfidf=tf_idf(doclist)
    for w,bc in apcount.items():
        wordlist.append(w)
        
    #---ファイル書き出す---
    out=file(data_path,'w')
    out.write('Blog')
    for word in wordlist:
        out.write('\t%s' % word)
    out.write('\n')
    for blog,wc in wordcounts.items():
        out.write(blog)
        for word in wordlist:
            if (word in tfidf) and (word in wc):
                out.write('\t%f' % (wc[word] * tfidf[word]))
            else:
                out.write('\t0')
        out.write('\n')       