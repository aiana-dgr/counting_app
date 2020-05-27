package com.example.countingapp;

import android.app.Activity;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class EvenCounter implements Runnable {

    private WeakReference<Activity> activityReference;

    public EvenCounter(Activity activity) {
        this.activityReference = new WeakReference<Activity>(activity);
    }

    // Override and implement only method of Runnable interface, run()
    @Override
    public void run() {

        // Creating a simple loop which will run and count to 100 by even numbers
        // Then display them to standard out
        for(int i = 0; i <= 100; i+=2) {

            System.out.println(Thread.currentThread().getName() + i);
            try {
                // thread to sleep for 250 milliseconds
                Thread.sleep(250);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // Display toast when done counting
        final Activity activity = activityReference.get();

        if(activity != null) {
            activity.runOnUiThread(new Runnable () {
                @Override
                public void run() {
                    Toast toast = Toast.makeText(activity, "Done Counting by Evens", Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
        }
    }
}
