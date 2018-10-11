package com.oneiro.tadhack2018.database;

import android.net.Uri;
import android.provider.BaseColumns;

public class TablesContract implements BaseColumns {

    private TablesContract() {}

    // the uri
    public static final Uri BASE_CONTENT_URI;
    public static final Uri PRESCRIPTION_URI;

    public static final String CONTENT_SCHEME;
    public static final String CONTENT_AUTHORITY;

    static {
        CONTENT_SCHEME = "content://";
        CONTENT_AUTHORITY = "com.oneiro.tadhack2018";
        BASE_CONTENT_URI = Uri.parse(CONTENT_SCHEME+CONTENT_AUTHORITY);
        PRESCRIPTION_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PrescriptionEntry.TABLE_NAME);
    }

    public class PrescriptionEntry {
        public static final String _ID = BaseColumns._ID;
        public static final String TABLE_NAME = "prescription";
        public static final String COLUMN_COMPLAINT = "chief_complain";
        public static final String COLUMN_MEDICINE = "prescribed_medicine";
    }

}
