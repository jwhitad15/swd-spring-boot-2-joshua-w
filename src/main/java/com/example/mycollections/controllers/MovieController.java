package com.example.mycollections.controllers;

import com.example.mycollections.models.Album;
import com.example.mycollections.models.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final List<Movie> movies = new ArrayList<>() {{
        add(new Movie("The Pursuit of Happyness", "Gabriele Muccino", 2006, 117));
        add(new Movie("i,Robot", "Alex Proyas", 2004, 115));
        add(new Movie("I Am Legend", "Francis Lawrence", 2007, 101));
    }};

    @GetMapping("/json")
    public List<Movie> getMoviesJson() {
        return movies;
    }

    @GetMapping("/html")
    public String getMoviesHtml() {
        String movieList = "<ul>";
        for (Movie movie : movies) {
            movieList += "<li>" + movie.getName() + " was released in " + movie.getYear() + ", was directed by " + movie.getDirector() + ", and has a runtime of " + movie.getRuntime() + " minutes." + "</li>";
        }
        movieList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Movies</h1>
                        <ul>
                """ +
                movieList +
                """
                        </ul>
                    </body>
                """;
    }

}
