package es.ifp.mp04_dam_uf01_apellido_nombre;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DataBaseSQL extends SQLiteOpenHelper {

    protected SQLiteDatabase db;


    public DataBaseSQL(@Nullable Context context) {
        super(context, "notitas1", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.deleteDatabase(new File("notitas"));

        db.execSQL("CREATE table notas (id integer primary key autoincrement not null, titulo text, telefono varchar(11), lugar varchar(100), cliente varchar(100), URL varchar(100))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table IF EXISTS notas ");

    }

    public ArrayList<String> getAllNotas() {


        ArrayList<String> filas = new ArrayList<String>();
        Cursor res = null;
        String contenido = "";
        if (numberOfNotes() > 0) {
            db = this.getReadableDatabase();
            res = db.rawQuery("SELECT * FROM notas ORDER BY id", null);
            res.moveToFirst();
            while (res.isAfterLast() == false) {
                contenido = res.getInt(res.getColumnIndex("id"))
                        + " - " + res.getString(res.getColumnIndex("titulo"))
                        + " - " + res.getString(res.getColumnIndex("telefono"))
                        + " - " + res.getString(res.getColumnIndex("lugar"))
                        + " - " + res.getString(res.getColumnIndex("cliente"))
                        + " - " + res.getString(res.getColumnIndex("URL"));
                System.out.println("-->" + contenido);
                filas.add(contenido);
                res.moveToNext();

            }
        } else {
            filas.add("No hay notas");
        }
        return filas;

    }

    public Note getOneNota(int id) {

        Note note = null;
        Cursor res = null;
        String contenido = "";
        if (numberOfNotes() > 0) {
            db = this.getReadableDatabase();
            res = db.rawQuery("SELECT * FROM notas WHERE id=" + id, null);
            res.moveToFirst();
            while (res.isAfterLast() == false) {
                note = new Note(res.getInt(res.getColumnIndex("id"))
                        , res.getString(res.getColumnIndex("titulo"))
                        , res.getString(res.getColumnIndex("telefono"))
                        , res.getString(res.getColumnIndex("lugar"))
                        , res.getString(res.getColumnIndex("cliente"))
                        , res.getString(res.getColumnIndex("URL")));
                System.out.println("-->" + contenido);
                res.moveToNext();

            }
        }
        return note;


    }

    public void insertNota(String titulo, String telefono, String lugar, String cliente, String URL) {

        db = this.getWritableDatabase();
        db.execSQL("INSERT INTO notas (titulo, telefono, lugar, cliente, URL) VALUES('" + titulo + "','" + telefono + "','" + lugar + "','" + cliente + "','" + URL + "')");

    }

    public void updateNota(int id, String titulo, String telefono, String lugar, String cliente, String URL) {

        db = this.getWritableDatabase();
        db.execSQL("UPDATE notas SET titulo='" + titulo + "', telefono='" + telefono + "', lugar='" + lugar + "', cliente='" + cliente + "', URL='" + URL + "' WHERE id=" + id);

    }

    public int numberOfNotes() {
        int num = 0;
        db = this.getReadableDatabase();
        num = (int) DatabaseUtils.queryNumEntries(db, "notas");
        return num;
    }

    public void deleteNota(int id) {

        db = this.getWritableDatabase();
        db.execSQL("DELETE FROM notas WHERE id=" + id);


    }

    public void deleteAllNotas() {

        db = this.getWritableDatabase();
        db.execSQL("DELETE FROM notas");

    }

    public void close() {
        db.close();
    }
}
