
public interface Konstanter {
	public void settFornavn(String fornavn);
	public void settEtternavn(String etternavn);
	public void settFulltNavn(String fulltNavn);
	
	public String hentFornavn();
	public String hentEtternavn();
	public String hentFulltNavn();
	
	public double beregnKreditt();
	public double beregnBonus();
}
