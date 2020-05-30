package com.brain.software.model;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name="ARTIST")
public class Artist implements Serializable{
  

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long artistId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="year")
	private String year;
	
	@Column(name="genres")
	private String genres;
	
	 @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	 @JoinColumn(name="ARTIST_ID")
	 private Set<Albumb> albumb;
	
	
	public Long getArtistId() {
		return artistId;
	}
	public void setArtistId(Long albumId) {
		this.artistId = albumId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	
		
	public Set<Albumb> getAlbumb() {
		return albumb;
	}
	public void setAlbumb(Set<Albumb> albumb) {
		this.albumb = albumb;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (artistId ^ (artistId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artist other = (Artist) obj;
		if (artistId != other.artistId)
			return false;
		return true;
	}
	
	
	
	
}
