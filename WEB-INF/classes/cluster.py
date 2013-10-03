#-*- coding:utf-8 -*-
 
#
# K means clustering
#
# reference: Programming Collective Intelligence, Wikipedia
# 
 
from math import sqrt
import random
import sys

def readfile(filename):
    lines=[line for line in file(filename)]
    colnames=lines[0].strip().split('\t')[1:]
    rownames=[]
    data=[]
    for line in lines[1:]:
        p=line.strip().split('\t')
        rownames.append(p[0])
        # 行の残り部分がその行のデータ
        data.append([float(x) for x in p[1:]])
    return rownames,data

def pearson(p1,p2):
    # calculate p's variance
    sum1 = sum(p1)
    sum2 = sum(p2)
 
    sum1Sq = sum([pow(p,2) for p in p1])
    sum2Sq = sum([pow(p,2) for p in p2])
 
    pSum = sum([p1[i]*p2[i] for i in range(len(p1))])
 
    num = pSum-(sum1*sum2/len(p1))
    den=sqrt((sum1Sq-pow(sum1,2)/len(p1))*(sum2Sq-pow(sum2,2)/len(p1)))
    
    if den == 0: return 0
    return 1.0 - num/den

def kcluster(rows, distance=pearson, k=4):
    # Make k clusters with random
    ranges=[(min([row[i] for row in rows]), max([row[i] for row in rows])) for i in range(len(rows[0]))]
    clusters=[[random.random()*(ranges[i][1]-ranges[i][0])+ranges[i][0] for i in range(len(rows[0]))] for j in range(k)]
 
    lastmatches = None
    for t in range(100):
        print 'Iteration %d' % t
        bestmatches=[[] for i in range(k)]
 
        for j in range(len(rows)):
            row = rows[j]
            bestmatch = 0
            for i in range(k):
                d = distance(clusters[i], row)
                if d < distance(clusters[bestmatch], row):
                    bestmatch = i
            bestmatches[bestmatch].append(j)
 
        if bestmatches == lastmatches: break
        lastmatches = bestmatches
 
        for i in range(k):
            avgs = [0.0] * len(rows[0])
            if len(bestmatches[i]) > 0:
                for rowid in bestmatches[i]:
                    for m in range(len(rows[rowid])):
                        avgs[m] += rows[rowid][m]
                for j in range(len(avgs)):
                    avgs[j] /= len(bestmatches[i])
                clusters[i] = avgs
        #print bestmatches
    return bestmatches
 
if __name__ == '__main__':
    print "クラスタリング中"
    
    argv=sys.argv
    dir=argv[1]
    
    data_path = dir + "cache/data.txt"
    clust_path = dir + "cache/clust.txt"
    
    blognames,data=readfile(data_path)
    kclust = kcluster(data, k=4)
    
    '---ファイル書き出し---'
    f=open(clust_path,'w')
    for n in range(4):
        for i in [blognames[r] for r in kclust[n]]:
            f.write(i+"\t")
            f.write(str(n)+"\n")
    f.close()    
    #print [blognames[r] for r in kclust[0]]