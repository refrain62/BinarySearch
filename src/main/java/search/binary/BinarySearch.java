package search.binary;

/*
���όv�Z�ʁF O(log2n)

�z����\�[�g����(�����Ń\�[�g����Ă���O��)
�z��̒����ɂ���v�f���擾
�����̗v�f������ł͂Ȃ��A�l���傫���ꍇ�͒�������ȍ~�̗v�f����T��
�����̗v�f����ł͂Ȃ��A�l���������ꍇ�͒�������ȑO�̗v�f����T��
�ړI�̗v�f��������Ȃ��ꍇ�́A�����̗v�f��T���Ƃ��납�瑱����
*/

public class BinarySearch
{
  // Singleton�p
  private static BinarySearch binarySearch = new BinarySearch(); 
  
  // ������Ȃ������ꍇ�̖߂�l
  public static int C_NOT_FOUND = -1;
  
  // �O������C���X�^���X���ł��Ȃ��悤�ɃR���X�g���N�^��private��
  private BinarySearch()
  { 
  }
  
  // �C���X�^���X��Ԃ�
  public static BinarySearch getInstance()
  {
    return binarySearch;
  }
  
  /**
   *  �T�����s
   * @param argData       �T���f�[�^�Q
   * @param argSearchIndexFrom  �T���J�n�ʒu
   * @param argSearchIndexTo    �T���I���ʒu
   * @param argVal        �ړI�f�[�^
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
      // �����̃C���f�b�N�X���Z�o
      middleIndex = argSearchIndexFrom + ((argSearchIndexTo - argSearchIndexFrom) / 2);

      // �������O�ɏo��
      System.out.println( "from : " + argSearchIndexFrom + " to : " + argSearchIndexTo + " middle : " + middleIndex + " val: " + argData[ middleIndex ] );
      
      // �����̃C���f�b�N�X�̒l����v�����ꍇ�͏I��
      if(   argData[ middleIndex ] == argVal
        )
      {
        return middleIndex;
      }
      
      // �ړI�̒l���������ꍇ
      if(   argData[ middleIndex ] > argVal
        )
      {
        // �O���̗v�f����ċA�T��
        return this.execute(
                  argData,
                  argSearchIndexFrom,
                  middleIndex - 1,
                  argVal
                  );
      }
      else
      {
        // �㔼�̗v�f����ċA�T��
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
