import java.util.ArrayList;
import java.util.Arrays;

public class Speler {

	ArrayList<int[]>[] worpGeschiedenis;
	
	
	public void addWorpToWorpGeschiedenis(int[] input) {
		ArrayList<int[]> temp = new ArrayList<>();
		temp.add(input);
		//worpGeschiedenis={input};
	}
	
	public void printWorpGeschiedenis() {
		System.out.println(Arrays.toString(worpGeschiedenis));
	}
}
