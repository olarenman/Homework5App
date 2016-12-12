package orenman.homework5app.tasks;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.AsyncTask;

import java.io.IOException;

import orenman.homework5app.Connection;
import orenman.homework5app.activities.ConnectActivity;


public class ConnectTask extends AsyncTask<String, Void, String> {

    private ConnectActivity activity;
    public ConnectTask(ConnectActivity activity){
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            Connection.getInstance().openConnection(params[0], Integer.parseInt(params[1]));
        } catch (IOException e) {
            return e.getLocalizedMessage();
        }

        return "Great success!";
    }

    @Override
    protected void onPostExecute(String result) {
        if(!Connection.getInstance().isConnected()){
        }
        activity.alertUser(result);
    }
}
