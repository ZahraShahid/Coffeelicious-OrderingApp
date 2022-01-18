package com.example.coffeelicious;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coffeelicious.Database.OrderContract;

public class SummaryActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public CartAdapter mAdapter;
    public static final int LOADER = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Button clearthedata = findViewById(R.id.clearthedatabase);

        clearthedata.setOnClickListener(v -> {
            int deletethedata = getContentResolver().delete(OrderContract.OrderEntry.CONTENT_URI, null, null);
        });

        getLoaderManager().initLoader(LOADER, null, this);

        ListView listView = findViewById(R.id.list);
        mAdapter = new CartAdapter(this, null);
        listView.setAdapter(mAdapter);

    }
    @Override
    public android.content.Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,
                OrderContract.OrderEntry.COLUMN_CREAM,
                OrderContract.OrderEntry.COLUMN_HASTOPPING
        };

        return new CursorLoader(this, OrderContract.OrderEntry.CONTENT_URI,
                projection,
                null,
                null,
                null);

    }

    @Override
    public void onLoadFinished(android.content.Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(android.content.Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }

}