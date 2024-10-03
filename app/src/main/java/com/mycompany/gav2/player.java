package com.mycompany.gav2;


import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;
import android.widget.MediaController;

import android.app.*;
import android.*;


public class player extends Activity{
	VideoView videoPlayer;
	int id_ser;
	Uri myVideoUri;
	private int poz;
	
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mplayer);
		if (savedInstanceState != null) { 
			poz = savedInstanceState.getInt("poz");
		}
		
		Bundle extras = getIntent().getExtras();
        if (extras != null){
            id_ser= extras.getInt("id");}
		switch (id_ser) {
			case 1:
				myVideoUri= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.gav1);
				break;
			case 2:
				myVideoUri= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.gav2);
				break;
			case 3:
				myVideoUri= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.gav3);
				break;
			case 4:
				myVideoUri= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.gav4);
				break;
			case 5:
				myVideoUri= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.gav5);
				break;}
           
        videoPlayer = findViewById(R.id.videoPlayer);
        videoPlayer.setVideoURI(myVideoUri);
		
		videoPlayer.start();
		videoPlayer.seekTo(poz);
		
        MediaController mediaController = new MediaController(this);
        videoPlayer.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoPlayer);
		View decorView = getWindow().getDecorView();
		
// Hide the status bar.
		int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
		decorView.setSystemUiVisibility(uiOptions);
// Remember that you should never show the action bar if the
// status bar is hidden, so hide that too if necessary.
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		}
		
	
	@Override 
	public void onSaveInstanceState(Bundle savedInstanceState) {
		
		
		savedInstanceState.putInt("poz", poz); 
		super.onSaveInstanceState(savedInstanceState);
	}
	//public void onRestoreInstanceState(Bundle savedInstanceState) { 
		//super.onRestoreInstanceState(savedInstanceState); 
		//poz = savedInstanceState.getInt("poz");}
	@Override
	protected void onPause(){
		super.onPause();
		poz=videoPlayer.getCurrentPosition();

	}
}

