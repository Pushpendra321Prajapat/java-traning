package models;

import java.util.ArrayList;

public class Store {
    private ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovie(int index) {
        return new Movie(this.movies.get(index));
    }

    public Movie getMovie(String name) {
        for (int i = 0; i < this.movies.size(); i++) {
            if (this.movies.get(i).getName().equals(name))
                return new Movie(this.movies.get(i));
        }
        return null;
    }

    public void setMovie(int index, Movie movie) {
        this.movies.set(index, new Movie(movie));
    }

    public void addMovie(Movie movie) {
        this.movies.add(new Movie(movie));
    }

    // public void sellMovie(String movieName) {
    // for (int i = 0; i < this.movies.size(); i++) {
    // if (this.movies.get(i).getName().equals(movieName)) {
    // this.movies.remove(i);
    // }
    // }
    // }

    // public void rentMovie(String movieName) {
    // for (int i = 0; i < this.movies.size(); i++) {
    // if (this.movies.get(i).getName().equals(movieName)) {
    // this.movies.get(i).setAvailable(false);
    // }
    // }
    // }

    // public void returnMovie(String movieName) {
    // for (int i = 0; i < this.movies.size(); i++) {
    // if (this.movies.get(i).getName().equals(movieName)) {
    // this.movies.get(i).setAvailable(true);
    // }
    // }
    // }

    public void action(String movieName, String action) {
        if (!(action.equals("sell")) && !(action.equals("rent")) && !(action.equals("return"))) {
            throw new IllegalArgumentException("the action must be sell or remt or return.");
        }

        if (movieName == null || movieName.isBlank()) {
            throw new IllegalArgumentException("movie name can not be null or blank.");
        }

        if (this.movies.isEmpty()) {
            throw new IllegalStateException("no action can performed in empty store.");
        }

        for (int i = 0; i < this.movies.size(); i++) {
            if (this.movies.get(i).getName().equals(movieName)) {
                if (action == "sell") {
                    if (!(this.movies.get(i).isAvailable())) {
                        throw new IllegalStateException("can not sell a rented movie.");
                    }
                    this.movies.remove(i);
                } else if (action == "rent") {
                    this.movies.get(i).setAvailable(false);
                } else if (action == "return") {
                    this.movies.get(i).setAvailable(true);
                }
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.movies.size(); i++) {
            temp += this.movies.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }

}
