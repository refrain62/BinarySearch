package search.binary;

import java.util.Scanner;

public class App
{
	public static void main( String[] args )
	{
		// 標準入力を使う準備
		Scanner scanner = new Scanner(System.in);
		
		BinarySearch binarySearch = BinarySearch.getInstance();
		
		int result = BinarySearch.C_NOT_FOUND;
		
		// ※対象データはクイックソートなどで事前に昇順に並んでいる前提
		int[] searchData = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int searchVal = -999;
		String strDelimiter = "";
		
		// メッセージ表示
		System.out.println("Binary Search App Start!");
		System.out.print("Array Data is [");

		strDelimiter = "";
		
		for( int val : searchData )
		{
			System.out.print( strDelimiter + val );
			
			strDelimiter = ", ";
		}
		System.out.println("]");
		
		// キー入力（数値として）
		System.out.println("What is the search value of array data？");
		searchVal = scanner.nextInt();
		
		// 探索（とりあえず開始時は全範囲指定）
		result = binarySearch.execute(
										searchData,
										0,
										searchData.length - 1,
										searchVal
										);
		
		// 探索結果NG
		if(		BinarySearch.C_NOT_FOUND == result
			)
		{
			System.out.println("Data Not Found.");
		}
		// 探索OK
		else
		{
			System.out.println("Data Found. Array index is " + (result + 1) );	
		}
	}
}
