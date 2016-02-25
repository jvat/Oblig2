import java.util.*;

public abstract class Kort implements Comparable<Kort>, Cloneable {
	public String fornavn, etternavn, fulltNavn;
	private int PIN;
	private static int kortNummer = 0;
	private int detteKortNummer;
	protected boolean sperretKort;
	protected Scanner input = new Scanner(System.in);
	protected Calendar kalender;
	private Date startDatoKort;

	protected Kort() {

	}

	protected Kort(String fulltNavn, int PIN) {
		this.fulltNavn = fulltNavn;
		this.PIN = PIN;
		this.detteKortNummer = kortNummer;
		kortNummer++;
		kalender = Calendar.getInstance();
		startDatoKort = kalender.getTime();

	}

	protected Kort(String fulltNavn, int PIN, boolean sperretKort) {
		this.fulltNavn = fulltNavn;
		this.PIN = PIN;
		this.detteKortNummer = kortNummer;
		kortNummer++;
		this.sperretKort = sperretKort;
		kalender = Calendar.getInstance();

	}

	public void settAlleDatamedlemmer() {
		System.out.println("Fornavn: ");
		this.fornavn = input.next();
		System.out.println("Etternavn: ");
		this.etternavn = input.next();
		System.out.println("Angi ny PIN: ");
		this.PIN = input.nextInt();
		sperretKort = false;

	}

	@Override
	public int compareTo(Kort k) {
		if (this.getEtternavn() != k.getEtternavn()) {

			if (this.getFornavn() != k.getFornavn())
				return this.getFornavn().compareTo(k.getFornavn());
			else
				return this.getEtternavn().compareTo(k.getEtternavn());

		} else {
			if (this.getFornavn() != k.getFornavn())
				return this.getFornavn().compareTo(k.getFornavn());
			else
				return 0;
		}

	}

	public String getFornavn() {
		String[] navn = hentFulltNavn().split("\\s");
		String fornavn = navn[0];
		// String etternavn = navn[1];
		return fornavn;
	}

	public String getEtternavn() {
		String[] navn = hentFulltNavn().split("\\s");
		// String fornavn = navn[0];
		String etternavn = navn[1];
		return etternavn;
	}

	public String hentFulltNavn() {
		return fulltNavn;
	}

	public boolean isSperret() {
		return sperretKort;
	}

	public abstract boolean sjekkPIN(int PIN);

	public int getPIN() {
		return PIN;
	}

	@Override
	public String toString() {
		return "\nNavn: " + fulltNavn + "\nPIN: " + PIN + "\nKortnummer: " + detteKortNummer + "\nAksesskode aktivert: "
				+ sperretKort + "\nKort opprettet: " + startDatoKort;
	}
}
