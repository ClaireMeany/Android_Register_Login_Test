package com.example.wildlifegps;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class testAddComment {

    private String str = "Nice post!";

    ArrayList<Comment> list = new ArrayList<>();

    Comment comment1 = new Comment();
    Comment comment2 = new Comment();

    private Sighting sighting = new Sighting();


    @Before
    public void setUp(){
        comment1.setComment(str);
        comment2.setComment("nice");
        list.add(0, comment2);
        list.add(1, comment1);
        sighting.setComments(list);
    }

    @Test
    public void TestThis(){
        Assert.assertEquals(list, sighting.getComments());
        Assert.assertNotSame(str, comment2.getComment());
    }

    @After
    public void tearDown(){

    }
}
