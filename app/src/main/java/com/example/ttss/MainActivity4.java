package com.example.ttss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;

public class MainActivity4 extends AppCompatActivity {
    private EditText editText;
    private ImageButton downloadBtn, speakBtn, shareBtn;
    private TextToSpeech mTTS;

    //private ImageView done;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        speakBtn = findViewById(R.id.speak_btn);

        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener()
        {
            @Override
            public void onInit(int status)
            {
             if (status == TextToSpeech.SUCCESS)
             {
                 int result = mTTS.setLanguage(Locale.US);

                 if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED)
                 {
                 Log.e("TTS", "Language not supported");
                 }
                 else
                     {
                     speakBtn.setEnabled(true);
                    }

             }
             else
                 {
                     Log.e("TTS", "Initialization failed");
                 }
            }
        });


        editText =  findViewById(R.id.edit_Text);
        downloadBtn = findViewById(R.id.download_btn);
        shareBtn = findViewById(R.id.share_btn);

        
            shareBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Share = new Intent(Intent.ACTION_SEND);
                    Share.setType("voice.wav");

                }
            });


            speakBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    speak();
                }
            });

            downloadBtn.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    String tempFilename = "hello.mp3";
                  String text_t = editText.getText().toString();
                 HashMap<String, String> myHashRender = new HashMap<String, String>();
                 myHashRender.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, text_t);

                 String exStoragePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                 Log.d("MainActivity4", "exStoragePath : "+ exStoragePath);
                 File appTmPath = new File(exStoragePath + "/sounds/");
                 boolean isDirectoryCreated = appTmPath.mkdirs();
                 Log.d("MainActivity4", "directory "+appTmPath+" is created : " +isDirectoryCreated);
                    String tempDestFile = appTmPath.getAbsolutePath() + File.separator + tempFilename;
                 Log.d("MainActivity4","tempDestFile : "+tempDestFile);
               //  new MySpeech(speakTextTxt);
                    Toast.makeText(MainActivity4.this, "Voice.wav is dowloading", Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity4.this, "Voice.wav downloaad", Toast.LENGTH_SHORT).show();
        }
    });

            shareBtn.setOnClickListener(new View.OnClickListener(){

                public void onClick(View V){
                    final Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setType("audio/wav");
                    final File audioFile = new File(getFilesDir(), "voice.wav");
                    sharingIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:///" + audioFile));
                    startActivity(Intent.createChooser(sharingIntent, "Share Audio using"));

        }
            //break;
    });


    }
    public void speak(){
        String text = editText.getText().toString();

        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }

    @Override
    protected void onDestroy() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }
        super.onDestroy();
    }


}