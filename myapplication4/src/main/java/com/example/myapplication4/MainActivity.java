package com.example.myapplication4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener{
private SeekBar seckbar;
private TextView textView;
private boolean isTimerOn;
private Button button;
private CountDownTimer countDownTimer;
private  int defaultInterval;
SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
seckbar=findViewById(R.id.seekBar);
textView=findViewById(R.id.textView);
seckbar.setMax(600);
setIntervalSharedPreferences(sharedPreferences);
isTimerOn=false;
sharedPreferences=PreferenceManager.getDefaultSharedPreferences(this);
button=findViewById(R.id.bottom);

seckbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        long progressInMill=progress*1000;
       updateTimer(progressInMill);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
});
sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    public void start(View view) {
        if (!isTimerOn) {
            button.setText("stop");
            seckbar.setEnabled(false);
            isTimerOn = true;

            countDownTimer = new CountDownTimer(seckbar.getProgress() * 1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    updateTimer(millisUntilFinished);
                }

                @Override
                public void onFinish() {
                    SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    if (sharedPreferences.getBoolean("enabled_sound",true)){
                        String melodyName=sharedPreferences.getString("timer_melodi","bell");
                        if (melodyName.equals("bell")){
                            MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.jony);
                            mediaPlayer.start();
                        }else  if (melodyName.equals("allarm")) {
                            MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.malbek);
                            mediaPlayer.start();

                        }else if
                            (melodyName.equals("bip")) {

                                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.olga);
                                mediaPlayer.start();
                            }
                        }

                    resetTimer();
                }
            };
            countDownTimer.start();


        } else {
 resetTimer();
        }
    }
    private void updateTimer(long millisUntilFinished){
            int minuts = (int)millisUntilFinished/60;
            int second= (int)millisUntilFinished-(minuts*60);
            String minutesString="";
            String secondsString="";
            if (minuts<10){
                minutesString="0"+minuts;

            }else {
                minutesString=String.valueOf(minuts);
            }
            if (second<10){
                secondsString="0"+second;
            }else {
                secondsString=String.valueOf(second);
            }
            textView.setText(minutesString+":"+secondsString);
        }
        private void resetTimer(){
            countDownTimer.cancel();

            button.setText("Start");
            seckbar.setEnabled(true);

          setIntervalSharedPreferences(sharedPreferences);
            isTimerOn = false;
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.timer_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        if (id==R.id.action_settings){
            Intent openSettings=new Intent(this,SettingActivity.class);
            startActivity(openSettings);
            return  true;

        }else {
            if (id==R.id.action_about){
                Intent openSettings=new Intent(this,AboutActivity.class);
                startActivity(openSettings);
                return  true;

            }
        }
        return super.onOptionsItemSelected(item);
    }
    private void setIntervalSharedPreferences(SharedPreferences sharedPreferences){

defaultInterval=Integer.valueOf(sharedPreferences.getString("default_interval","30" ));
textView.setText("00"+defaultInterval);
seckbar.setProgress(defaultInterval);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("default_interval")){
            setIntervalSharedPreferences(sharedPreferences);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
      sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }
}

