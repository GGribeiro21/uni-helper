package br.edu.fatecguarulhos.unihelper.Models;

import java.util.Date;

public class Materia {

    private String id, nome, formulaMedia;
    private float nota;
    private Date dataProva;

    public Materia(){}

    public String getId(){ return id; }
    public void setId(String id){ this.id = id; }
    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getFormulaMedia() { return formulaMedia; }

    public void setFormulaMedia(String formulaMedia) { this.formulaMedia = formulaMedia; }

    public float getNota() { return nota; }

    public void setNota(float nota) { this.nota = nota; }

    public Date getData() { return dataProva; }

    public void setData(Date data) { this.dataProva = data; }

    public long diasRestantes(){
        Date hoje = new Date();

        long difenca = dataProva.getTime() - hoje.getTime();
        return difenca / (1000 * 60 * 60 * 24);
    }

}
