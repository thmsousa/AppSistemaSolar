package com.example.appsistemasolar;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pesos_calculados")
public class Peso {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "nome_planeta")
    public String nomePlaneta;

    @ColumnInfo(name = "nome_usuario")
    public String nomeUsuario;

    @ColumnInfo(name = "massa")
    public double massa;

    @ColumnInfo(name = "peso_calculado")
    public double pesoCalculado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomePlaneta() {
        return nomePlaneta;
    }

    public void setNomePlaneta(String nomePlaneta) {
        this.nomePlaneta = nomePlaneta;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public double getMassa() {
        return massa;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    public double getPesoCalculado() {
        return pesoCalculado;
    }

    public void setPesoCalculado(double pesoCalculado) {
        this.pesoCalculado = pesoCalculado;
    }
}