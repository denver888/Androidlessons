package ru.startandroid.gridview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends Activity {
    String[] data = {"развитие малыша в 1 месяц", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
    GridView gvMain;
    ArrayAdapter<String> adapter;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.tvText, data);
        gvMain = (GridView) findViewById(R.id.gvMain);
        gvMain.setAdapter(adapter);
        adjustGridView();
    }

    private void adjustGridView() {
        gvMain.setNumColumns(3);
        gvMain.setVerticalSpacing(100);
        gvMain.setHorizontalSpacing(5);
        gvMain.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
    }
}

