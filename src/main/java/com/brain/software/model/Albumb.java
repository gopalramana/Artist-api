package com.brain.software.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ALBUMB")
public class Albumb implements Serializable {
	
	 private static final long serialVersionUID = -6790693372846798580L;
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID", unique = true, nullable = false)
	    private Integer albumbId;
	 
	    @Column(name = "ALBUMB_NAME", unique = true, nullable = false, length = 100)
	    private String albumbName;
	 
	    @ManyToOne
	    private Artist artist;

		public Integer getAlbumbId() {
			return albumbId;
		}

		public void setAlbumbId(Integer albumbId) {
			this.albumbId = albumbId;
		}

		public String getAlbumbName() {
			return albumbName;
		}

		public void setAlbumbName(String albumbName) {
			this.albumbName = albumbName;
		}

		public Artist getArtist() {
			return artist;
		}

		public void setArtist(Artist artist) {
			this.artist = artist;
		}
	    
	    

}
