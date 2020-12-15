package com.example.wildlifegps;

import org.junit.Test;

import org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    //testing
    @Test
    public void testCheckInput(){
        login test=new login();

        String empty= "";
        String notEmpty = "hello";

        org.junit.Assert.assertFalse(test.checkInput(empty));
        org.junit.Assert.assertTrue(test.checkInput(notEmpty));
    }
}