package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	FilmDAO dao;

	@RequestMapping("index.do")
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView("WEB-INF/views/home.jsp");
		return mv;
	}

	@RequestMapping(path = "editFilm.do", params = "id", method = RequestMethod.GET)
	public ModelAndView editPage(String id) {
		ModelAndView mv = new ModelAndView();
		int filmId = Integer.parseInt(id);
		Film film = null;
		try {
			film = dao.getFilmById(filmId);
			mv.addObject("film", film);
			mv.setViewName("WEB-INF/views/editFilm.jsp");

		} catch (SQLException e) {
			mv.addObject("actors", film.getActors());
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(path = "editFilmInfo.do", params = { "id", "title", "year", "rating", "description", "language_id",
			"rate", "length", "category", "features", "media", }, method = RequestMethod.POST)
	public ModelAndView editFilm(int id, String title, int year, String rating, String description, String language_id,
			Double rate, String length, String category, String features, String media) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/result.jsp");
		Film film = null;
		int langid = Integer.parseInt(language_id);

		try {
			film = dao.getFilmById(id);
			film.setId(id);
			if (title != null && !title.isEmpty() && title.length() < 250) {
				film.setTitle(title);
			}
			if (year >= 1901 && year <= 2155) {
				film.setRelease_year(year);
			}
			if (rating != null && !rating.equals("None")) {
				film.setRating(rating);
			}
			if (description != null && !description.isEmpty()) {
				film.setDescription(description);
			}
			film.setLanguage_id(langid);
			if (rate != null) {
				film.setRental_rate(rate);
			}
			if (length != null && !length.isEmpty()) {
				film.setLength(length);
			}
			film.setCategory(category);
			if (features != null && !features.isEmpty()) {
				film.setSpecial_features(features);
			}
			film.setMedia_condition(media);

			if (dao.editFilm(film) != null) {
				mv.addObject(film);
				mv.setViewName("WEB-INF/views/result.jsp");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mv;
	}

	@RequestMapping(path = "searchById.do", params = "searchID", method = RequestMethod.GET)
	public ModelAndView getFilmById(String searchID) {
		ModelAndView mv = new ModelAndView();
		int filmId = Integer.parseInt(searchID);
		Film film = new Film();
		try {
			film = dao.getFilmById(filmId);
			mv.addObject("film", film);
			mv.setViewName("WEB-INF/views/result.jsp");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mv;
	}

	@RequestMapping(path = "searchByKeyword.do", params = "searchKeyword", method = RequestMethod.GET)
	public ModelAndView getFilmByKeyword(String searchKeyword) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = new ArrayList<>();
		films = null;
		try {
			films = dao.getFilmsByKeyword(searchKeyword);
			mv.addObject("films", films);
			mv.setViewName("WEB-INF/views/result.jsp");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mv;

	}

	@RequestMapping(path = "addFilm.do", params = { "title", "description", "release_year",
			"length" }, method = RequestMethod.POST)
	public ModelAndView addFilmToDB(String title, String description, int release_year, String length)
			throws SQLException {
		ModelAndView mv = new ModelAndView();
		Film film = null;
		if (validInputs(title, description, release_year, length)) {

			film = new Film(title, description, release_year, length);
			System.out.println(title + " " + description + " " + length + " " + release_year);
			film = dao.addFilm(film);
			mv.addObject("film", film);
			mv.setViewName("WEB-INF/views/result.jsp");

		}

		else {
			mv.addObject("filmFailed", new Boolean(true));
			mv.setViewName("WEB-INF/views/home.jsp");
			return mv;
		}

		return mv;
	}

	@RequestMapping(path = "deleteFilm.do", params = "id", method = RequestMethod.GET)
	public ModelAndView deleteFilmFromDb(String id) {
		ModelAndView mv = new ModelAndView();
		int filmId = Integer.parseInt(id);

		try {
			Film film = dao.getFilmById(filmId);
			boolean filmDeleted = dao.deleteFilm(film);

			if (filmDeleted) {
				mv.setViewName("WEB-INF/views/home.jsp");
			} else {

				mv.setViewName("WEB-INF/views/home.jsp");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mv;

	}

	private boolean validInputs(String title, String description, Integer release_year, String length) {
		System.out.println((title != null && !title.isEmpty()) && (description != null && !description.isEmpty())
				&& (release_year != null && release_year < 2156 && release_year > 1900)
				&& (length != null && !length.isEmpty()));

		return ((title != null && !title.isEmpty()) && (description != null && !description.isEmpty())
				&& (release_year != null && release_year < 2156 && release_year > 1900)
				&& (length != null && !length.isEmpty()));

	}
}