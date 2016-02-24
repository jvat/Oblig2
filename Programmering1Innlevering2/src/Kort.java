import java.util.*;

public abstract class Kort {
	protected String fornavn, etternavn;
	private int PIN;
	private static int kortNummer = 0;
	private int detteKortNummer;
	protected boolean sperretKort;
	protected Scanner input = new Scanner(System.in);
	protected Calendar kalender;
	private Date startDatoKort;
	
	protected Kort() {
		
	}
	protected Kort(String fornavn, int PIN) {
		this.fornavn = fornavn;
		this.PIN = PIN;
		this.detteKortNummer = kortNummer;
		kortNummer++;
		kalender = Calendar.getInstance();
		startDatoKort = kalender.getTime();
	}
	protected Kort(String fornavn, String etternavn, int PIN, boolean sperretKort) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
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
	
	public String getFornavn() {
		return fornavn;
	}

	public String getEtternavn() {
		return etternavn;
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
		return "\nNavn: " + fornavn + " " + etternavn + "\nPIN: "  + PIN + "\nKortnummer: " + detteKortNummer 
				+ "\nAksesskode aktivert: " + sperretKort + "\nKort opprettet:" + startDatoKort;
	}
}
