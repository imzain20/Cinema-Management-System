package com.example.cms;
import org.junit.Test;
import static org.junit.Assert.*;

public class unitTest {

    @Test
    public void check1(){
        Movie i1 = new Movie();
        assertEquals(400, i1.getid());
    }
    @Test
    public void check2(){
        Movie i1 = new Movie();
        assertEquals("asia", i1.getmovname());
    }

    @Test
    public void check3(){
        Movie i1 = new Movie();
        assertEquals("comedy", i1.getmogenre());
    }

    @Test
    public void check4(){
        Movie i1 = new Movie();
        assertEquals("2", i1.getseatsavail());
    }

    @Test
    public void check5(){
        Movie i1 = new Movie();
        assertEquals("Titanic", i1.getmovname());
    }

    @Test
    public void check6(){
        Movie i1 = new Movie();
        assertEquals("Home Alone", i1.getmovname());
    }

}
