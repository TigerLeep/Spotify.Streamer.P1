package com.tigerbase.spotifystreamer.ArtistSearch;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tigerbase.spotifystreamer.ArtistParcelable;
import com.tigerbase.spotifystreamer.R;

import java.util.ArrayList;

public class ArtistAdapter extends ArrayAdapter<ArtistParcelable>
{
    private final String LOG_TAG = ArtistAdapter.class.getSimpleName();

    public ArtistAdapter(Context context, int textViewResourceId)
    {
        super(context, textViewResourceId);
    }

    public ArtistAdapter(Context context, int resource, ArrayList<ArtistParcelable> artists)
    {
        super(context, resource, artists);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Log.v(LOG_TAG, "getView");
        View view = convertView;

        if (view == null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.list_item_artist, parent, false);
        }

        ArtistParcelable artist = getItem(position);

        if (artist != null)
        {
            ImageView thumbnailImageView = (ImageView) view.findViewById(R.id.list_item_artist_thumbnail);
            TextView nameTextView = (TextView) view.findViewById(R.id.list_item_artist_name);

            if (thumbnailImageView != null)
            {
                // Load the image from its Url into the ImageView
                if (artist.ThumbnailImageUrl != null && !artist.ThumbnailImageUrl.isEmpty())
                {
                    Picasso.with(getContext())
                            .load(artist.ThumbnailImageUrl)
                            .into(thumbnailImageView);
                }
                else
                {
                    thumbnailImageView.setImageBitmap(null);
                }
            }

            if (nameTextView != null)
            {
                nameTextView.setText(artist.Name);
            }
        }

        return view;
    }
}