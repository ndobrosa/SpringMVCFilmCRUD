package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Repository
public class FilmDAOImpl implements FilmDAO {
	
	private final String user = "student";
	private final String pass = "student";
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";


	@Override
	public Film getFilmById(int filmId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film addFilm(Film newFilm) {
		Connection conn = null;
		int updateCount;
		String sql = "INSERT INTO film (title, description, release_year, language_id, length, special_features)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, newFilm.getTitle());
			stmt.setString(2, newFilm.getDescription());
			stmt.setInt(3, newFilm.getRelease_year());
			stmt.setInt(4, newFilm.getLanguage_id());
			stmt.setString(5, newFilm.getLength());
			stmt.setString(6, newFilm.getSpecial_features());
			// might need to set more parameters here
			updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int newFilmId = keys.getInt(1);
					newFilm.setId(newFilmId);
				}
				
			} else {
				newFilm = null;
			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e2) {
					System.err.println("Error while rolling back");
				}
			}
			throw new RuntimeException("Error while adding the film: " + newFilm);
		}
		return newFilm;
	}
      
	@Override
	public List<Film> getFilmByKeyword(String keyword) throws SQLException {
		List<Film> films = new ArrayList<>();

		String sql = "SELECT film.id, title, description, release_year, rating, language_id, language.name "
				+ "FROM film " + "JOIN language on language.id = film.language_id " + "WHERE title like ? "
				+ "OR description like ?";

		Connection conn = DriverManager.getConnection(URL, user, pass);
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%" + keyword + "%");
		stmt.setString(2, "%" + keyword + "%");

		ResultSet filmResult = stmt.executeQuery();
		int counter = 0;

		while (filmResult.next()) {
			Film film = new Film();
			film.setId(filmResult.getInt("id"));
			film.setTitle(filmResult.getString("title"));
			film.setDescription(filmResult.getString("description"));
			film.setRelease_year(filmResult.getInt("release_year"));
			film.setRating(filmResult.getString("rating"));
			film.setLanguage_id(filmResult.getInt("language_id"));
			film.setLanguage_name(filmResult.getString("language.name"));
			film.setActors(getActorsByFilmId(filmResult.getInt("id")));
			films.add(film);

			System.out.println(film + "\n");
			System.out.println(
					"------------------------------------------------------------------------------------------");
			counter++;
		}

		if (films.isEmpty()) {
			System.out
					.println("\nWe apologize, but there is no title or description with that keyword in our library.");
		}

		filmResult.close();
		stmt.close();
		conn.close();
		System.out.println("Your search returned " + counter + " results.");
		return films;
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
