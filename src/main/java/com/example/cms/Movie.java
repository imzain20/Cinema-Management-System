package com.example.cms;
import javafx.application.Platform;
import java.util.Random;

public class Movie {
    private int movie_id;
    private String movie_name;
    private String movie_genre;
    private String seats_avail;
    public Movie()
    {
        movie_id=0;
        movie_name="";
        movie_genre="";
        seats_avail="";
    }

    //setters
    public void setid(int wid)
    {
        movie_id=wid;
    }
    public void setmoviename(String mo_name)
    {
        movie_name=mo_name;
    }
    public void setmeoviegenre(String mo_genre)
    {
        movie_genre=mo_genre;
    }
    public void setseatsavailablity(String seats_a)
    {
        seats_avail=seats_a;
    }
    //getters
    public int getid()
    {
        return movie_id;
    }
    public String getmovname()
    {
        return movie_name;
    }
    public String getmogenre()
    {
        return movie_genre;
    }
    public String getseatsavail()
    {
        return seats_avail;
    }


}

