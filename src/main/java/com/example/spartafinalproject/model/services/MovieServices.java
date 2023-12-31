package com.example.spartafinalproject.model.services;

import com.example.spartafinalproject.model.dtos.Movie;
import com.example.spartafinalproject.model.dtos.moviessupport.Awards;
import com.example.spartafinalproject.model.dtos.moviessupport.Imdb;
import com.example.spartafinalproject.model.dtos.moviessupport.Tomatoes;
import com.example.spartafinalproject.model.dtos.moviessupport.Viewer;
import com.example.spartafinalproject.model.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class MovieServices {
    private static Logger logger = Logger.getLogger(MovieServices.class.getName());

    MoviesRepository repository;

    @Autowired
    public MovieServices(MoviesRepository repository) {
        this.repository = repository;
    }

    public boolean doesMovieExist(Movie movie) {
        if (movie.getId() == null) {

            return false;
        }
        Optional<Movie> existingMovie = repository.findMovieById(movie.getId());
        if (existingMovie.isEmpty()) {
            logger.log(Level.INFO,"Movie ID: "+ movie.getId()+", Title: "+movie.getTitle()+" does not exist");
            return false;
        }
        logger.log(Level.INFO,"Movie ID: "+ movie.getId()+", Title: "+movie.getTitle()+" found");
        return existingMovie.get().getId().equals(movie.getId());
    }

    public Movie updateMovie(Movie movieUpdates, Movie foundMovie) {
        updateMovieByID(movieUpdates, foundMovie);
        updateMovieByTitle(movieUpdates, foundMovie);
        updateMovieByYear(movieUpdates, foundMovie);
        updateMovieByType(movieUpdates, foundMovie);
        updateMovieByNumMflixComments(movieUpdates, foundMovie);
        updateByDirectors(movieUpdates, foundMovie);
        updateByCast(movieUpdates, foundMovie);
        updateByLanguages(movieUpdates, foundMovie);
        updateByRuntime(movieUpdates, foundMovie);
        updateByWriters(movieUpdates, foundMovie);
        updateByCountries(movieUpdates, foundMovie);
        updateByRate(movieUpdates, foundMovie);
        updateByTomatoes(movieUpdates, foundMovie);
        updateByFullplot(movieUpdates, foundMovie);
        updateByImdb(movieUpdates, foundMovie);
        updateByPlot(movieUpdates, foundMovie);
        updateByGenres(movieUpdates, foundMovie);
        updateByAwards(movieUpdates, foundMovie);
        updateByLastupdated(movieUpdates, foundMovie);
        updateByPoster(movieUpdates, foundMovie);
        updateByReleased(movieUpdates, foundMovie);
        logger.log(Level.INFO,"Movie ID: "+ foundMovie.getId()+", Title: "+foundMovie.getTitle()+" updated");
        return repository.save(foundMovie);
    }

    private static void updateByReleased(Movie movieUpdates, Movie foundMovie) {
        if (movieUpdates.getReleased() != null) {
            foundMovie.setReleased(movieUpdates.getReleased());
        }
    }

    private static void updateByPoster(Movie movieUpdates, Movie foundMovie) {
        if (movieUpdates.getPoster() != null) {
            foundMovie.setPoster(movieUpdates.getPoster());
        }
    }

    private static void updateByLastupdated(Movie movieUpdates, Movie foundMovie) {
        if (movieUpdates.getLastupdated() != null) {
            foundMovie.setLastupdated(movieUpdates.getLastupdated());
        }
    }

    private static void updateByAwards(Movie movieUpdates, Movie foundMovie) {
        if (movieUpdates.getAwards() != null) {
            foundMovie.setAwards(movieUpdates.getAwards());
        }
    }

    private static void updateByGenres(Movie movieUpdates, Movie foundMovie) {
        if (movieUpdates.getGenres() != null) {
            foundMovie.setGenres(movieUpdates.getGenres());
        }
    }

    private static void updateByPlot(Movie movieUpdates, Movie foundMovie) {
        if (movieUpdates.getPlot() != null) {
            foundMovie.setPlot(movieUpdates.getPlot());
        }
    }

    private static void updateByImdb(Movie movieUpdates, Movie foundMovie) {
        if (movieUpdates.getImdb() != null) {
            foundMovie.setImdb(movieUpdates.getImdb());
        }
    }

    private static void updateByFullplot(Movie movieUpdates, Movie foundMovie) {
        if (movieUpdates.getFullplot() != null) {
            foundMovie.setFullplot(movieUpdates.getFullplot());
        }
    }

    private static void updateByTomatoes(Movie movieUpdates, Movie foundMovie) {
        if (movieUpdates.getTomatoes() != null) {
            foundMovie.setTomatoes(movieUpdates.getTomatoes());
        }
    }

    private static void updateByRate(Movie movieUpdates, Movie foundMovie) {
        if (movieUpdates.getRated() != null) {
            foundMovie.setRated(movieUpdates.getRated());
        }
    }

    private static void updateByCountries(Movie movieUpdates, Movie foundMovie) {
        if (movieUpdates.getCountries() != null) {
            foundMovie.setCountries(movieUpdates.getCountries());
        }
    }

    private static void updateByWriters(Movie movieUpdates, Movie foundMovie) {
        if (movieUpdates.getWriters() != null) {
            foundMovie.setWriters(movieUpdates.getWriters());
        }
    }

    private static void updateByRuntime(Movie movieUpdates, Movie foundMovie) {
        if (movieUpdates.getRuntime() != null) {
            foundMovie.setRuntime(movieUpdates.getRuntime());
        }
    }

    private static void updateByLanguages(Movie movieUpdates, Movie foundMovie) {
        if (movieUpdates.getLanguages() != null) {
            foundMovie.setLanguages(movieUpdates.getLanguages());
        }
    }

    private static void updateByCast(Movie movieUpdates, Movie foundMovie) {
        if (movieUpdates.getCast() != null) {
            foundMovie.setCast(movieUpdates.getCast());
        }
    }

    private static void updateByDirectors(Movie movieUpdates, Movie foundMovie) {
        if (movieUpdates.getDirectors() != null) {
            foundMovie.setDirectors(movieUpdates.getDirectors());
        }
    }

    private static void updateMovieByNumMflixComments(Movie movieUpdates, Movie foundMovie) {
        if (movieUpdates.getNumMflixComments() != null) {
            foundMovie.setNumMflixComments(movieUpdates.getNumMflixComments());
        }
    }

    private static void updateMovieByType(Movie movieUpdates, Movie foundMovie) {
        if (movieUpdates.getType() != null) {
            foundMovie.setType(movieUpdates.getType());
        }
    }

    private static void updateMovieByYear(Movie movieUpdates, Movie foundMovie) {
        if (movieUpdates.getYear() != null) {
            foundMovie.setYear(movieUpdates.getYear());
        }
    }

    private static void updateMovieByTitle(Movie movieUpdates, Movie foundMovie) {
        if (movieUpdates.getTitle() != null) {
            foundMovie.setTitle(movieUpdates.getTitle());
        }
    }

    private static void updateMovieByID(Movie movieUpdates, Movie foundMovie) {
        if (movieUpdates.getId() != null) {
            foundMovie.setId(movieUpdates.getId());
        }
    }

    public void setEmptyAttributesToNull(Movie movie) throws IllegalAccessException {
        movie.setId(setStrToNullIfEmpty(movie.getId()));
        movie.setTitle(setStrToNullIfEmpty(movie.getTitle()));
        movie.setType(setStrToNullIfEmpty(movie.getType()));
        movie.setDirectors((List<String>) setListToNullIfEmpty(movie.getDirectors()));
        movie.setCast((List<String>) setListToNullIfEmpty(movie.getCast()));
        movie.setLanguages((List<String>) setListToNullIfEmpty(movie.getLanguages()));
        movie.setWriters((List<String>) setListToNullIfEmpty(movie.getWriters()));
        movie.setCountries((List<String>) setListToNullIfEmpty(movie.getCountries()));
        movie.setRated(setStrToNullIfEmpty(movie.getRated()));
        movie.getTomatoes().setViewer(setObjectToNullIfEmpty(movie.getTomatoes().getViewer()));
        movie.setTomatoes(setObjectToNullIfEmpty(movie.getTomatoes()));
        movie.setFullplot(setStrToNullIfEmpty(movie.getFullplot()));
        movie.setImdb(setObjectToNullIfEmpty(movie.getImdb()));
        movie.setPlot(setStrToNullIfEmpty(movie.getPlot()));
        movie.setGenres((List<String>) setListToNullIfEmpty(movie.getGenres()));
        movie.getAwards().setText(setStrToNullIfEmpty(movie.getAwards().getText()));
        movie.setAwards(setObjectToNullIfEmpty(movie.getAwards()));
        movie.setLastupdated(setStrToNullIfEmpty(movie.getLastupdated()));
        movie.setPoster(setStrToNullIfEmpty(movie.getPoster()));
        logger.log(Level.INFO,"All empty movie fields set to null");
    }

    private <T> T setObjectToNullIfEmpty(T object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(object);
            if (value != null) {
                return object;
            }
        }
        return null;
    }

    private static String setStrToNullIfEmpty(String str) {
        if (str.equals("")) {
            return null;
        }
        return str;
    }

    private static List<?> setListToNullIfEmpty(List<?> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }


    //delete
}
