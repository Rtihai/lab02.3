package com.derrick.park.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity {

    public static final String ITEMS_EXTRA = "ITEMS_EXTRA";
    private ArrayList<String> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        items = new ArrayList<>();
    }

    public void itemSelected(View view) {
        CheckBox selectedCheckBox = (CheckBox) view;
        String item = selectedCheckBox.getText().toString();
        Toast.makeText(this, item + " Added.", Toast.LENGTH_LONG).show();
        items.add(item);
    }

    public void finishAdding(View view) {
        Intent replyIntent = new Intent();
        replyIntent.putStringArrayListExtra(ITEMS_EXTRA, items);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
