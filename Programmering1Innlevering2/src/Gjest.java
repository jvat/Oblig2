import java.util.*;

public class Gjest extends Kort {
	
	public Gjest() {
	}
	
	protected Gjest(String fornavn, int PIN) {
		super(fornavn, PIN);
	}
	
	public Gjest(String fornavn, String etternavn, int PIN, boolean sperretKort) {
		super(fornavn, etternavn, PIN, sperretKort);
		
	}
	public void setAlleDatamedlemmer() {
		super.settAlleDatamedlemmer();
		setSperret();
	}
	
	public Date getUtlopsDatoGjesteKort() {
		kalender.add(Calendar.DAY_OF_MONTH, 7);
		Date utlopsDatoGjesteKort = kalender.getTime();
	 	return utlopsDatoGjesteKort;
	}
	
	public void setSperret() {
		if (Calendar.getInstance().after(getUtlopsDatoGjesteKort()))
			sperretKort = false;
		else
			sperretKort = true;
	}
	
	@Override
	public boolean sjekkPIN(int PIN) {
		setSperret();
		if (PIN == 9999 && sperretKort)
			return true;
		else
			return false;
	}
	
}
