package fr.odddd.bcpst_training;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChoixChapitre extends AppCompatActivity {

    private Spinner spinner0;
    private Button submit;
    private String matiere;
    private ImageView retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_chapitre);

        Intent i = getIntent();
        matiere = i.getStringExtra("matiere");

        retour = this.findViewById(R.id.retour_choix_selection);

        addItemsOnSpinner2();
        addListenerOnButton();

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), ChoixSelection.class);
                otherActivity.putExtra("matiere", matiere);
                startActivity(otherActivity);
                finish();
            }
        });
    }
    @SuppressLint("ResourceType")
    public  void  addItemsOnSpinner2() {
        spinner0 = (Spinner) findViewById(R.id.spinner0);
        List<String> list = new ArrayList<String>();
        if (matiere.equals("svt")){
            remplissageSvt(list);
        }
        else if (matiere.equals("physique")) {
            remplissagePhy(list);
        }
        else if (matiere.equals("math")){
            remplissageMath(list);
        }
        else
            showMessage("erreur", "oups");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner0.setAdapter(dataAdapter);
    }

    public void remplissageSvt(List<String> list){
        list.add("Biologie");
        list.add("I Des molécules du vivant à la cellule : organisation fonctionnelle");
        list.add("I-A Organisation fonctionnelle des molécules du vivant");
        list.add("I-B Membrane et échanges membranaires");
        list.add("I-C Métabolisme cellulaire");
        list.add("II L'organisme : un système en interaction avec son environnement");
        list.add("II-A L'organisme vivant : un système physico-chimique en interaction avec son environnement");
        list.add("II-B Exemple d'une fonction en interaction directe avec l'environnement : la respiration");
        list.add("II-C Un exemple d'intégration d'une fonction à l'échelle de l'organisme");
        list.add("II-D Ontogenèse et reproduction");
        list.add("II-E Diversité morpho-fonctionnelle des Angiospermes*");
        list.add("II-F Diversité morpho-fonctionnelle des organismes");
        list.add("III Populations, écosystèmes, biosphère");
        list.add("III-A Les populations et leur dynamique");
        list.add("III-B Les écosystèmes, leur structure et leur fonctionnement ");
        list.add("III-C Flux et cycles biogéochimiques : l'exemple du carbone*");
        list.add("IV la biodiversité et sa dynamique");
        list.add("IV-A Génomique structurale et fonctionnelle");
        list.add("IV-B Réplication de l'information génétique et mitose*");
        list.add("IV-C La diversification des génomes");
        list.add("IV-D Les mécanismes de l'évolution");
        list.add("IV-E Une approche phylogénétique de la biodiversité");
        list.add("Géologie");
        list.add("I La Terre, planète active");
        list.add("II Risques et ressources : les géosciences et l’Homme");
        list.add("III La géologie, une science historique");
        list.add("IV La carte géologique");
        list.add("V Le magmatisme");
        list.add("VI  Le phénomène sédimentaire");
        list.add("VI-B La sédimentation des particules et des solutés");
        list.add("VI-C  Bassins sédimentaires et formation des roches");
        list.add("VII  Les déformations de la lithosphère et les transformations minérales associées");
        list.add("VII-A  Déformations des matériaux de la lithosphère ");
        list.add("VII-B Les transformations minérales du métamorphisme");
    }

    public void remplissagePhy(List<String> list){
        Log.d("état","remplissage");
        list.add("1) Thermodynamique");
        list.add("2) Mécanique");
        list.add("2)a Mécanique des fluides");
        list.add("2)b Mécanique du point");
        list.add("3) Incertitudes");
        list.add("4) Optique géométrique");
        list.add("5) Phénomènes de transport");
        list.add("6) Unités");
    }

    public void remplissageMath(List<String> list){
        list.add("1) Développements limités");
        list.add("2) Dérivées");
        list.add("3) Primitives");
        list.add("4) Séries numériques");
        list.add("5) Probabilités");
        list.add("5)a Lois");
        list.add("5)b Probabilités discrètes");
        list.add("5)c Variables aléatoires discrètes");
        list.add("5)d Variables aléatoires continues");
    }


    public void addListenerOnButton(){
        spinner0 = (Spinner) findViewById(R.id.spinner0);
        submit = (Button) findViewById(R.id.btnSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selection = String.valueOf(spinner0.getSelectedItem());
                if (matiere.equals("svt")){
                    Intent otherActivity = new Intent(getApplicationContext(), QcmDefenition.class);
                    otherActivity.putExtra("chapitre", selection);
                    otherActivity.putExtra("matiere", matiere);
                    otherActivity.putExtra("lettre", "");
                    startActivity(otherActivity);
                    finish();
                }
                else if (matiere.equals("physique")){
                    Intent otherActivity = new Intent(getApplicationContext(), ChoixMode.class);
                    otherActivity.putExtra("chapitre", selection);
                    otherActivity.putExtra("matiere", matiere);
                    startActivity(otherActivity);
                    finish();
                }
                else if (matiere.equals("math")){
                    Intent otherActivity = new Intent(getApplicationContext(), QcmFormule.class);
                    otherActivity.putExtra("chapitre", selection);
                    otherActivity.putExtra("matiere", matiere);
                    startActivity(otherActivity);
                    finish();
                }
                else {
                    Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                    showMessage("oups", "empty database");
                    startActivity(otherActivity);
                    finish();
                }

            }
        });
    }

    public void showMessage (String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage((message));
        builder.show();
    }
}
