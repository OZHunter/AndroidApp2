package com.example.u5780527.myvoice;


        import android.content.Intent;
        import android.content.pm.PackageManager;
        import android.content.pm.ResolveInfo;
        import android.os.Bundle;
        import android.speech.RecognizerIntent;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.List;

public class VoiceRecognitionActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    private static final String TAG="Voice";
    private static final int VOICE_RECOGNITION_REQUEST_CODE=30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_recognition);
        textView=(TextView)findViewById(R.id.text);
        button=(Button)findViewById(R.id.btn);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        PackageManager pm=getPackageManager();
        List<ResolveInfo> activities=pm.queryIntentActivities(new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH),0);
        if(activities.size()!=0){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startVoiceRecognitionActivity();
                }
            });
        }else {
            button.setEnabled(false);
            button.setText("Recognizer not present");
        }
    }
    private void startVoiceRecognitionActivity(){

        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"please speak English");
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        startActivityForResult(intent,VOICE_RECOGNITION_REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode==RESULT_OK){

            if(requestCode==VOICE_RECOGNITION_REQUEST_CODE){
                ArrayList<String> matches=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                StringBuilder stringBuilder=new StringBuilder();
                int size=matches.size();
                for (int i=0;i<size;i++){
                    stringBuilder.append(matches.get(i));
                    stringBuilder.append("\n");
                }

                textView.setText(stringBuilder);

            }

        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
