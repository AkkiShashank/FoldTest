package com.test.mandap.foldtest.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexvasilkov.android.commons.texts.SpannableBuilder;
import com.alexvasilkov.android.commons.utils.Views;
import com.alexvasilkov.foldablelayout.FoldableListLayout;
import com.squareup.picasso.Picasso;
import com.test.mandap.foldtest.R;
import com.test.mandap.foldtest.items.Painting;
import com.test.mandap.foldtest.items.PaintingsAdapter;

/**
 * Created by Shashank Gupta on 02-Aug-15.
 */
public class FoldableListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foldable_list);

        FoldableListLayout foldableListLayout = Views.find(this, R.id.foldable_list);
        foldableListLayout.setAdapter(new PaintingsAdapter(this));
    }

    public void openDetails(View coverView, int position) {
        Intent i=new Intent(FoldableListActivity.this,FoldableDetails.class);
        i.putExtra("position",position);
        startActivity(i);
    }

}
