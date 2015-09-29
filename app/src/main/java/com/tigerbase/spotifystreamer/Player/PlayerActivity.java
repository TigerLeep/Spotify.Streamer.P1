package com.tigerbase.spotifystreamer.Player;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tigerbase.spotifystreamer.R;
import com.tigerbase.spotifystreamer.Track;

import java.util.ArrayList;


public class PlayerActivity extends AppCompatActivity
{
    private final String LOG_TAG = PlayerActivity.class.getSimpleName();
    private final String PLAYER_FRAGMENT_TAG = PlayerFragment.class.getSimpleName();

    private PlayerFragment _playerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.v(LOG_TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Intent intent = getIntent();
        Bundle bundle = (intent != null ? intent.getExtras() : new Bundle());

        _playerFragment =
                (PlayerFragment)getSupportFragmentManager()
                        .findFragmentByTag(PLAYER_FRAGMENT_TAG);
        if (_playerFragment == null)
        {
            _playerFragment = new PlayerFragment();
            _playerFragment.setArguments(bundle);
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_player_container,
                        _playerFragment,
                        PLAYER_FRAGMENT_TAG)
                .commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        Log.v(LOG_TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

}
