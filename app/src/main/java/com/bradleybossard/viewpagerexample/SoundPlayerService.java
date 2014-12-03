package com.bradleybossard.viewpagerexample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class SoundPlayerService extends Service {

    private MediaPlayer mediaPlayer;
    //public SoundPlayerService() {
    //}

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return  null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int soundid = intent.getIntExtra("soundid", -1);
        if (soundid != -1) {
            playSound(soundid);
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
        }
        super.onDestroy();
    }

    public synchronized void playSound(int soundid) {
        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(null);
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        mediaPlayer = MediaPlayer.create(SoundPlayerService.this, soundid);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stopSelf();
            }
        });
        mediaPlayer.start();
    }


}
