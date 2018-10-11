package com.oneiro.tadhack2018;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.oneiro.tadhack2018.database.TablesContract;

public class PrescriptionListCursorAdapter extends CursorAdapter {
    public PrescriptionListCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView mainText = (TextView) view.findViewById(R.id.main_text);
        TextView subText = (TextView) view.findViewById(R.id.sub_text);
        String str1 = cursor.getString(cursor.getColumnIndexOrThrow(TablesContract.PrescriptionEntry.COLUMN_COMPLAINT));
        String str2 = cursor.getString(cursor.getColumnIndexOrThrow(TablesContract.PrescriptionEntry.COLUMN_MEDICINE));
        mainText.setText(str1);
        subText.setText(str2);
    }
}
