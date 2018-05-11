package domain.services;

import java.util.List;
import domain.Film;
import java.util.ArrayList;

public class FilmService {
	
	public static List<Film> db = new ArrayList<Film>();
	private static int currentId = 0;
	
	public List<Film> getAll(){
		return db;
	}
	
	public Film get(int id) {
		for(Film p : db) {
			if(p.getId()==id)
				return p;
		}
		return null;
	}
	
	public void add(Film p) {
		p.setId(++currentId);
		db.add(p);
	}
	
	public void update(Film film) {
		for(Film p : db) {
			if(p.getId()==film.getId()) {
				p.setTytul(film.getTytul());
				p.setGatunek(film.getGatunek());
				//p.setOcena(film.getOcena());
			}
		}
	}
	
	public void delete(Film p) {
		db.remove(p);
	}
	
	public void updateOcena(Film film) {
		for(Film p : db) {
			if(p.getId()==film.getId()) {
				//p.setTytul(film.getTytul());
				//p.setGatunek(film.getGatunek());
				p.setOcena(film.getOcena());
			}
		}
	}
	
	
}
