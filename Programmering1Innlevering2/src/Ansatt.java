import java.util.*;

public class Ansatt extends Kort implements Konstanter {
	private int startTidAnsatt = 07, sluttTidAnsatt = 17;
	private double kreditt, timeLonn;

	public Ansatt() {
	}

	public Ansatt(String fulltNavn, int PIN) {
		super(fulltNavn, PIN);

	}

	public Ansatt(String fulltNavn, int PIN, boolean sperretKort) {
		super(fulltNavn, PIN, sperretKort);
	}

	@Override
	public boolean sjekkPIN(int PIN) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int hours = calendar.get(Calendar.HOUR_OF_DAY);

		if ((PIN == this.getPIN()) && (hours < startTidAnsatt) ^ (hours > sluttTidAnsatt))
			return true;
		else if (hours > startTidAnsatt && hours < sluttTidAnsatt)
			return true;
		else
			return false;
	}

	@Override
	public void settFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	@Override
	public void settEtternavn(String etternavn) {
		this.etternavn = etternavn;

	}

	@Override
	public void settFulltNavn(String fulltNavn) {
		this.fulltNavn = fulltNavn;

	}

	@Override
	public String hentFornavn() {
		String[] navn = hentFulltNavn().split("\\s");
		String fornavn = navn[0];
		String etternavn = navn[1];
		return fornavn;
	}

	@Override
	public String hentEtternavn() {
		String[] navn = hentFulltNavn().split("\\s");
		String fornavn = navn[0];
		String etternavn = navn[1];
		return etternavn;
	}

	@Override
	public String hentFulltNavn() {
		return fulltNavn;
	}

	@Override
	public double beregnKreditt() {
		return getTimelonn() * kreditt;
	}

	@Override
	public double beregnBonus() {

		return (kalender.getTimeInMillis() - System.currentTimeMillis()) * beregnKreditt();
	}

	public void setKreditt(double kreditt) {
		System.out.println("Sett bonus: ");
		java.util.Scanner input = new java.util.Scanner(System.in);
		kreditt = input.nextDouble();
	}

	public double getTimelonn() {
		return timeLonn;
	}

	public void setTimeLonn(double timelonn) {
		System.out.println("Hva er timelonnen?");
		Scanner input = new Scanner(System.in);
		timeLonn = input.nextDouble();
	}

}
