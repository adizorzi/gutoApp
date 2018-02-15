package br.com.zorzitecnologia.gutoapp.entidades;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.zorzitecnologia.gutoapp.ImagemAdapter;

/**
 * Created by adriano on 24/01/18.
 */

public class ImagensRepositorio {
    private SQLiteDatabase conexao;

    public ImagensRepositorio(SQLiteDatabase conexao) { this.conexao = conexao; }

    public List<Imagens> buscarClasses(){
        List<Imagens> imagens = new ArrayList<Imagens>();
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT * FROM IMAGENS ");

        Cursor resultado = conexao.rawQuery(sql.toString(), null);

        if(resultado.getCount() > 0) {
            resultado.moveToFirst();

            do{
                Imagens img = new Imagens();

                img.imgid = resultado.getInt( resultado.getColumnIndexOrThrow("IMGID") );
                img.imgimagem = resultado.getString( resultado.getColumnIndexOrThrow("IMGIMAGEM") );
                img.imgdescricao = resultado.getString( resultado.getColumnIndexOrThrow("IMGDESCRICAO") );
                img.imgimgid = resultado.getInt( resultado.getColumnIndexOrThrow("IMGIMGID") );

                imagens.add(img);
            }while (resultado.moveToNext());
        }

        return imagens;
    }

    public List<Imagens> buscaCategoriaImg(int i){
        List<Imagens> imagens = new ArrayList<Imagens>();
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT * FROM IMAGENS WHERE IMGIMGID = ");
        sql.append(i);

        Cursor resultado = conexao.rawQuery(sql.toString(), null);
        if(resultado.getCount() > 0) {
            resultado.moveToFirst();
            do {
                Imagens img = new Imagens();

                img.imgid = resultado.getInt( resultado.getColumnIndexOrThrow("IMGID") );
                img.imgimagem = resultado.getString( resultado.getColumnIndexOrThrow("IMGIMAGEM") );
                img.imgdescricao = resultado.getString( resultado.getColumnIndexOrThrow("IMGDESCRICAO") );
                img.imgimgid = resultado.getInt( resultado.getColumnIndexOrThrow("IMGIMGID") );

                imagens.add(img);
            }while (resultado.moveToNext());
        }
        return imagens;
    }
}
