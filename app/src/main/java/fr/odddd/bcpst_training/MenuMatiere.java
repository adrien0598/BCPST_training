package fr.odddd.bcpst_training;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuMatiere extends AppCompatActivity {

    //private ImageView reglage;
    private ImageView svt;
    private ImageView physique;
    private ImageView math;
    private ImageView retour_0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_matiere_linear);

        //this.reglage = (ImageView)findViewById(R.id.reglage);
        this.svt = (ImageView)findViewById(R.id.svt);
        this.physique = (ImageView)findViewById(R.id.physique);
        this.math = (ImageView)findViewById(R.id.math);
        this.retour_0 = (ImageView)findViewById(R.id.retour_0);

        retour_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        physique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), ChoixSelection.class);
                otherActivity.putExtra("matiere", "physique");
                startActivity(otherActivity);
                finish();
            }
        });

        svt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), ChoixSelection.class);
                otherActivity.putExtra("matiere", "svt");
                startActivity(otherActivity);
                finish();
            }
        });

       math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), ChoixSelection.class);
                otherActivity.putExtra("matiere", "math");
                startActivity(otherActivity);
                finish();
            }
        });
    }
}
