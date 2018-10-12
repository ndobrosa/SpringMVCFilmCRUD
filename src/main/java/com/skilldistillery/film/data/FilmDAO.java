package com.skilldistillery.film.data;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	public Film getFilmById(int filmId) throws SQLException;
	public Film addFilm(Film film);
	public List<Film> getFilmsByKeyword(String keyword) throws SQLException;
}
