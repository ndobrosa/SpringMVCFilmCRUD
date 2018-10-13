package com.skilldistillery.film.entities;

import java.util.List;

import javax.validation.constraints.Size;

public class Film {
	private int id;
	private String title;
	private String description;
	@Size(min=1901, max=2155)
	private int release_year;
	private int language_id;
	private String language_name;
	private String rental_duration;
	private double rental_rate;
	private String length;
	private String category;
	private String media_condition;
	private List<Actor> actors;

	public Film() {

	}

	public Film(int id, String title, String description, int release_year, int language_id, String language_name,
			String rental_duration, double rental_rate, String length, String category, String media_condition, double replacement_cost, String rating,
			String special_features) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.release_year = release_year;
		this.language_id = language_id;
		this.language_name = language_name;
		this.rental_duration = rental_duration;
		this.rental_rate = rental_rate;
		this.length = length;
		this.category = category;
		this.media_condition = media_condition;
		this.replacement_cost = replacement_cost;
		this.rating = rating;
		this.special_features = special_features;
	}
	
	
	

	public Film(String title, String description, int release_year, String length, String special_features) {
		super();
		this.title = title;
		this.description = description;
		this.release_year = release_year;
		this.length = length;
		this.special_features = special_features;
		
	}

	public Film(String media_condition) {
		super();
		this.media_condition = media_condition;
	}

	private double replacement_cost;
	private String rating;
	private String special_features;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRelease_year() {
		return release_year;
	}

	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}

	public int getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}

	public String getRental_duration() {
		return rental_duration;
	}

	public void setRental_duration(String rental_duration) {
		this.rental_duration = rental_duration;
	}

	public double getRental_rate() {
		return rental_rate;
	}

	public void setRental_rate(double rental_rate) {
		this.rental_rate = rental_rate;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public double getReplacement_cost() {
		return replacement_cost;
	}

	public void setReplacement_cost(double replacement_cost) {
		this.replacement_cost = replacement_cost;
	}

	public String getRating() {
		return rating;
	}
	public String getMedia_condition() {
		return media_condition;
	}

	public String getSpecial_features() {
		return special_features;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}

	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}

	@Override
	public String toString() {
		return "\nFilm ID: " + id + "\nTitle: " + title + "\nYear Released: " + release_year + "\nDescription: "
				+ description + "\nRating: " + rating + "\nLanguage: " + language_name + "\nActors: " + printActors();
	}
	
	public String toStringAllDetails() {
		return "\nFilm ID: " + id + "\nTitle: " + title + "\nYear Released: " + release_year + "\nDescription: "
				+ description + "\nRating: " + rating + "\nLanguage ID: " + language_id + "\nLanguage: " + language_name + "\nCategory: " + category + 
				"\nRental Rate: $" + rental_rate + "\nFilm Length: " + length + " Minutes"+ "\nReplacement Cost: $" + replacement_cost + 
				"\nSpecial Features: " + special_features + "\nCondition: " + media_condition + "\nActors: " + printActors();
	}

	public String printActors() {
		List<Actor> printActors = this.actors;
		String actorString = "";
		for (Actor actor : printActors) {
			actorString += actor.getFirst_name() + " " + actor.getLast_name() + " | ";
		}
		return actorString;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public String getLanguage_name() {
		return language_name;
	}

	public void setLanguage_name(String language_name) {
		this.language_name = language_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public void setMedia_condition(String media_condition) {
		this.media_condition = media_condition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + language_id;
		result = prime * result + ((language_name == null) ? 0 : language_name.hashCode());
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + release_year;
		result = prime * result + ((rental_duration == null) ? 0 : rental_duration.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rental_rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(replacement_cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((special_features == null) ? 0 : special_features.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Film other = (Film) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (language_id != other.language_id)
			return false;
		if (language_name == null) {
			if (other.language_name != null)
				return false;
		} else if (!language_name.equals(other.language_name))
			return false;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (release_year != other.release_year)
			return false;
		if (rental_duration == null) {
			if (other.rental_duration != null)
				return false;
		} else if (!rental_duration.equals(other.rental_duration))
			return false;
		if (Double.doubleToLongBits(rental_rate) != Double.doubleToLongBits(other.rental_rate))
			return false;
		if (Double.doubleToLongBits(replacement_cost) != Double.doubleToLongBits(other.replacement_cost))
			return false;
		if (special_features == null) {
			if (other.special_features != null)
				return false;
		} else if (!special_features.equals(other.special_features))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}