package fr.odddd.bcpst_training;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaMetadata;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ChoixSelection extends AppCompatActivity {

    private ImageView retour;
    private ImageView choix_chap;
    private ImageView choix_conc;
    private String matiere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_selection);

        this.retour = (ImageView)findViewById(R.id.retour_menu_matiere);
        this.choix_chap = (ImageView)findViewById(R.id.choix_chapitre);
        this.choix_conc = (ImageView)findViewById(R.id.choix_concours);

        Intent i = getIntent();
        matiere = i.getStringExtra("matiere");

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), MenuMatiere.class);
                startActivity(otherActivity);
                finish();
            }
        });

        choix_chap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), ChoixChapitre.class);
                otherActivity.putExtra("mode", "chapitre");
                otherActivity.putExtra("matiere", matiere);
                startActivity(otherActivity);
                finish();
            }
        });

        choix_conc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(matiere){
                    case "svt":
                        Intent otherActivity = new Intent(getApplicationContext(), QcmDefenition.class);
                        otherActivity.putExtra("matiere", matiere);
                        otherActivity.putExtra("chapitre", "concours");
                        otherActivity.putExtra("lettre", "");
                        startActivity(otherActivity);
                        finish();
                        break;
                    case "physique":
                        Intent otherActivity1 = new Intent(getApplicationContext(), ChoixMode.class);
                        otherActivity1.putExtra("matiere", matiere);
                        otherActivity1.putExtra("chapitre", "concours");
                        startActivity(otherActivity1);
                        finish();
                        break;
                    case "math":
                        Intent otherActivity3 = new Intent(getApplicationContext(), QcmFormule.class);
                        otherActivity3.putExtra("matiere", matiere);
                        otherActivity3.putExtra("chapitre", "concours");
                        otherActivity3.putExtra("lettre", "");
                        startActivity(otherActivity3);
                        finish();
                        break;
                    default:
                        Log.d("etrange","on est allé dans default");
                        Intent otherActivity2 = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(otherActivity2);
                        finish();
                }
            }
        });
    }
}
