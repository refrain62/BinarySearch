# Binary Search  
***

## 平均計算量： O(log2n)  
***

* 配列をソートする(昇順でソートされている前提)  
* 配列の中央にある要素を取得  
* 中央の要素が同一ではなく、値が大きい場合は中央から以降の要素から探す  
* 中央の要素同一ではなく、値が小さい場合は中央から以前の要素から探す  
* 目的の要素が見つからない場合は、中央の要素を探すところから続ける  

## 実行ログ
***

Binary Search App Start!  
Array Data is [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]  
What is the search value of array data？  
8  
from : 0 to : 9 middle : 4 val: 5  
from : 5 to : 9 middle : 7 val: 8  
Data Found. Array index is 8  

