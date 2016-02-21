import java.util.Scanner;

public abstract class Kort {
	private String fornavn, etternavn;
	private int PIN;
	private int kortNummer = 0;
	private boolean sperretKort;
	
	protected Scanner input = new Scanner(System.in);
	
	protected Kort() {
		
	}
	
	protected Kort(String fornavn, String etternavn, int PIN, int kortNummer, boolean sperretKort) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.PIN = PIN;
		this.kortNummer = kortNummer;
		this.sperretKort = sperretKort;
		
	}
	public void settAlleDatamedlemmer() {
		System.out.println("Fornavn: ");
		this.fornavn = input.next();
		System.out.println("Etternavn: ");
		this.etternavn = input.next();
		System.out.println("Angi ny PIN: ");
		this.PIN = input.nextInt();
		sperretKort = false;
		kortNummer = kortNummer++;
		
	}
	
	public String getFornavn() {
		return fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}
	
	public boolean isSperret() {
		if (sperretKort) 
			return true;
		else
			return false;
	}
	
	public abstract boolean sjekkPIN(int PIN);
	
	@Override
	public String toString() {
		return "Navn: " + fornavn + " " + etternavn + "PIN: "  + PIN + "Kortnummer: " + kortNummer 
				+ "Aksesskode aktivert: " + sperretKort;
	}
}
