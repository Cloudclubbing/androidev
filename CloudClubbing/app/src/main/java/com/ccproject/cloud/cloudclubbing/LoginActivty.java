package com.ccproject.cloud.cloudclubbing;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;

public class LoginActivty extends Activity {

    private Activity    activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activty);
        activity = this;
    }

    public void cancelbtn(View view)
    {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }



    public void onClick(View view) {
        EditText text = (EditText)findViewById(R.id.username);
        String username = text.getText().toString();

        text = (EditText)findViewById(R.id.password);
        String password = text.getText().toString();

        Post post = new Post(new ResultPost());
        post.execute(username, password);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login_activty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class ResultPost implements IAction {
        public void exec(String result) {


            if (result.equals("ok")) {
                Intent intent = new Intent(activity, Home.class);

                startActivity(intent);

            } else {
                AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
                alertDialog.setTitle("Connexion");
                alertDialog.setMessage("Result " + result);

                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
//            alertDialog.setIcon(R.drawable.icon);
                alertDialog.show();
            }
        }
    }
}
