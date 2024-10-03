package com.mycompany.gav2;


import android.app.*;
import android.os.*;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends Activity implements OnClickListener {
	MediaPlayer mPlayer;
	Button s1, s2, s3, s4, s5;
	int id_ser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		s1= findViewById(R.id.s1_but);
		s2= findViewById(R.id.s2_but);
		s3= findViewById(R.id.s3_but);
		s4= findViewById(R.id.s4_but);
		s5= findViewById(R.id.s5_but);

		s1.setOnClickListener(this);
		s2.setOnClickListener(this);
		s3.setOnClickListener(this);
		s4.setOnClickListener(this);
		s5.setOnClickListener(this);

		mPlayer= MediaPlayer.create(this, R.raw.gav);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					stopPlay();
				}
			});
		mPlayer.start();
		mPlayer.setLooping(true);}

	@Override 
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.s1_but: 
				id_ser= 1;
				break;
			case R.id.s2_but: 
				id_ser= 2;
				break;
			case R.id.s3_but: 
				id_ser= 3;
				break;
			case R.id.s4_but: 
				id_ser= 4;
				break;
			case R.id.s5_but: 
				id_ser= 5;
				break;
				}
		onDestroy();
		Intent intent = new Intent();
		intent.putExtra("id", id_ser);
		intent.setClass( 
			getApplicationContext(), player.class); 
		startActivity(intent);
	}

	private void stopPlay(){
        mPlayer.stop();}

	@Override
    public void onDestroy() {
        super.onDestroy();
        if (mPlayer.isPlaying()) {
            stopPlay();}
	}


	@Override
	protected void onPause()
	{
		// TODO: Implement this method
		super.onPause();

	}
}

      
