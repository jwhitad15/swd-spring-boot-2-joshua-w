package com.example.mycollections.controllers;

import com.example.mycollections.models.Album;
import com.example.mycollections.models.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private final List<Album> albums = new ArrayList<>() {{
        add(new Album("Black Star Elephant", "Nico & Vinz", 2014, 20));
        add(new Album("Tremors", "Sohn", 2014, 10));
        add(new Album("Mu & Mea", "Hello Meteor", 2018, 15));
    }};

    @GetMapping("/json")
    public List<Album> getAlbumJson() {return albums;}

    @GetMapping("/html")
    public String getAlbumsHtml() {
        String albumList = "<ul>";
        for (Album album : albums) {
            albumList += "<li>" + album.getName() + "</li>";
        }
        albumList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Albums</h1>
                        <ul>
                """ +
                albumList +
                """
                        </ul>
                    </body>
                """;
    }
}
