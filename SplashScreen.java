package com.example.peera_000.gmgcashmanager;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class SplashScreen extends ActionBarActivity {
    private Handler objHandler;
    private UserTABLE objUserTABLE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        objHandler = new Handler();

        //ConnectDatabase
        ConnectDatabase();

        //Test
        //TestAddPassword();
        objHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent objIntent = new Intent(SplashScreen.this, WouldLikeYouUsePassword.class);
                startActivity(objIntent);
                finish();
            }
        }, 3000);


    }//OnCreate




    private void TestAddPassword() {
            objUserTABLE.AddNewPassword(12345);
    }

    public void ConnectDatabase(){

            objUserTABLE = new UserTABLE(this);
        }//ConnectDatabase

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_screen, menu);
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
}
