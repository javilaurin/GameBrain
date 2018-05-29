package com.laurinware.gamebrain;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GameNamesViewModel gameNamesViewModel;

    private Button mGamesButton;
    private Button mPlatformsButton;

    public static final String BASE_URL = "https://api-endpoint.igdb.com/";
    public static final String LIST_TYPE = "com.laurinware.gamebrain.LIST_TYPE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initilize Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Check for Internet Connection
        if(!isOnline()){
            Log.d("INTERNET","NO INTERNET");
            Toast.makeText(this, R.string.no_internet, Toast.LENGTH_SHORT).show();
        }

        // Obtain button references and set onclick listeners
        mGamesButton = findViewById(R.id.button_games);
        mGamesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Toast.makeText(v.getContext(),"Botón games", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), ItemListActivity.class);
                intent.putExtra(LIST_TYPE,"GAMES");
                startActivity(intent);

            }
        });
        mPlatformsButton = findViewById(R.id.button_platforms);
        mPlatformsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Toast.makeText(v.getContext(),"Botón plataformas", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), ItemListActivity.class);
                intent.putExtra(LIST_TYPE,"PLATFORMS");
                startActivity(intent);
            }
        });



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

        switch (id){
            case R.id.action_settings:
                Toast.makeText(this, "Ajustes", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_about:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.action_about_text)
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //do things
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                return true;
        }


        return super.onOptionsItemSelected(item);
    }

    boolean isOnline() {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

}
