package com.test.mandap.foldtest.items;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexvasilkov.android.commons.adapters.ItemsAdapter;
import com.alexvasilkov.android.commons.utils.Views;
import com.squareup.picasso.Picasso;
import com.test.mandap.foldtest.R;
import com.test.mandap.foldtest.activities.FoldableListActivity;
import com.test.mandap.foldtest.activities.UnfoldableDetailsActivity;

import java.util.Arrays;

/**
 * Created by Shashank Gupta on 02-Aug-15.
 */
public class PaintingsAdapter extends ItemsAdapter<Painting> implements View.OnClickListener {

    int position;
    public PaintingsAdapter(Context context) {
        super(context);
        setItemsList(Arrays.asList(Painting.getAllPaintings(context.getResources())));
    }

    @Override
    protected View createView(Painting item, int pos, ViewGroup parent, LayoutInflater inflater) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder vh = new ViewHolder();
        vh.image = Views.find(view, R.id.list_item_image);
        vh.image.setOnClickListener(this);
        vh.title = Views.find(view, R.id.list_item_title);
        view.setTag(vh);

        return view;
    }

    @Override
    protected void bindView(Painting item, int pos, View convertView) {
        ViewHolder vh = (ViewHolder) convertView.getTag();

        position=pos;
        vh.image.setTag(item);
        Picasso.with(convertView.getContext()).load(item.getImageId()).noFade().into(vh.image);
        vh.title.setText(item.getTitle());
    }

    @Override
    public void onClick(View view) {
        if (view.getContext() instanceof UnfoldableDetailsActivity) {
            UnfoldableDetailsActivity activity = (UnfoldableDetailsActivity) view.getContext();
            activity.openDetails(view, (Painting) view.getTag());
        }
        if(view.getContext() instanceof FoldableListActivity){
            FoldableListActivity activity = (FoldableListActivity) view.getContext();
            activity.openDetails(view, position);
        }
    }

    private static class ViewHolder {
        ImageView image;
        TextView title;
    }

}
