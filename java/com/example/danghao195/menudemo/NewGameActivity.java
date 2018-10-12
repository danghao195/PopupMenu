package com.example.danghao195.menudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game2);
        Button menu =(Button) findViewById(R.id.menu);
        //nhấn giũ button menu thì sẽ hiển thị lên contextMenu
        registerForContextMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v ,menuInfo);
        getMenuInflater().inflate(R.menu.menucontext,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.green:
                Toast.makeText(this,"clicked "+ item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.red:
                Toast.makeText(this,"clicked "+ item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.blue:
                Toast.makeText(this,"clicked "+ item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);

    }

    public void startContentMenu(View view) {

    }
}
