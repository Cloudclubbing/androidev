package com.ccproject.cloud.cloudclubbing;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by on 13/11/2014.
 */

public class Post extends AsyncTask<String, Void, String> {
    private String username;
    private String password;
    private String result;
    private IAction action;

    public Post(IAction action) {
        this.action = action;
    }

    @Override
    protected String doInBackground(String... params) {
        username = params[0];
        password = params[1];
        Log.d("toto", "Username = " + username + " Password = " + password);
        postData();
        return "Executed";
    }


    public void postData() {
        // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://www.galasky.fr:80/login");

        String rsp;
        try {
           // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("username", username));
            nameValuePairs.add(new BasicNameValuePair("password", password));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);
            String responseStr = EntityUtils.toString(response.getEntity());
            result = responseStr;
        } catch (ClientProtocolException e) {
            result = "error " + e.toString();
        } catch (IOException e) {
            result = "error " + e.toString();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        action.exec(this.result);
    }

    @Override
    protected void onPreExecute() {}

    @Override
    protected void onProgressUpdate(Void... values) {}
}
