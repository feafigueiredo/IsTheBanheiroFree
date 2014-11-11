package br.com.gft.model;

import java.util.Calendar;

public class EstadoBanheiro {
	private static EstadoBanheiro estado;
	private boolean masculino;
	private boolean feminino;
	private String updated;
	
	private EstadoBanheiro(){
		masculino = false;
		feminino = false;
		atualizado();
	}
	
	public static EstadoBanheiro getInstance(){
		if(estado == null){
			estado = new EstadoBanheiro();
		}
		
		return estado;
	}

	public boolean isMasculino() {
		return masculino;
	}

	public void setMasculino(boolean masculino) {
		atualizado();
		this.masculino = masculino;
	}

	public boolean isFeminino() {
		return feminino;
	}

	public void setFeminino(boolean feminino) {
		atualizado();
		this.feminino = feminino;
	}

	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	
	private void atualizado() {
		Calendar myTime = Calendar.getInstance();
		StringBuilder sb = new StringBuilder();

		sb.append(myTime.get(Calendar.DATE));
		sb.append("/");
		sb.append(myTime.get(Calendar.MONTH));
		sb.append("/");
		sb.append(myTime.get(Calendar.YEAR));
		sb.append(" - ");
		sb.append(myTime.get(Calendar.HOUR_OF_DAY));
		sb.append(":");
		sb.append(myTime.get(Calendar.MINUTE));
		
		setUpdated(sb.toString());
		
	}
	
	
	@Override
	public String toString(){
		return "{\"masculino\": \"" + masculino + "\", \"feminino\": \"" + feminino + "\", \"atualizacao\" : \"" + updated +"\"}";
	}
	
	
}
