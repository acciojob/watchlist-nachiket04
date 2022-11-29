package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie){
        movieRepository.addMovieInHashMap(movie);
        return "Movie added successfully..!";
    }

    public String addDirector(Director director){
        movieRepository.addDirectorInHashMap(director);
        return "Director added successfully..!";
    }

    public String makePair(String mvName, String drName){
        movieRepository.makePair(mvName, drName);
        return "Pair created successfully...!";
    }

    public Movie findMovie(String mvName){
        return movieRepository.findMovie(mvName);
    }

    public Director findDirector(String drName){
        return movieRepository.findDirector(drName);
    }

    public List<String> getMoviesOfADirector(String drName){
        return movieRepository.getMoviesOfDirector(drName);
    }

    public List<String> getMovies(){
        return movieRepository.getAllMovies();
    }

    public String deleteDirectorMovies(String drName){
        movieRepository.deleteAllDirectorMovies(drName);
        return "All the Records of " + drName + " are deleted";
    }

    public String deleteAllMoviesAndDirectors(){
        movieRepository.deleteMoviesAndDirectors();
        return "All the movies and its directors are deleted..:(";
    }
}
