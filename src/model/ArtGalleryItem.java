package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artwork")

public class ArtGalleryItem {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="TITLE")
	private String title;
	@Column(name="ARTIST_NAME")
	private String artist;
	@Column(name="MEDIA")
	private String media;
	@Column(name="YEAR")
	private String year;
	@Column(name="VALUE")
	private double value;
	
	public ArtGalleryItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ArtGalleryItem(String title, String artist, String media, String year, double value) {
		super();
		this.title = title;
		this.artist = artist;
		this.media = media;
		this.year = year;
		this.value = value;
	}
	
	public ArtGalleryItem(String title, String artist, String year) {
		super();
		this.title = title;
		this.artist = artist;
		this.year = year;
	}

	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	} 
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "GalleryListItem [id=" + id + ", title=" + title + ", artist=" + artist + ", media=" + media + ", year="
				+ year + ", value=" + value + "]";
	}
	
	public String returnItemDetails() {
		return title + ":" + artist + ":" + media + ":" + year + ":" + value;
	}

}
