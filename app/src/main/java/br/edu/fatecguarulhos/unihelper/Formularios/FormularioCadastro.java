package br.edu.fatecguarulhos.unihelper.Formularios;

import android.widget.EditText;

import java.util.List;

public class FormularioCadastro {
    private EditText editNome, editEmail, editSenha, editConfirmarSenha;
    private List<EditText> campos;
    public FormularioCadastro(EditText editNome, EditText editEmail, EditText editSenha, EditText editConfirmarSenha) {
        this.editNome = editNome;
        this.editEmail = editEmail;
        this.editSenha = editSenha;
        this.editConfirmarSenha = editConfirmarSenha;
        campos = List.of(editNome, editEmail, editSenha, editConfirmarSenha);
    }
    public Boolean formularioValido(){
        boolean valido = false;
        int camposVazios = 0;
        for (int i = 0; i < campos.size(); i++) {
            valido = verificarSeEstaVazio(campos.get(i));
            if(!valido) camposVazios++;
        }
        List<Boolean> camposValidos = List.of(validarSenha());
        return (senhasBatem() && camposVazios == 0);
    }
    private Boolean validarSenha(){
        boolean valido = false;
        String senha = editSenha.getText().toString();
        if(senha.isBlank()) editSenha.setError("");
        else if(senha.length() < 6) editSenha.setError("Mínimo de 6 caracteres");
        else valido = true;
        return valido;
    }
    private boolean senhasBatem(){
        String senha = editSenha.getText().toString();
        String confirmarSenha = editConfirmarSenha.getText().toString();
        if(senha.isBlank() || confirmarSenha.isBlank())
            return false;
        if(senha.toString().equals(confirmarSenha.toString())) return true;
        else {
            editConfirmarSenha.setError("A senha deve ser igual nos dois campos");
            return false;
        }
    }
    private boolean verificarSeEstaVazio(EditText editText){
        if(editText.getText().toString().isBlank()){
            editText.setError("Campo não pode estar vazio");
            return false;
        }
        else return true;
    }
}
