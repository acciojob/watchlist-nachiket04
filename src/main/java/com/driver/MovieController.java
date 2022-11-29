package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody () Movie movie){
        return new ResponseEntity(movieService.addMovie(movie), HttpStatus.ACCEPTED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody () Director director){
        return new ResponseEntity(movieService.addDirector(director), HttpStatus.ACCEPTED);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String mvName, @RequestParam String drName){
        return new ResponseEntity(movieService.makePair(mvName, drName), HttpStatus.ACCEPTED);
    }


    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity <Movie> getMovieByName(@PathVariable ("name") String name){
        return new ResponseEntity(movieService.findMovie(name), HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity <Director> getDirectorByName(@PathVariable ("name") String name){
        return new ResponseEntity(movieService.findDirector(name), HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable ("director") String name){
        return new ResponseEntity(movieService.getMoviesOfADirector(name), HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity(movieService.getMovies(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam () String drName){
        return new ResponseEntity(movieService.deleteDirectorMovies(drName), HttpStatus.OK);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        return new ResponseEntity(movieService.deleteAllMoviesAndDirectors(), HttpStatus.OK);
    }
}
