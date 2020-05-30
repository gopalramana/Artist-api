package com.brain.software.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.brain.software.exception.RecordNotFoundException;
import com.brain.software.model.Artist;
import com.brain.software.service.ArtistService;




@Path("/artists")
public class ArtistResource {
	
    @Autowired
    private ArtistService artistService;
	
	@GET
	@Produces("application/json")
    public ResponseEntity<List<Artist>> getArtist(){
		 
		List<Artist> list= artistService.findByArtistAll();
		 return new ResponseEntity<List<Artist>>(list, new HttpHeaders(), HttpStatus.OK);
    }
	
	
	@POST
	@Produces("application/json")
    public ResponseEntity<Artist> createOrUpdateArtist(Artist artist){
		
		Artist updated=artistService.createOrUpdateArtist(artist);
		return new ResponseEntity<Artist>(updated, new HttpHeaders(), HttpStatus.OK);
    }
	
	
	@PUT
	@Path("{artist}/{id}")
	@Consumes("application/json")
    @Produces("application/json")
	public ResponseEntity<Artist> updateArtist(@PathVariable long id,@RequestBody Artist artist) throws RecordNotFoundException {

		Artist artistNew = artistService.findByArtistId(Long.valueOf(id),artist);
		return new ResponseEntity<Artist>(artistNew, new HttpHeaders(), HttpStatus.OK);
	}
   


}
