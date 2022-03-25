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
        assertEquals(300, i1.getmovname());
    }

    @Test
    public void check3(){
        Movie i1 = new Movie();
        assertEquals(300, i1.getmogenre());
    }

    @Test
    public void check4(){
        Movie i1 = new Movie();
        assertEquals(100, i1.getseatsavail());
    }
}
