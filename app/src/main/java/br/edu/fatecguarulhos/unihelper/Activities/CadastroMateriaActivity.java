package br.edu.fatecguarulhos.unihelper.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import br.edu.fatecguarulhos.unihelper.DAOs.MateriaDAO;
import br.edu.fatecguarulhos.unihelper.Models.Materia;
import br.edu.fatecguarulhos.unihelper.R;

public class CadastroMateriaActivity extends AppCompatActivity {

    private Button btnSalvar;
    private EditText edtMateria, edtNota, edtData, edtFormula;

    private Materia materia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro_materia);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       btnSalvar = findViewById(R.id.btnSalvarMateria);
       edtMateria = findViewById(R.id.edtMateria);
       edtNota = findViewById(R.id.edtNota);
       edtData = findViewById(R.id.edtData);
       edtFormula = findViewById(R.id.edtFormula);
    }

    public void voltar(View view){
        finish();
    }

    public void salvar(View view){
        materia = new Materia();
        materia.setNome(edtMateria.getText().toString());
        materia.setNota(Float.parseFloat(edtNota.getText().toString()));
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            Date dataProva = formato.parse(edtData.getText().toString());
            materia.setData(dataProva);
        } catch (ParseException e){
            edtData.setError("Data inválida");
            return;
        }
        materia.setFormulaMedia(edtFormula.getText().toString());
        MateriaDAO materiaDAO = new MateriaDAO(this);
        materiaDAO.addMateria(materia);
    }
}