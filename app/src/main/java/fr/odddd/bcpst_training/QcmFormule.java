package fr.odddd.bcpst_training;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import io.github.kexanie.library.MathView;

public class QcmFormule extends AppCompatActivity {

    private MathView plage;
    private ImageView apres;
    private ImageView home;
    private ImageView retour;

    private String matiere;
    private String lettre_physique;
    private String chapitre;

    DataBaseHelper db;

    private String[][] liste_1;
    private Cursor liste;

    private String matiere_code;

    private int conteur = 0;
    private int petit_conteur = -1;
    private boolean pass;
    private int max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qcm_formule);

        home = this.findViewById(R.id.menu_bis);
        plage = (MathView) findViewById(R.id.plage_de_texte_formule);
        retour = this.findViewById(R.id.retour_formule);
        apres = (ImageView) findViewById(R.id.suivant);

        Intent i = getIntent();
        matiere = i.getStringExtra("matiere");
        lettre_physique = "l";
        chapitre = i.getStringExtra("chapitre");

        db = new DataBaseHelper(this);

        switch(matiere){
            case "svt":
                matiere_code = "SVT";
                chapitre = trans_svt(chapitre);
                break;
            case "physique":
                matiere_code = "PHY";
                chapitre = trans_physique(chapitre);
                break;
            case "math":
                matiere_code = "MAT";
                chapitre = trans_math(chapitre);
                break;
            default:
                matiere_code = "SVT";
        }

        liste = db.getInfo(matiere_code, lettre_physique, chapitre);

        if (liste.getCount()==0){
            liste_1 = new String[1][3];
            liste_1[0][0] = "oups";
            liste_1[0][1] = "pas de formules dans ce chapitre :(";
            liste_1[0][2] = "oups";
        }
        else
            liste_1 = faire(liste);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chapitre.equals("")|| chapitre.equals("concours")){
                    Intent otherActivity = new Intent(getApplicationContext(), MenuMatiere.class);
                    startActivity(otherActivity);
                    finish();
                }
                else {
                    Intent otherActivity = new Intent(getApplicationContext(), ChoixChapitre.class);
                    otherActivity.putExtra("matiere", matiere);
                    startActivity(otherActivity);
                    finish();
                }
            }
        });

        apres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                max = liste_1.length;
                petit_conteur++;
                if (conteur >= max-1 && petit_conteur >= 2)
                    plage.setText("Bravo tu es venu à bout des " + max + " formules de ce chapitre !");
                else {
                    if (petit_conteur > 1) {
                        petit_conteur = 0;
                        conteur++;
                    }
                    plage.setText(liste_1[conteur][petit_conteur]);
                }
            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                max = liste_1.length;
                pass = true;
                if ((conteur <= 0 && petit_conteur <= 0)||(conteur >= max-1 && petit_conteur >= 2))
                    pass = false;
                if (pass){
                    if (petit_conteur >= 1) {
                        petit_conteur = 0;
                    }
                    else {
                        petit_conteur++;
                        conteur = conteur - 1;
                    }
                    plage.setText(liste_1[conteur][petit_conteur]);}
            }
        });

        plage.setText("Formules de " + matiere+ " \n Appuyez sur suivant pour commencer");
    }

    public String trans_physique(String choix){
        String result;
        switch(choix) {
            case "2) Mécanique":
                result = "ME";
                break;
            case "2)b Mécanique du point":
                result = "MEP";
                break;
            case "2)a Mécanique des fluides":
                result = "MEF";
                break;
            case "1) Thermodynamique":
                result = "TH";
                break;
            case "Electricité":
                result = "EL";
                break;
            case "3) Incertitudes":
                result = "INC";
                break;
            case "4) Optique géométrique":
                result = "OPT";
                break;
            case "5) Phénomènes de transport":
                result = "TRA";
                break;
            case "6) Unités":
                result = "UNI";
                break;
            case "concours":
                result = "";
                break;
            default:
                result = "";
        }
        return result;
    }

    public String trans_svt(String choix){
        String result;
        switch (choix)
        {
            case "Biologie":
                result = "s";
                break;
            case "I Des molécules du vivant à la cellule : organisation fonctionnelle":
                result = "s1";
                break;
            case  "I-A Organisation fonctionnelle des molécules du vivant":
                result = "s1-A";
                break;
            case  "I-B Membrane et échanges membranaires":
                result = "s1-B";
                break;
            case  "I-C Métabolisme cellulaire":
                result = "s1-C";
                break;
            case "II L'organisme : un système en interaction avec son environnement":
                result = "s2";
                break;
            case  "II-A L'organisme vivant : un système physico-chimique en interaction avec son environnement":
                result = "s2-A";
                break;
            case  "II-B Exemple d'une fonction en interaction directe avec l'environnement : la respiration":
                result = "s2-B";
                break;
            case  "II-C Un exemple d'intégration d'une fonction à  l'échelle de l'organisme":
                result = "s2-C";
                break;
            case "II-D Ontogenèse et reproduction":
                result = "s2-D";
                break;
            case  "II-E Diversité morpho-fonctionnelle des Angiospermes*":
                result = "s2-E";
                break;
            case  "II-F Diversité morpho-fonctionnelle des organismes":
                result = "s2-F";
                break;
            case  "III Populations, écosystèmes, biosphère":
                result = "s3";
                break;
            case "III-A Les populations et leur dynamique":
                result = "s3-A";
                break;
            case  "III-B Les écosystèmes, leur structure et leur fonctionnement ":
                result = "s3-B";
                break;
            case  "III-C Flux et cycles biogéochimiques : l'exemple du carbone*":
                result = "s3-C";
                break;
            case  "IV la biodiversité et sa dynamique":
                result = "s4";
                break;
            case  "IV-A Génomique structurale et fonctionnelle":
                result = "s4-A";
                break;
            case  "IV-B Réplication de l'information génétique et mitose*":
                result = "s4-B";
                break;
            case  "IV-C La diversification des génomes":
                result = "s4-C";
                break;
            case  "IV-D Les mécanismes de l'évolution":
                result = "s4-D";
                break;
            case "IV-E Une approche phylogénétique de la biodiversité":
                result = "s4-E";
                break;
            case "Géologie" :
                result = "g";
                break;
            case  "I La Terre, planète active":
                result = "g1";
                break;
            case  "II Risques et ressources : les géosciences et l’Homme":
                result = "g2";
                break;
            case  "III La géologie, une science historique":
                result = "g3";
                break;
            case  "IV La carte géologique":
                result = "g4";
                break;
            case  "V Le magmatisme":
                result = "g5";
                break;
            case  "VI-B La sédimentation des particules et des solutés":
                result = "g6-B";
                break;
            case "VI-C  Bassins sédimentaires et formation des roches":
                result = "g6-C";
                break;
            case  "VII  Les déformations de la lithosphère et les transformations minérales associées":
                result = "g7";
                break;
            case  "VII-A  Déformations des matériaux de la lithosphère":
                result = "g7-A";
                break;
            case  "VII-B Les transformations minérales du métamorphisme":
                result = "g7-B";
                break;
            case "concours":
                result = "";
                break;
            default:
                result = "";
        }
        return result;
    }

    public String[][] faire(Cursor liste){
        liste_1 = new String[liste.getCount()][3];
        int[] random = randomisation(liste.getCount());
        for (int j = 0; j < liste.getCount(); j++) {
            liste.moveToPosition(random[j]);
            liste_1[j][0] = liste.getString(0);
            liste_1[j][1] = liste.getString(1);
            liste_1[j][2] = liste.getString(2);}
        return liste_1;
    }

    private String trans_math(String choix){
        String result;
        switch (choix) {
            case "1) Développements limités":
                result = "DL";
                break;
            case "2) Dérivées":
                result = "DER";
                break;
            case "3) Primitives":
                result = "PRI";
                break;
            case "5) Probabilités":
                result = "PO";
                break;
            case "5)a Lois":
                result = "POL";
                break;
            case "5)b Probabilités discrètes":
                result = "POP";
                break;
            case "5)c Variables aléatoires discrètes":
                result = "POD";
                break;
            case "5)d Variables aléatoires continues":
                result = "POC";
                break;
            case "4) Séries numériques" :
                result = "SER";
                break;
            case "concours":
                result = "";
                break;
            default:
                result = "";
        }
        return result;
    }

    public int[] randomisation(int nb) {
        int[] liste = new int[nb];
        liste[0] = 0;
        int a = 0;
        int b = 0;
        while (b < nb-1) {
            while (contains(liste, a))
                a = new Random().nextInt(nb);
            b++;
            liste[b] = a;
        }
        return liste;
    }

    private boolean contains(int[] liste, int a) {
        for (int i = 0; i < liste.length; i ++){
            if (liste[i] == a)
                return true;}
        return false;
    }
}
