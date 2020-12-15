package com.example.wildlifegps;

import org.junit.Assert;
import org.junit.Before;
import org.testng.annotations.Test;

public class testDeleteSighting {
    Sighting sight = new Sighting();
    ViewSighting vs = new ViewSighting();
    private final ViewSighting activity = vs;
    DBHandler dbh = new DBHandler(activity);
    deleteSighting ds = new deleteSighting();

    @Before
    public void before(){
        dbh.addSighting(sight);
    }

    @Test
    public void TestThis(){
        dbh.deleteSighting(sight);
        Assert.assertNull(sight);
    }
}
