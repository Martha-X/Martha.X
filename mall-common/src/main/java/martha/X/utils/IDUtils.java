package martha.X.utils;

import java.util.Random;


public class IDUtils {

	/**
	 * 图片名生成
	 */
	public static String getImageName() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足三位前面补0
		String str = millis + String.format("%03d", end3);
		
		return str;
	}
	
	/**
	 * 商品id生成
	 */
	public static long getItemId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		System.out.println(millis);
		//long millis = System.nanoTime();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		System.out.println(end2);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		System.out.println(str);
		long id = new Long(str);
		return id;
	}
	
	public static void main(String[] args) {
		System.out.println(getItemId());
	}
}
