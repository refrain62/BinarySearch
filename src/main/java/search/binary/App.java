package search.binary;

import java.util.Scanner;

public class App
{
	public static void main( String[] args )
	{
		// �W�����͂��g������
		Scanner scanner = new Scanner(System.in);
		
		BinarySearch binarySearch = BinarySearch.getInstance();
		
		int result = BinarySearch.C_NOT_FOUND;
		
		// ���Ώۃf�[�^�̓N�C�b�N�\�[�g�ȂǂŎ��O�ɏ����ɕ���ł���O��
		int[] searchData = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int searchVal = -999;
		String strDelimiter = "";
		
		// ���b�Z�[�W�\��
		System.out.println("Binary Search App Start!");
		System.out.print("Array Data is [");

		strDelimiter = "";
		
		for( int val : searchData )
		{
			System.out.print( strDelimiter + val );
			
			strDelimiter = ", ";
		}
		System.out.println("]");
		
		// �L�[���́i���l�Ƃ��āj
		System.out.println("What is the search value of array data�H");
		searchVal = scanner.nextInt();
		
		// �T���i�Ƃ肠�����J�n���͑S�͈͎w��j
		result = binarySearch.execute(
										searchData,
										0,
										searchData.length - 1,
										searchVal
										);
		
		// �T������NG
		if(		BinarySearch.C_NOT_FOUND == result
			)
		{
			System.out.println("Data Not Found.");
		}
		// �T��OK
		else
		{
			System.out.println("Data Found. Array index is " + (result + 1) );	
		}
	}
}
