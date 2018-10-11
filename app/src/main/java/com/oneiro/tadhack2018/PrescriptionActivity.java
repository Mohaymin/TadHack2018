package com.oneiro.tadhack2018;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.oneiro.tadhack2018.database.TablesContract;
import com.oneiro.tadhack2018.database.TablesContract.*;


public class PrescriptionActivity extends AppCompatActivity {

    Button addItems;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);
        addItems = (Button) findViewById(R.id.add_items);
        listView = (ListView) findViewById(R.id.list_view);
        addItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        PrescriptionActivity.this, PrescriptionEditorActivity1.class
                );
                startActivity(intent);
            }
        });
        displayList();
    }

    private void displayList() {
        Uri uri = TablesContract.PRESCRIPTION_URI;
        String[] projection = {
                PrescriptionEntry._ID,
                PrescriptionEntry.COLUMN_MEDICINE,
                PrescriptionEntry.COLUMN_COMPLAINT
        };

        Cursor cursor = getContentResolver().query(
                uri,
                projection,
                null,
                null,
                null
        );
        if(cursor == null) {
            Toast.makeText(this, "error retrieving data", Toast.LENGTH_SHORT).show();
        }
        PrescriptionListCursorAdapter cursorAdapter
                = new PrescriptionListCursorAdapter(this, cursor);
        listView.setAdapter(cursorAdapter);
    }
}
