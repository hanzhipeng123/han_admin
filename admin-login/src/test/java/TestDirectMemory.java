import java.nio.ByteBuffer;

/**
 *@author sunq
 *@date2020/7/24 18:26
 *@Description
 */
public class TestDirectMemory {

	public static void main(String[] args) {

//		ByteBuffer buffer = ByteBuffer.allocateDirect(128*1024*1024);

//		String a = new String("abc").intern();
		String a = "abc";
		String b = new String("abc").intern();


		if (a == b){
			System.out.println(1);
		}else {
			System.out.println(2);
		}



	}
}
