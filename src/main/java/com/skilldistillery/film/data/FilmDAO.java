package com.skilldistillery.film.data;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	public Film getFilmById(int filmId) throws SQLException;

	public List<Film> getFilmsByKeyword(String keyword) throws SQLException;

	public Actor getActorById(int actorId) throws SQLException;

	public List<Actor> getActorsByFilmId(int filmId) throws SQLException;

	public Film addFilm(Film film);
	
	public Film editFilm(Film film);
	
	public boolean deleteFilm(Film film);
}
