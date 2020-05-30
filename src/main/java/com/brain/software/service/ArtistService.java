package com.brain.software.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brain.software.exception.RecordNotFoundException;
import com.brain.software.model.Artist;
import com.brain.software.repository.ArtistRepository;

@Service
public class ArtistService {
	
    @Autowired
    private ArtistRepository repository;
    
    
    public Artist createOrUpdateArtist(Artist entity) {
    	
    	
       if(entity.getArtistId()!=null) {
    	Optional<Artist> artist = repository.findById(entity.getArtistId());
       if(artist.isPresent()) 
        {
        	Artist newEntity = artist.get();
            newEntity.setGenres(entity.getGenres());
            newEntity.setTitle(entity.getTitle());
            newEntity.setYear(entity.getYear());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } 
       }else {
            entity = repository.save(entity);
        }
	return entity;
    }
    
   public Artist findByArtistId(Long artistId,Artist entity) throws RecordNotFoundException {
	   																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																			
	   Optional<Artist> artist = repository.findById(artistId);
       
       if(artist.isPresent()) {
   	         Artist newEntity = artist.get();
            newEntity.setGenres(entity.getGenres());
            newEntity.setTitle(entity.getTitle());
            newEntity.setYear(entity.getYear());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
       } else {
           throw new RecordNotFoundException("No artist record exist for given id");
       }
    	
	  
   }																																																	
   

   
   public List<Artist> findByArtistAll() {
	   	
	   
	   List<Artist> artistList = repository.findAll();
       
       if(artistList.size() > 0) {
           return artistList;
       } else {
           return new ArrayList<Artist>();
       }
	  
   }
   
   
 

}
