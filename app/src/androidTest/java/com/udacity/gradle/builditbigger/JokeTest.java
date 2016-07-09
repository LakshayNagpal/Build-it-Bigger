package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by lakshay on 9/7/16.
 */
public class JokeTest extends ApplicationTestCase<Application> implements OnJokeReceivedListener {

    CountDownLatch signal;
    String joke;

    public JokeTest() {
        super(Application.class);
    }

    @Override
    public void onReceived(String joke) {
        this.joke = joke;
        signal.countDown();
    }

    public void testJoke(){
        try{
            signal = new CountDownLatch(1);
            new EndpointsAsyncTask().execute(this);
            signal.await(10, TimeUnit.SECONDS);
            assertNotNull("joke is null", joke);
            assertFalse("joke is empty", joke.isEmpty());
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail();
        }
    }
}
