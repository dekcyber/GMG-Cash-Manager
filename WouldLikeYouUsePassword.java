package com.example.peera_000.gmgcashmanager;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class WouldLikeYouUsePassword extends ActionBarActivity {
    private UserTABLE objUserTABLE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_would_like_you_use_password);
        //ConnectDatabase
        //ConnectDatabase();
        //CheckEmptyDatabase
        //CheckEmptyDatabase();

    }//OnCreate

    private void CheckEmptyDatabase() {
        if (objUserTABLE.CheckCursor()) {

            Intent objIntent = new Intent(WouldLikeYouUsePassword.this, WouldLikeYouUsePassword.class);
            startActivity(objIntent);
        } else {
            Intent objIntent = new Intent(WouldLikeYouUsePassword.this, MainActivity.class);
            startActivity(objIntent);
        }
    }

    private void ConnectDatabase() {
        objUserTABLE = new UserTABLE(this);
    }


    public void ClickNo(View view){
        Intent objIntent = new Intent(WouldLikeYouUsePassword.this,MainActivity.class);
        startActivity(objIntent);
        finish();
    }//ClickNo

    public void ClickYes(View view){
        Intent objIntent = new Intent(WouldLikeYouUsePassword.this,SetPassword.class);
        startActivity(objIntent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_would_like_you_use_password, menu);
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
