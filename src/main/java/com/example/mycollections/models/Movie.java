package com.example.mycollections.models;

public class Movie extends LibraryItem {
    private String director;
    private int runtime;

    public Movie(String name, String director, int year, int runtime) {
        super(name, year);
        this.director = director;
        this.runtime = runtime;
    }

    public String getDirector() {return director;}
    public void setDirector(String director) {this.director = director;}

    public int getRuntime() {return runtime;}
    public void setRuntime(int runtime) {this.runtime = runtime;}
}
