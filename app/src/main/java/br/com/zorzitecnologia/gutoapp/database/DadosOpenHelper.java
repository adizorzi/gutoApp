package br.com.zorzitecnologia.gutoapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by adriano on 24/01/18.
 */

public class DadosOpenHelper extends SQLiteOpenHelper{
    public DadosOpenHelper(Context context) { super(context, "DADOS", null, 7);}

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ScriptDLL.getCreateTableImagens());
        db.execSQL(ScriptDLL.getInsertTableImagens());
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IMAGENS");
        this.onCreate(db);
    }
}
