package com.example.danghao195.menudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class PopupActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter = null;
    String contents[] = {"1", "2", "3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        listView = ( ListView ) findViewById(R.id.listView);

         adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, contents);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menucontext,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){

            case R.id.green:
                Toast.makeText(this,"clicked "+ item.getTitle()+"day la: "+info.id,Toast.LENGTH_SHORT).show();
                contents[Integer.parseInt(Long.toString(info.id))] +="1";
                adapter.notifyDataSetChanged();
                break;
            case R.id.red:
                Toast.makeText(this,"clicked "+ item.getTitle(),Toast.LENGTH_SHORT).show();
                contents[Integer.parseInt(Long.toString(info.id))] +="2";
                adapter.notifyDataSetChanged();
                break;
            case R.id.blue:
                Toast.makeText(this,"clicked "+ item.getTitle(),Toast.LENGTH_SHORT).show();
                contents[Integer.parseInt(Long.toString(info.id))] +="3";
                adapter.notifyDataSetChanged();
                break;
        }

        return super.onContextItemSelected(item);
    }

    public void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.getMenuInflater().inflate(R.menu.menupopup, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toast.makeText(PopupActivity.this, "clicked "+ menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        popupMenu.show();
    }
}
