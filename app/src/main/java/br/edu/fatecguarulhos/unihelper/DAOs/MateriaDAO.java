package br.edu.fatecguarulhos.unihelper.DAOs;

import android.content.ContentValues;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import br.edu.fatecguarulhos.unihelper.Models.Materia;
import br.edu.fatecguarulhos.unihelper.Models.Usuario;

public class MateriaDAO {

    private CollectionReference materiaColletion;
    private Context context;

    public MateriaDAO(Context context){
        materiaColletion = FirebaseFirestore.getInstance().collection("materia");
        this.context = context;
    }

    public void addMateria(Materia materia){
     materiaColletion.add(materia)
             .addOnSuccessListener(documentReference ->{
                 String idGerado = documentReference.getId();
                 Toast.makeText(context, "Matéria cadastrada", Toast.LENGTH_SHORT).show();
             })
                .addOnFailureListener(e -> {
                    Toast.makeText(context, "Erro: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

    public void alterarMateria(Materia materia){
        materiaColletion.document(materia.getId()).set(materia);
    }
    public void deletarMateria(String idMateria){
        materiaColletion.document(idMateria).delete();
    }
}
