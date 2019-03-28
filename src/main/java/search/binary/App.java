package search.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{
  public static void main( String[] args )
  {
    BinarySearch binarySearch = BinarySearch.getInstance();
    
    int result = BinarySearch.C_NOT_FOUND;
    int searchVal = -999;
    
    // 探索データの定義
    // ※対象データはクイックソートなどで事前に昇順に並んでいる前提
    int[] searchData = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    System.out.println("Binary Search App Start!");
    
    // 検索データの出力
    outputSearchData(
            searchData
            );
    
    // キー入力（数値として）
    searchVal = inputKeyValue();

    // 探索（とりあえず開始時は全範囲指定）
    result = binarySearch.execute(
                    searchData,
                    0,
                    searchData.length - 1,
                    searchVal
                    );
    
    // 結果の出力
    outputResult(
              result,
              BinarySearch.C_NOT_FOUND
              );
  }

  /**
   * 検索データの出力
   * @param argSearchData
   * @return
   */
  private static void outputSearchData(
                    int[] argSearchData
                    )
  {
    String strDelimiter = "";
    
    System.out.print("Array Data is [");

    strDelimiter = "";
    
    for( int val : argSearchData )
    {
      System.out.print( strDelimiter + val );
      
      strDelimiter = ", ";
    }
    
    System.out.println("]");
  }
  
  /**
   *  キー入力（数値として）
   * @return
   */
  private static int inputKeyValue()
  {
      String input = null;
      int number = 0;

    System.out.println("What is the search value of array data？");
    
      try
      {
          BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );
          
          input = bufferedReader.readLine();
          
          number = Integer.parseInt(input);
      }
      catch( NumberFormatException ex )
      {
         System.out.println("Not a number !");
      }
      catch( IOException e )
      {
          e.printStackTrace();
      }
      
      return number;
  }
  
  /**
   *  結果の出力
   * @param argResult
   * @param argNotFoundValue
   */
  private static void outputResult(
                int argResult,
                int argNotFoundValue
              )
  {
    // 探索結果NG
    if(   argNotFoundValue == argResult
      )
    {
      System.out.println("Data Not Found.");
    }
    // 探索OK
    else
    {
      System.out.println("Data Found. Array index is " + (argResult + 1) ); 
    }
  }
}
