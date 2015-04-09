package com.example.peera_000.gmgcashmanager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class CheckPassword extends ActionBarActivity {
    private EditText edtCheckPassword;
    private UserTABLE  objUserTABLE;
    private String StrCheckPassword;
    private String StrCheckSamePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_password);

         edtCheckPassword = (EditText) findViewById(R.id.edtCheckPassword);
         ConnectDatabase();

    }//OnCreate
         public void ConnectDatabase(){

        objUserTABLE = new UserTABLE(this);
        }//ConnectDatabase
        public void ClickOkCheckPassword(View view) {
            StrCheckPassword = edtCheckPassword.getText().toString().trim();
            StrCheckSamePassword = objUserTABLE.CheckSamePassword();
            if (StrCheckPassword.equals(StrCheckSamePassword)) {
                Intent objIntent = new Intent(CheckPassword.this, MainActivity.class);
                startActivity(objIntent);
            } else {
                AlertDialog.Builder objAlert = new AlertDialog.Builder(this);
                objAlert.setIcon(R.drawable.danger);
                objAlert.setTitle("Wrong Password");
                objAlert.setMessage("Please Enter Password Again");
                objAlert.setCancelable(false);
                objAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                objAlert.show();
            }

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_check_password, menu);
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
}//Main
