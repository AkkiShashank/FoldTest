package com.test.mandap.foldtest.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Shashank Gupta on 02-Aug-15.
 */
public class FoldableDetails extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int position=getIntent().getExtras().getInt("position");
        Toast.makeText(FoldableDetails.this,Integer.toString(position),Toast.LENGTH_LONG).show();
    }
}
