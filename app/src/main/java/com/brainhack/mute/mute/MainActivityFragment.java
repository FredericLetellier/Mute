package com.brainhack.mute.mute;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private MediaRecorder myRecorder;
    private MediaPlayer myPlayer;
    private String outputFile = null;
    private Button startBtn;
    private Button stopBtn;
    private TextView text;

    Audio audio;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_main, container, false);

        // store it to sd card
        //outputFile = Environment.getExternalStorageDirectory().
        //        getAbsolutePath() + "/javacodegeeksRecording.3gpp";

        //myRecorder = new MediaRecorder();
        //myRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        //myRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        //myRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        //myRecorder.setOutputFile(outputFile);

        startBtn = (Button) rootview.findViewById(R.id.start);
        startBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                audio = new Audio();
                //audio.run();

                Toast.makeText(getContext(), "Start ...",
                        Toast.LENGTH_SHORT).show();
            }
        });

        stopBtn = (Button) rootview.findViewById(R.id.stop);
        stopBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                audio.close();
                audio = null;

                Toast.makeText(getContext(), "Stop ...",
                        Toast.LENGTH_SHORT).show();
            }
        });

        return rootview;
    }

//    public void start(View view){
//        try {
//            myRecorder.prepare();
//            myRecorder.start();
//        } catch (IllegalStateException e) {
//            // start:it is called before prepare()
//            // prepare: it is called after start() or before setOutputFormat()
//            e.printStackTrace();
//        } catch (IOException e) {
//            // prepare() fails
//            e.printStackTrace();
//        }

//        text.setText("Recording Point: Recording");
//        startBtn.setEnabled(false);
//        stopBtn.setEnabled(true);

//        Toast.makeText(getContext(), "Start recording...",
//                Toast.LENGTH_SHORT).show();
//    }

//    public void stop(View view){
//        try {
//            myRecorder.stop();
//            myRecorder.release();
//            myRecorder  = null;

//            stopBtn.setEnabled(false);
//            text.setText("Recording Point: Stop recording");

//            Toast.makeText(getContext(), "Stop recording...",
//                    Toast.LENGTH_SHORT).show();
//       } catch (IllegalStateException e) {
//            //  it is called before start()
//            e.printStackTrace();
//        } catch (RuntimeException e) {
//            // no valid audio/video data has been received
//            e.printStackTrace();
//        }
//    }


//    static final int bufferSize = 200000;
//    final short[] buffer = new short[bufferSize];
//    short[] readBuffer = new short[bufferSize];
//    boolean isRecording;
//    AudioRecord arec;
//    AudioTrack atrack;
//    public void run() {
//        isRecording = true;
//        android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_URGENT_AUDIO);
//        int buffersize = AudioRecord.getMinBufferSize(11025, AudioFormat.CHANNEL_CONFIGURATION_MONO, AudioFormat.ENCODING_PCM_16BIT);
//        arec = new AudioRecord(MediaRecorder.AudioSource.MIC, 11025, AudioFormat.CHANNEL_CONFIGURATION_MONO, AudioFormat.ENCODING_PCM_16BIT, buffersize);
//        atrack = new AudioTrack(AudioManager.STREAM_VOICE_CALL, 11025, AudioFormat.CHANNEL_CONFIGURATION_MONO, AudioFormat.ENCODING_PCM_16BIT, buffersize, AudioTrack.MODE_STREAM);
//        atrack.setPlaybackRate(11025);
//        byte[] buffer = new byte[buffersize];
//        arec.startRecording();
//        atrack.play();
//        while(isRecording) {
//            arec.read(buffer, 0, buffersize);
//            atrack.write(buffer, 0, buffer.length);
//        }
//    }

}
