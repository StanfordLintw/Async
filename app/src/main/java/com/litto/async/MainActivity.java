package com.litto.async;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = findViewById(R.id.info);
    }

    public void go1(View view){
        new Job1Task().execute();
    }
    public void go2(View view){
        new Job2Task().execute(3);
    }
    public void go3(View view){
        new Job3Task().execute(6);
    }

    class Job3Task extends AsyncTask<Integer, Integer, Void>{

        @Override
        protected Void doInBackground(Integer... integers) {
            for (int i=0; i<integers[0]; i++){
                try {
                    publishProgress(i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            info.setText(values[0]+"");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            info.setText("DONE");
        }
    }

    class Job2Task extends AsyncTask<Integer, Void, Void>{

        @Override
        protected Void doInBackground(Integer... integers) {
            try {
                Thread.sleep(integers[0]*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            info.setText("DONE");
        }
    }

    class Job1Task extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            info.setText("DONE");
        }
    }

}
