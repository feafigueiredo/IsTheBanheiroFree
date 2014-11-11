package br.com.gft.model;

public class EstadoRecebido {
	private boolean masculino;
	private boolean feminino;
	
	public boolean isMasculino() {
		return masculino;
	}
	public void setMasculino(boolean masculino) {
		this.masculino = masculino;
	}
	public boolean isFeminino() {
		return feminino;
	}
	public void setFeminino(boolean feminino) {
		this.feminino = feminino;
	}

	
	@Override
	public String toString() {
		return "masculino : " + masculino +
			 "\nfeminino : " + feminino;
	}
}
