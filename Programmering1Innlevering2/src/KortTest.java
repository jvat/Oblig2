import java.util.ArrayList;
import java.util.Collections;

public class KortTest implements Cloneable {
	public static void main(String[] args) {
		ArrayList<Kort> kortArray = new ArrayList<>();
		Kort k1 = new Ansatt("Ole Olsen", 1234);
		Kort k2 = new Gjest("Marit Olsen", 9999);
		Kort k3 = new Ansatt("Jens Hansen", 3840);
		Kort k4 = new Gjest("Amalie Degode", 1234, true);
		kortArray.add(k1);
		kortArray.add(k2);
		kortArray.add(k3);
		kortArray.add(k4);
		for (Kort kort : kortArray) {
			System.out.println(kort);
			System.out.println("Kode 1234 er " + (kort.sjekkPIN(1234) ? "gyldig" : "ugyldig"));
			System.out.println("Kode 9999 er " + (kort.sjekkPIN(9999) ? "gyldig" : "ugyldig"));
		}

		ArrayList<Kort> kortArray2 = (ArrayList<Kort>) kortArray.clone(); 
		Collections.sort(kortArray2);
		System.out.println("\n" + kortArray2);

	}

}
