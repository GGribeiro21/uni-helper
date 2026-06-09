package br.edu.fatecguarulhos.unihelper.DAOs;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.edu.fatecguarulhos.unihelper.interfaces.FirebaseCallback;
import br.edu.fatecguarulhos.unihelper.models.Materia;
import br.edu.fatecguarulhos.unihelper.models.Usuario;

public class MateriaDAO {

    private CollectionReference materiaColletion;
    private Context context;
    private String uidAluno;


    public MateriaDAO(Context context, String uidAluno){
        materiaColletion = FirebaseFirestore.getInstance().collection("usuarios");
        this.context = context;
        this.uidAluno = uidAluno;
    }

    public void cadastrarMateria(Materia materia){
        salvarMateriaFirestore(materia);
    }
    private void salvarMateriaFirestore(Materia materia){
        materiaColletion.document(uidAluno)
                .update("materias", FieldValue.arrayUnion(materia))
                .addOnSuccessListener(aVoid -> {

        });
    }
}
