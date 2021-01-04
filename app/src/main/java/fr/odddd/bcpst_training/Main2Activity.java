package fr.odddd.bcpst_training;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import io.github.kexanie.library.MathView;

public class Main2Activity extends AppCompatActivity {

    private MathView plage;
    private MathView plage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        plage = (MathView) findViewById(R.id.plage_de_texte_formule_22);
        plage2 = (MathView) findViewById(R.id.plage_de_texte_formule_2);

        plage2.setText("\\[F_X(x) = \\begin{cases} 0 & si \\; x  x_1 \\\\ 1 & si \\; x \\geqslant x_n \\\\ \\sum_{i = 1}^n P(X = x_i) & \\text{sinon} \\end{cases}\\]");
        plage.setText("\\[F_X(x) = \\begin{cases} 0 & si \\; x < x_1 \\\\ 1 & si \\; x \\geqslant x_n \\\\ \\sum_{i = 1}^n P(X = x_i) & \\text{sinon} \\end{cases}\\]");
    }
}
