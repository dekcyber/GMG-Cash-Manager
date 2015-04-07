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


public class SetPassword extends ActionBarActivity {

    //Explicit
    private EditText edtSetPassword;
    private String strSetPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);
        //BindWidget
        BindWidget();

    }//OnCreate


    public void ClickOkSetPassword(View view){

        strSetPassword = edtSetPassword.getText().toString().trim();
        if (strSetPassword.equals("")){
            ShowAlert();

        }

        UpdatePassword();
        Intent objIntent = new Intent(SetPassword.this,MainActivity.class);
        startActivity(objIntent);
        finish();
    }

    private void UpdatePassword() {

        UserTABLE objUserTABLE = new UserTABLE(this);
        long insertPassword = objUserTABLE.AddNewPassword(Integer.parseInt(strSetPassword));
        edtSetPassword.setText("");

    }

    private void ShowAlert() {
        AlertDialog.Builder objAlert = new AlertDialog.Builder(this);
        objAlert.setIcon(R.drawable.danger);
        objAlert.setTitle("HaveSpace");
        objAlert.setMessage("Please Fill in the Blank");
        objAlert.setCancelable(false);
        objAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        objAlert.show();

    }

    private void BindWidget() {

        edtSetPassword = (EditText) findViewById(R.id.edtSetPassword);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_set_password, menu);
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
