package com.skilldistillery.film.data;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public class FilmDAOImpl implements FilmDAO {

	@Override
	public Film getFilmById(int filmId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film addFilm(Film film) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Film> getFilmByKeyword(String keyword) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Actor getActorById(int actorId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Actor> getActorsByFilmId(int filmId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Film> getFilmsByActorId(int actorId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
