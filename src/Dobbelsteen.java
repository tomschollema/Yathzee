import java.util.Random;

public class Dobbelsteen {
	int resultaatDobbel;

	public int werpen() {
		Random random = new Random();
		int randomNumber = random.nextInt(6)+1;
		this.resultaatDobbel = randomNumber;
		return randomNumber;
	}
}
