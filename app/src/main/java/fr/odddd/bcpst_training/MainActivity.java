package fr.odddd.bcpst_training;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ImageView play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_linear);

        this.play = (ImageView)findViewById(R.id.play);

        DataBaseHelper db = new DataBaseHelper(MainActivity.this);
        try {
            db.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent otherActivity = new Intent(getApplicationContext(), MenuMatiere.class);
                Intent otherActivity = new Intent(getApplicationContext(), Main3Activity.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }
}