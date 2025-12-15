package com.example.appsistemasolar;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Peso.class}, version = 1)
public abstract class Banco extends RoomDatabase {

    private static Banco INSTANCIA;

    public abstract PesoDAO pesoCalculadoDao();

    public static synchronized Banco getInstancia(Context context) {
        if (INSTANCIA == null) {
            INSTANCIA = Room.databaseBuilder(context.getApplicationContext(),Banco.class,"meu_banco").build();
        }
        return INSTANCIA;
    }
}
