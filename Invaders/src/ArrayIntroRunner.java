import java.util.Arrays;

public class ArrayIntroRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 30;
		int y = 40;
		String str = "hi";
		
		double[] elements = new double[10];
		System.out.println(Arrays.toString(elements));
		elements[0] = 7;
		
		//make the last element 13
		elements[9] = 13;
		elements[elements.length - 1] = 13;
		
		//create an array fo 31 whole numbers
		
		// make the last one -1 w/o hardcoding the index
		int[] list = new int[31];
		
		for (int i = 0; i < list.length; i++) {
			list[i] = (int)(Math.random()*234255);
		}
		System.out.println(Arrays.toString(list));
	}

}
