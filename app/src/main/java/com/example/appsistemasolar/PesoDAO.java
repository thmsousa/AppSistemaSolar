package com.example.appsistemasolar;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface PesoDAO {
    @Insert
    void inserir(Peso pesoCalculado);
}