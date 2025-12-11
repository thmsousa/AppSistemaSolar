package com.example.appsistemasolar;

import java.io.Serializable;

public class Planeta implements Serializable {
    private String nome;
    private int imagem;
    private double gravidade;

    public String getNome() {
        return nome;
    }

    public Planeta(String nome, int imagem, double gravidade) {
        this.nome = nome;
        this.imagem = imagem;
        this.gravidade = gravidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public double getGravidade() {
        return gravidade;
    }

    public void setGravidade(double gravidade) {
        this.gravidade = gravidade;
    }

    @Override
    public String toString() {
        return "Planeta{" +
                "nome='" + nome + '\'' +
                ", imagem=" + imagem +
                ", gravidade=" + gravidade +
                '}';
    }

    public double calcularPeso(double massa) {
        return massa * this.gravidade;
    }

}
