package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Pair{
    Movie movie;
    Director director;

    Pair(Movie movie, Director director){
        this.movie = movie;
        this.director = director;
    }
}

@Repository
@Component
public class MovieRepository {

    @Autowired
    Movie movie;

    @Autowired
    Director director;

    HashMap <String, Movie> movieHashMap = new HashMap<>();
    HashMap <String, Director> directorHashMap = new HashMap<>();

    List<Pair> pairList = new ArrayList<>();

    public void addMovieInHashMap(Movie mv){
        movieHashMap.put(mv.getName(), mv);
    }

    public void addDirectorInHashMap(Director dr){
        directorHashMap.put(dr.getName(), dr);
    }

    public void makePair(String mvName, String drName){
        Pair p = new Pair(movieHashMap.get(mvName), directorHashMap.get(drName));
        pairList.add(p);
    }

    public Movie findMovie(String mvName){
        return movieHashMap.get(mvName);
    }

    public Director findDirector(String drName){
        return directorHashMap.get(drName);
    }

    public List<String> getMoviesOfDirector(String drName){
        List<String> drmvList = new ArrayList<>();
        for(Pair p: pairList){
            if(p.director.getName().equals(drName)){
                drmvList.add(p.movie.getName());
            }
        }
        return drmvList;
    }

    public List<String> getAllMovies(){
        List<String> allMovies = new ArrayList<>();
        for(String mv: movieHashMap.keySet()){
            allMovies.add(movieHashMap.get(mv).getName());
        }
        return allMovies;
    }

    public void deleteAllDirectorMovies(String drName){
        int size = pairList.size();
        for(int i=0; i<size; i++){
            Pair p = pairList.get(i);
            if(p.director.getName().equals(drName)){
                movieHashMap.remove(p.movie.getName());
                directorHashMap.remove(drName);
                pairList.remove(p);
            }
        }
    }

    public void deleteMoviesAndDirectors(){
        for(Pair p: pairList){
            movieHashMap.remove(p.movie.getName());
            directorHashMap.remove(p.director.getName());
        }
        pairList.clear();
    }
}
