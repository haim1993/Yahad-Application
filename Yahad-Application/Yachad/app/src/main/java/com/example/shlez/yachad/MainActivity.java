package com.example.shlez.yachad;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Business> items = new ArrayList<Business>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        populateItems();
        populateListView();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_menu_action, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void populateItems() {
        items.add(new Business(R.drawable.pizzahut, "פיצה האט", 10));
        items.add(new Business(R.drawable.mcdonalds, "מקדונלס", 15));
        items.add(new Business(R.drawable.kfc, "KFC", 20));
    }

    private void populateListView() {
        ArrayAdapter<Business> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Business> {
        public MyListAdapter() {
            super(MainActivity.this, R.layout.business_list_view_item, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.business_list_view_item, parent, false);
            }
            Business item = items.get(position);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.item_icon);
            imageView.setImageResource(item.getIconId());

            TextView nameText = (TextView) itemView.findViewById(R.id.item_name);
            nameText.setText(item.getBusinessName());

            TextView distanceText = (TextView) itemView.findViewById(R.id.item_distance);
            distanceText.setText(item.getDistance() + " ק\"מ");

            return itemView;
            //return super.getView(position, convertView, parent);
        }
    }

}
