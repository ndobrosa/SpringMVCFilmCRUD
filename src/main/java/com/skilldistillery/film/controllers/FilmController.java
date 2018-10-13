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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(path = "editFilmInfo.do", params = { "title", "description", "year", "length",
			"features", "rating", "language_id", "duration", "rate", "category",
			"media", "id" }, method = RequestMethod.GET)
	public ModelAndView editFilm(String title, String description, int year, String length,
			String features, String rating, int language_id, String duration, double rate, String category,
			String media, int id) {
		ModelAndView mv = new ModelAndView();
		Film film = null;
		
		try {
			film = dao.getFilmById(id);
			System.out.println(features);
//			if (title != null && title != "" && title.length()<255) {
//				film.setTitle(title);
//			}
//			if (description != null && description != "") {
//				film.setDescription(description);
//			}
//			if ( year >= 1901 && year <= 2155) {
//				film.setRelease_year(year);
//			}
//			if (length != null && length != "") {
//				film.setLength(length);
//			}
//			
//			
//			if (features != null && features != "") {
//				film.setSpecial_features(features);
//			}
//			
//			
//			
//			if (rating != null && rating != "") {
//				film.setRating(rating);
//			}
//			if (language_id > 0 && language_id <7) {						//Add top limit
//				film.setLanguage_id(language_id);
//			}
//			
//			try {
//			if (duration != null && duration != "" && Integer.parseInt(duration) < 255 && Integer.parseInt(duration) > 0) {
//				film.setRental_duration(duration);
//			}
//			}
//			catch (NumberFormatException e) {
//			}
//			
//			if (rate > 0) {
//				film.setRental_rate(rate);
//			}
//			
//			if (category != null && category != "") {
//				film.setCategory(category);
//			}
//			
//			if (media != null && media != "") {
//				film.setMedia_condition(media);
//			}
//			
//			film =dao.editFilm(film);
//			mv.addObject("film", film);
//			mv.setViewName("WEB-INF/views/result.jsp");
//			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return mv;
	}

	@RequestMapping(path = "searchById.do", params = "searchID", method = RequestMethod.GET)
	public ModelAndView getFilmById(String searchID) {
		ModelAndView mv = new ModelAndView();
		int filmId = Integer.parseInt(searchID);
		Film film = null;
		try {
			film = dao.getFilmById(filmId);
			mv.addObject("film", film);
			mv.setViewName("WEB-INF/views/result.jsp");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	@RequestMapping(path = "addFilm.do", params = { "title", "description", "release_year", "length",
			"special_features" }, method = RequestMethod.GET)
	public ModelAndView addFilmToDB(String title, String description, int release_year, String length,
			String special_features) {
		ModelAndView mv = new ModelAndView();
		Film film = null;
		if (validInputs(title, description, release_year, length, special_features)) {

			film = new Film(title, description, release_year, length, special_features);
			System.out.println(title + " " + description + " " + length + " " + release_year + " " + special_features);
			dao.addFilm(film);
			mv.addObject("film", film);
			mv.setViewName("WEB-INF/views/result.jsp");

		}
		
		else {
			mv.addObject("filmFailed",new Boolean(true));
			mv.setViewName("WEB-INF/views/result.jsp");
			return mv;
		}
		
		
		return mv;
	}

	private boolean validInputs(String title, String description, Integer release_year, String length,
			String special_features) {

		return ((title != null && !title.isEmpty()) && (description != null && !description.isEmpty())
				&& (release_year != null && release_year < 2156 && release_year > 1900) && (length != null && !length.isEmpty())
				&& (special_features != null && !special_features.isEmpty()));

	}
}