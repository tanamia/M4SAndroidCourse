package com.example.aminatambengue.asynctaskproject;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import android.util.Log;
import android.widget.ImageView;

import javax.net.ssl.HttpsURLConnection;


public class MainActivity extends AppCompatActivity {

    ProgressDialog chargement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

         new MyClass().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class MyClass extends AsyncTask<URL, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            chargement = new ProgressDialog(MainActivity.this);
            chargement.setMessage("Chargement de l'image");
            chargement.setIndeterminate(false);
            chargement.show();
        }

        @Override
        protected Bitmap doInBackground(URL... params) {
            Bitmap bitmap = null;
            try {
                URL url = new URL("https://raw.githubusercontent.com/tanamia/M4SAndroidCourse/master/Dakar-Ville.png");
                HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
                if (con.getResponseCode() != HttpsURLConnection.HTTP_OK) {
                    throw new Exception("Failed to connect");
                }

                InputStream is = con.getInputStream();
                bitmap = BitmapFactory.decodeStream(is);
                is.close();

            } catch (Exception e) {
                Log.e("Image", "Failed to load image", e);
                Log.e("error", e.getMessage());
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            ImageView image =(ImageView) findViewById(R.id.imageView);
            image.setImageBitmap(result);
        }
    }
}