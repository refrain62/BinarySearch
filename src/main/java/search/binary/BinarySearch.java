package search.binary;

/*
平均計算量： O(log2n)

配列をソートする(昇順でソートされている前提)
配列の中央にある要素を取得
中央の要素が同一ではなく、値が大きい場合は中央から以降の要素から探す
中央の要素同一ではなく、値が小さい場合は中央から以前の要素から探す
目的の要素が見つからない場合は、中央の要素を探すところから続ける
*/

public class BinarySearch
{
  // Singleton用
  private static BinarySearch binarySearch = new BinarySearch(); 
  
  // 見つからなかった場合の戻り値
  public static int C_NOT_FOUND = -1;
  
  // 外部からインスタンス化できないようにコンストラクタをprivate化
  private BinarySearch()
  { 
  }
  
  // インスタンスを返す
  public static BinarySearch getInstance()
  {
    return binarySearch;
  }
  
  /**
   *  探索実行
   * @param argData       探索データ群
   * @param argSearchIndexFrom  探索開始位置
   * @param argSearchIndexTo    探索終了位置
   * @param argVal        目的データ
   * @return
   */
  public int execute(
            int[] argData,
            int argSearchIndexFrom,
            int argSearchIndexTo,
            int argVal
            )
  {
    int middleIndex = 0;
    
    if(   argData != null
      &&  argSearchIndexFrom <= argSearchIndexTo
      )
    {
      // 中央のインデックスを算出
      middleIndex = argSearchIndexFrom + ((argSearchIndexTo - argSearchIndexFrom) / 2);

      // 情報をログに出力
      System.out.println( "from : " + argSearchIndexFrom + " to : " + argSearchIndexTo + " middle : " + middleIndex + " val: " + argData[ middleIndex ] );
      
      // 中央のインデックスの値が一致した場合は終了
      if(   argData[ middleIndex ] == argVal
        )
      {
        return middleIndex;
      }
      
      // 目的の値が小さい場合
      if(   argData[ middleIndex ] > argVal
        )
      {
        // 前半の要素から再帰探索
        return this.execute(
                  argData,
                  argSearchIndexFrom,
                  middleIndex - 1,
                  argVal
                  );
      }
      else
      {
        // 後半の要素から再帰探索
        return this.execute(
                  argData,
                  middleIndex + 1,
                  argSearchIndexTo,
                  argVal
                  );
      }
    }
    
    return C_NOT_FOUND;
  }
}
