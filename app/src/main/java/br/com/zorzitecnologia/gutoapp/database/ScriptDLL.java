package br.com.zorzitecnologia.gutoapp.database;

/**
 * Created by adriano on 24/01/18.
 */

public class ScriptDLL {
    public static String getCreateTableImagens(){
        StringBuilder sql = new StringBuilder();

        sql.append(" CREATE TABLE IF NOT EXISTS IMAGENS ( ");
        sql.append(" IMGID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ");
        sql.append(" IMGIMAGEM VARCHAR(255) NOT NULL DEFAULT(''), ");
        sql.append(" IMGDESCRICAO VARCHAR(100) NOT NULL DEFAULT(''), ");
        sql.append(" IMGIMGID INTEGER NOT NULL) ");

        return sql.toString();
    }

    public static String getInsertTableImagens()
    {
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO IMAGENS (IMGIMAGEM, IMGDESCRICAO, IMGIMGID) VALUES ('imagem1','imagem1', 1),");
        sql.append("('imagem2','Imagem2', 1),");
        sql.append("('imagem3','Imagem3', 2),");
        sql.append("('imagem4','Imagem4', 2),");
        sql.append("('imagem5','Imagem5', 3),");
        sql.append("('imagem7','Imagem7', 3),");
        sql.append("('imagem6','Imagem6', 4),");
        sql.append("('imagem8','Imagem8', 4);");

        return  sql.toString();
    }
}
