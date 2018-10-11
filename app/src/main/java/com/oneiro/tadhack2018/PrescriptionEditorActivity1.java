package com.oneiro.tadhack2018;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.oneiro.tadhack2018.database.TablesContract;
import com.oneiro.tadhack2018.database.TablesContract.*;

public class PrescriptionEditorActivity1 extends AppCompatActivity {

    EditText chiefComplaint;
    EditText prescribedMedicine;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription_editor1);
        chiefComplaint = (EditText) findViewById(R.id.chief_complaint);
        prescribedMedicine = (EditText) findViewById(R.id.prescribed_medicine);
        saveButton = (Button) findViewById(R.id.save_button);
    }

    public void saveItemsInDb(View view) {
        String complaint = chiefComplaint.getText().toString();
        String medicine = prescribedMedicine.getText().toString();
        if (complaint.isEmpty() || medicine.isEmpty()) {
            Toast.makeText(this, "All information are needed", Toast.LENGTH_SHORT).show();
            return;
        } else {
            ContentValues values = new ContentValues();
            values.put(PrescriptionEntry.COLUMN_COMPLAINT, complaint);
            values.put(PrescriptionEntry.COLUMN_MEDICINE, medicine);
            Uri uri = getContentResolver().insert(TablesContract.PRESCRIPTION_URI, values);
            if (uri == null) {
                Log.d("db", "error inserting data");
            }
        }
        goToPrescriptionActivity();
    }

    private void goToPrescriptionActivity() {
        Intent intent = new Intent(PrescriptionEditorActivity1.this,
                PrescriptionActivity.class);
        startActivity(intent);
    }
}
