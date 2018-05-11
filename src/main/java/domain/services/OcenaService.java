package domain.services;

import java.util.List;
import domain.Film;
import domain.Ocena;
import domain.services.FilmService;
import java.util.ArrayList;

public class OcenaService {
	
	private static List<Ocena> dbOcen = new ArrayList<Ocena>();
	private static int currentId = 0;
	
	public void add(Ocena o) {
		o.setId(++currentId);
		dbOcen.add(o);
	}
	
	public float sredniaOcen(Ocena o) {
	o.setId(++currentId);
	dbOcen.add(o);
	
	 int suma = 0;
	 float srednia;
	 int i=0;
		for(;i<dbOcen.size();i++) {
			suma = suma + dbOcen.get(i).getOcena(); 
		}
		
	srednia = suma/i;
	return srednia;	
	}
	
	
}
