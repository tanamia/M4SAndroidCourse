package com.example.aminatambengue.menuproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button SMS;
    private Button PHONE;
    private Button WEB;
    private Button MAP;
    private Button SHARE;
    private Button newActivity;
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
        SMS = (Button) findViewById(R.id.button);
        SMS.setOnClickListener(this);
        PHONE = (Button) findViewById(R.id.button2);
        PHONE.setOnClickListener(this);
        WEB = (Button) findViewById(R.id.button3);
        WEB.setOnClickListener(this);
        MAP = (Button) findViewById(R.id.button4);
        MAP.setOnClickListener(this);
        SHARE = (Button) findViewById(R.id.button5);
        SHARE.setOnClickListener(this);
        newActivity = (Button) findViewById(R.id.button6);
        newActivity.setOnClickListener(this);

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
        else if (id == R.id.help){
            Intent Hactivity = new Intent(MainActivity.this, HelpActivity.class);
            startActivity(Hactivity);
                    }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.button:
                final Intent sms = new Intent(Intent.ACTION_SENDTO);
                sms.setData(Uri.parse("smsto:" + Uri.encode("776298317")));
                sms.putExtra("sms_body", "Hi, it's Amina");
                startActivity(sms);break;
            case R.id.button2:
                Intent phone = new Intent(Intent.ACTION_DIAL);
                phone.setData(Uri.parse("tel:776298317"));
                startActivity(phone);break;
            case R.id.button3:
                Intent website = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
                startActivity(website);break;
            case R.id.button4:
                String lieu = "geo:14.7460068,-17.4952322";
                Intent map = new Intent(Intent.ACTION_VIEW, Uri.parse(lieu));
                startActivity(map);break;
            case R.id.button5:
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT, "Amina sends.");
                share.putExtra(Intent.EXTRA_TEXT, "Amina shares whith you.");
                startActivity(Intent.createChooser(share, "Share the love"));break;
            case R.id.button6:
              Intent intent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(intent);


        }
    }
}
