package fr.odddd.bcpst_training;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class ChoixMode extends AppCompatActivity {

    private ImageView choixFormule;
    private ImageView choixDefinition;
    private ImageView retour_10;

    private String chapitre;
    private String matiere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choix_mode_activity);

        this.choixFormule = (ImageView)findViewById(R.id.choix_for);
        this.choixDefinition = (ImageView)findViewById(R.id.choix_def);
        this.retour_10 = (ImageView)findViewById(R.id.retour_10);

        Intent i = getIntent();
        chapitre = i.getStringExtra("chapitre");
        matiere = i.getStringExtra("matiere");

        choixFormule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), QcmFormule.class);
                otherActivity.putExtra("chapitre", chapitre);
                otherActivity.putExtra("matiere", matiere);
                otherActivity.putExtra("lettre", "l");
                startActivity(otherActivity);
                finish();
            }
        });

        choixDefinition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), QcmDefenition.class);
                otherActivity.putExtra("chapitre", chapitre);
                otherActivity.putExtra("matiere", matiere);
                otherActivity.putExtra("lettre", "d");
                startActivity(otherActivity);
                finish();
            }
        });
        //test
        retour_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), ChoixSelection.class);
                otherActivity.putExtra("matiere", "physique");
                startActivity(otherActivity);
                finish();
            }
        });
    }
}