package com.test.mandap.foldtest.items;

import android.content.res.Resources;
import android.content.res.TypedArray;

import com.test.mandap.foldtest.R;

/**
 * Created by Shashank Gupta on 02-Aug-15.
 */
public class Painting {

    private final int imageId;
    private final String title;
    private final String year;
    private final String location;
    private final int position;

    private Painting(int imageId, String title, String year, String location,int position) {
        this.imageId = imageId;
        this.title = title;
        this.year = year;
        this.location = location;
        this.position=position;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getLocation() {
        return location;
    }

    public int getPosition() {
        return position;
    }

    public static Painting[] getAllPaintings(Resources res) {
        String[] titles = res.getStringArray(R.array.paintings_titles);
        String[] years = res.getStringArray(R.array.paintings_years);
        String[] locations = res.getStringArray(R.array.paintings_locations);
        TypedArray images = res.obtainTypedArray(R.array.paintings_images);

        int size = titles.length;
        Painting[] paintings = new Painting[size];

        for (int i = 0; i < size; i++) {
            paintings[i] = new Painting(images.getResourceId(i, -1), titles[i], years[i], locations[i],i);
        }

        return paintings;
    }

}
