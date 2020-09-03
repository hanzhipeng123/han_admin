import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

/**
 *@author sunq
 *@date2020/7/24 18:12
 *@Description -Xms30m -Xmx30m -XX:PrintGCDetails    -Xss1m  -XX:+UseConcMarkSweepGC  -XX:-UseCompressedOops  -XX:MaxDirectMemorySize=100m
 */
public class TestOOM {


	public static void main(String[] args) throws InterruptedException {

	// 栈溢出
	// a();
		// 堆溢出
		// 35M的数组
//		String[] strArray = new String[35*1000*1000];

		// 堆溢出
		/*List<Object> list = new LinkedList<>();
		int i = 0;
		while (true){
			i++;
			if (i%1000==0) Thread.sleep(10);
			list.add(new Object());
		}*/

		// 堆外内存

		ByteBuffer buffer = ByteBuffer.allocateDirect(128*1024*1024);



	}


	static void a(){
		a();
	}

}
