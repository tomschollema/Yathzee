import java.util.*;

public class YathzeeSpel {
	ArrayList<Dobbelsteen> dobbelArray = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	Speler speler = new Speler();

	// blokkeerArray - 1 = vastHouden dobbelsteen.
	int[] blokkeerArray = { 0, 0, 0, 0, 0 };

	int aantalWorpen;

	public YathzeeSpel() {
		for(int i = 0; i<5;i++) {
			//Dobbelsteen dobbelsteen = new Dobbelsteen();
			dobbelArray.add(new Dobbelsteen());
		}
		run();
//		Dobbelsteen dobbelsteen1 = new Dobbelsteen();
//		dobbelArray.add(new Dobbelsteen());
//		Dobbelsteen dobbelsteen2 = new Dobbelsteen();
//		dobbelArray.add(new Dobbelsteen());
//		Dobbelsteen dobbelsteen3 = new Dobbelsteen();
//		dobbelArray.add(new Dobbelsteen());
//		Dobbelsteen dobbelsteen4 = new Dobbelsteen();
//		dobbelArray.add(new Dobbelsteen());
//		Dobbelsteen dobbelsteen5 = new Dobbelsteen();
//		dobbelArray.add(new Dobbelsteen());

	}

	public void run() {
		System.out.println("Druk op enter om te dobbelen. Wil je na je eerste worp stoppen? Druk op q.");
		innerRun();
	}

	public void innerRun() {
		String input = " ";

		while (!input.equals("q")) {
			input = scanner.nextLine();
			// if statement als iemand q invoert de speler bedanken.
			if (input.equals("q")) {
				System.out.println("Bedankt voor het spelen");
				// else: roep werpen() aan op iedere dobbelsteen in de dobbelArray.
			} else {
				dobbelsteenWerpen();
			}
		}
	}

	public void dobbelsteenWerpen() {
		// aanmaken object van Klasse worp. In dit object zit een array van het type int
		// met daarin de worpuitslag.
		Worp worp = new Worp();

		// voor ieder dobbelsteen in de dobbelArray (5 doppelstenen) controleer de
		// waarde in de blokkeerArray.
		// Als de waarde 0 is, dan gooi de dobbelstenen. Anders print het resultaat van
		// de dobbel.
		for (Dobbelsteen dobbelsteen : dobbelArray) {
			int i=dobbelArray.indexOf(dobbelsteen);
			if (blokkeerArray[dobbelArray.indexOf(dobbelsteen)] == 0) {
				System.out.print(dobbelsteen.werpen() + " ");
			} else {
				System.out.print(dobbelsteen.resultaatDobbel + " ");
			}
			blokkeerArray[i] = 0;
			// voeg de uitslag van de dobbelsteen toe aan de array worpuitslag.
			worp.addWorpUitslag(dobbelsteen.resultaatDobbel, dobbelArray.indexOf(dobbelsteen));
		}
		// print lege line voor verbeterde userexperience
		System.out.println(" ");
		// aantal worpen dat in de ronde gespeeld is +1.
		aantalWorpen++;
		System.out.println("aantalWorpen:" + aantalWorpen);
		System.out.println("worp.worpUitslag (array) = " + Arrays.toString(worp.worpUitslag));
		// Roep de methode vastHouden() aan. Deze methode geeft na elke worp de
		// mogelijkheid om aan te geven welke dobbelstenen je wilt vasthouden.
		if (aantalWorpen == 3) {
			System.out.println("aantalworpen == 3");
			speler.addWorpToWorpGeschiedenis(worp.worpUitslag);
			System.out.println("speler.printWorpGeschiedenis: ");
			speler.printWorpGeschiedenis();
			
			this.aantalWorpen = 0;
			blokkeerArray[0] = 0;
			blokkeerArray[1] = 0;
			blokkeerArray[2] = 0;
			blokkeerArray[3] = 0;
			blokkeerArray[4] = 0;
			System.out.println("Nieuwe ronde, nieuwe kansen");
			System.out.println(" ");
			dobbelsteenWerpen();
			//new YathzeeSpel();
		} else {
			System.out.println("aantalworpen<3");
		}
		vastHouden();
	}

	public void loopTweederonde() {
		for (int i = 0; i < dobbelArray.size(); i++) {
			if (blokkeerArray[i] == 1) {

			}
		}
	}

	public void vastHouden() {
		System.out.println("Kies welke dobbelstenen je wilt vasthouden en druk op enter. Bijvoorbeeld: 123 Enter.");
		String input = scanner.nextLine();
		for (int i = 0, j = 1; i < input.length(); i++, j++) {
			String singleInput = input.substring(i, j);
			int k = Integer.parseInt(singleInput);

			switch (k) {
			case 1:
				blokkeerArray[0] = 1;
				// System.out.println(blokkeerArray[0]);
				break;
			case 2:
				blokkeerArray[1] = 1;
				// System.out.println(blokkeerArray[1]);
				break;
			case 3:
				blokkeerArray[2] = 1;
				// System.out.println(blokkeerArray[2]);
				break;
			case 4:
				blokkeerArray[3] = 1;
				// System.out.println(blokkeerArray[3]);
				break;
			case 5:
				blokkeerArray[4] = 1;
				// System.out.println(blokkeerArray[4]);
				break;
			default:
				System.out.println("default");
			}
		}
		System.out.println(Arrays.toString(blokkeerArray));
	}

}
