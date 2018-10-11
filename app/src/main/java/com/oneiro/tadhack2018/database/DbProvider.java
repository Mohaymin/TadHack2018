package com.oneiro.tadhack2018.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.oneiro.tadhack2018.database.TablesContract.*;

public class DbProvider extends ContentProvider {
    private DbHelper mDbHelper;
    public static final UriMatcher sUriMatcher;

    static {
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sUriMatcher.addURI(
                TablesContract.CONTENT_AUTHORITY,
                TablesContract.PrescriptionEntry.TABLE_NAME,
                1//todo change the value
        );
    }

    @Override
    public boolean onCreate() {
        mDbHelper = new DbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection,
                        @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Cursor cursor = null;
        SQLiteDatabase database = mDbHelper.getReadableDatabase();
        String tableName;
        int match = sUriMatcher.match(uri);
        switch (match) {
            case 1:
                //todo: add codes
                cursor = database.query(
                        PrescriptionEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;

            default:
                Log.d("db", "unknown uri::: " + uri.toString());
        }
        Log.d("db", uri.toString()+" and matcher = " + match);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {

        long id;
        int matcher = sUriMatcher.match(uri);
        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        switch (matcher) {
            case 1:
                id = database.insert(
                        PrescriptionEntry.TABLE_NAME,
                        null,
                        contentValues
                );
                return ContentUris.withAppendedId(uri, id);
            default:
                Log.d("db", "Error with:::: " + uri.toString());
        }
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
