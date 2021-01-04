package fr.odddd.bcpst_training;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class Main3Activity extends AppCompatActivity {

    ImageView zone;
    int loc = R.drawable.image_retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        this.zone = (ImageView)findViewById(R.id.zo);

        int loc = R.drawable.image_retour;

        zone.setImageResource(loc);
    }
}
