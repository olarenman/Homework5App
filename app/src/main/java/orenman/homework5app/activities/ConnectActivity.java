package orenman.homework5app.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import orenman.homework5app.R;
import orenman.homework5app.tasks.ConnectTask;


public class ConnectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
    }

    public void connectToServer(View view) {
        EditText ipText = (EditText) findViewById(R.id.editTextIP);
        EditText portText = (EditText) findViewById(R.id.editTextPort);
        ConnectTask connectTask = new ConnectTask(this);
        connectTask.execute(ipText.getText().toString(), portText.getText().toString());
    }

    public void alertUser(String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

}
