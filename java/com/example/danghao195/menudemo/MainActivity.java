package com.example.danghao195.menudemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuoption,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.new_game :
                Toast.makeText(this," You are clicked New Game",Toast.LENGTH_SHORT).show();
                Intent newGameIntent = new Intent(this,NewGameActivity.class);
//                newGameIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(newGameIntent);
//                finish();
                break;
            case R.id.popup:
                Toast.makeText(this,"You are clicked Help", Toast.LENGTH_SHORT).show();
                Intent popupIntent = new Intent(this, PopupActivity.class);
                startActivity(popupIntent);
                break;

        }

        return true;
    }
}
