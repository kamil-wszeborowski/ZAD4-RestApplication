package domain;

public class Ocena {
	
	private int id;
	private int idFilmu;
	private int ocena;
	
	public int getIdFilmu() {
		return idFilmu;
	}

	public void setIdFilmu(int idFilmu) {
		this.idFilmu = idFilmu;
	}

	public int getOcena() {
		return ocena;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	
}
