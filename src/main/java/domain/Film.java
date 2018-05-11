package domain;

import java.util.List;

public class Film {
	private int id;
	private String tytul;
	private String gatunek;
	private float ocena;
	private List<Komentarz> komentarze;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTytul() {
		return tytul;
	}
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	
	
	public float getOcena() {
		return ocena;
	}
	public void setOcena(float ocena) {
		this.ocena = ocena;
	}
	public String getGatunek() {
		return gatunek;
	}
	public void setGatunek(String gatunek) {
		this.gatunek = gatunek;
	}
	public List<Komentarz> getKomentarze() {
		return komentarze;
	}
	public void setKomentarze(List<Komentarz> komentarze) {
		this.komentarze = komentarze;
	}
	
	public void removeKomentarze(int i) {
		 komentarze.remove(komentarze.get(i)) ;
	}
	
}
