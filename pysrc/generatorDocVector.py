# -*- encoding:utf-8 -*-
import MeCab
import re
import csv
import nltk
import sys


#タイトルと本文の取得
def getDocument(row):
    title = row[0]
    content = row[2]
    print title,content
    return title,content

#単語の出現頻度取得
def getWordcount(content):
    wc = {}
    words = extractNouns(content)
    for word in words:
    
        wc.setdefault(word,0)
        wc[word]+=1
    return wc

# 形態素解析
def extractNouns(content):
    tagger=MeCab.Tagger()#使う辞書の宣言
    node=tagger.parseToNode(content)#本文をnodeとして扱う
    re_word = re.compile("助詞|接尾|BOS|EOS|記号|名詞,数|助動詞|動詞|形容詞|サ変接続|接続詞|副詞|接頭詞|非自立|　")#除外する品詞
    nouns = []#単語のリスト
    while node:
        if not re_word.findall(node.feature) and not node.surface.isspace():
            #print node.surface,":",node.feature
            nouns.append(node.surface)
        node = node.next
    return nouns

###メイン###
argv = sys.argv
dir = argv[1]
apcount={}
wordcounts={}

csv_path = dir + "cache/cache.csv"
data_path = dir + "cache/data.txt"
clust_path = dir + "cache/clust.txt"


print "==========="
print "generatorDocVector.py"
print "ディレクトリパス：" + dir
print "==========="
csv_file = open(csv_path)
list = [line for line in file (csv_path)]
line = csv.reader(csv_file,delimiter='\t')

for row in line:
    print row
    
    title,content = getDocument(row)
    wc=getWordcount(content)
    wordcounts[title]=wc
    for word,count in wc.items():
        apcount.setdefault(word,0)
        if count > 1:
            apcount[word]+=1
# 出現する単語の洗い出し
wordlist=[]
for w,bc in apcount.items():
    frac = float(bc)/len(list)
    if frac > 0.01 and frac < 0.99: #上限下限の設定
        wordlist.append(w)

#テキストファイルに書き出す
out=file(data_path,'w')
out.write('Blog')
for word in wordlist: out.write('\t%s' % word)
out.write('\n')
for blog,wc in wordcounts.items():
    out.write(blog)
    for word in wordlist:
        if word in wc: out.write('\t%d' % wc[word])
        else: out.write('\t0')
    out.write('\n')