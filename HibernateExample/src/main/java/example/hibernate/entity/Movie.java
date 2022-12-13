package example.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie_master")
public class Movie {
	@Id
	@Column(name="movie_id", length=4)
	private String movieid;
	@Column(name="movie_title")
	private String title;
	@Column(name="movie_genre")
	private String genre;
	@Column(name="movie_year")
	private int year;
	
	
	
	@Override
	public String toString() {
		return "Movie [movieid=" + movieid + ", title=" + title + ", genre=" + genre + ", year=" + year + "]";
	}
	public Movie() {
		
	}
	public String getMovieid() {
		return movieid;
	}

	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Movie(String movieid, String title, String genre, int year) {
		super();
		this.movieid = movieid;
		this.title = title;
		this.genre = genre;
		this.year = year;
	}
	
	
	

}
