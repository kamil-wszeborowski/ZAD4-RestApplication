package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.Film;
import domain.Komentarz;
import domain.Ocena;
import domain.services.FilmService;
import domain.services.OcenaService;

@Path("/filmy")
public class FilmResources {
	
	private FilmService db = new FilmService();
	private OcenaService dbOcen = new OcenaService();

	// 1
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Film> getAll(){
		return db.getAll();
	}
	
	// 2
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id){
		Film result = db.get(id);
		if(result == null) {
			return Response.status(404).build();
		}
		return Response.ok(result).build();
	}
	
	// 3
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Add(Film film) {
		db.add(film);
		return Response.ok(film.getId()).build();
	}
	
	// 4
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Film p){
		Film result = db.get(id);
		if(result == null) {
			return Response.status(404).build();
		}
		p.setId(id);
		db.update(p);
		return Response.ok().build();
	}
	
	// 5
	@GET
	@Path("/{filmId}/komentarze")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Komentarz> getKomentarze(@PathParam("filmId") int filmId){
		Film result = db.get(filmId);
		if(result == null) {
			return null;
		}
		if(result.getKomentarze()==null){
			result.setKomentarze(new ArrayList<Komentarz>());
		}
		return result.getKomentarze();
	}
	
	// 6
	@POST
	@Path("/{id}/komentarze")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addKomentarz(@PathParam("id") int filmId, Komentarz komentarz) {
		Film result = db.get(filmId);
		if(result==null) {
			return Response.status(404).build();	
		}
		if(result.getKomentarze()==null) {
			result.setKomentarze(new ArrayList<Komentarz>());
		}
		result.getKomentarze().add(komentarz);
		return Response.ok().build();
	}
	
	// 7
	@DELETE
	@Path("/{filmyId}/{id}/komentarze")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteKomentarz(@PathParam("filmId") int filmId, @PathParam("id") int id,Komentarz komentarz){
		Film film = db.get(filmId);
	
		if(film == null) {
			return Response.status(404).build();	
		}	
		film.removeKomentarze(id);
		return Response.ok().build();
	}
	
	/*
	// 8
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response dodanieOceny(@PathParam("id") int id, Ocena ocena) {
		Film film = db.get(id);
		float ocenka;
		ocenka=dbOcen.sredniaOcen(ocena);
		
		film.setId(id);
		db.updateOcena(film);
		return Response.ok().build();
	}
	*/
		
}
