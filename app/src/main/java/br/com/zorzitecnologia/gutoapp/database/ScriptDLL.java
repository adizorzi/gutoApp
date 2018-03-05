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

        sql.append("INSERT INTO IMAGENS (IMGIMAGEM, IMGDESCRICAO, IMGIMGID) VALUES ");
        sql.append("('avos','Avos', 1),");
        sql.append("('eu','Eu', 1),");
        sql.append("('irma','Irma', 1),");
        sql.append("('irmao','Irmão', 1),");
        sql.append("('mamae','Mamãe', 1),");
        sql.append("('papai','Papai', 1),");
        sql.append("('professora','Professora', 1),");
        sql.append("('vo_homem','Vovô', 1),");
        sql.append("('vo_mulher','Vovó', 1),");
        sql.append("('beber','Beber', 2),");
        sql.append("('buscar','Buscar', 2),");
        sql.append("('entrar','Entrar', 2),");
        sql.append("('falar','Falar', 2),");
        sql.append("('lavar','Lavar', 2),");
        sql.append("('sair','Sair', 2),");
        sql.append("('cama','Cama', 3),");
        sql.append("('casa','Casa', 3),");
        sql.append("('cozinha','Cozinha', 3),");
        sql.append("('escola','Escola', 3),");
        sql.append("('praca','Praça', 3),");
        sql.append("('sala','Sala', 3),");
        sql.append("('abaixo','Abaixo', 4),");
        sql.append("('aberto','Aberto', 4),");
        sql.append("('aceso','Aceso', 4),");
        sql.append("('acompanhado','Acompanhado', 4),");
        sql.append("('acordado','Acordado', 4),");
        sql.append("('agora','Agora', 4),");
        sql.append("('ai','Ai', 4),");
        sql.append("('amado','Amado', 4),");
        sql.append("('apagado','Apagado', 4),");
        sql.append("('aqui','Aqui', 4),");
        sql.append("('arumado','Arumado', 4),");
        sql.append("('atras','Atras', 4),");
        sql.append("('bom','Bom', 4),");
        sql.append("('bonito','Bonito', 4),");
        sql.append("('certo','Certo', 4),");
        sql.append("('depenteado','Depenteado', 4),");
        sql.append("('agradavel','Agradavel', 5),");
        sql.append("('assustado','Assustado', 5),");
        sql.append("('calor','Calor', 5),");
        sql.append("('cansado','Cansado', 5),");
        sql.append("('confuso','Confuso', 5),");
        sql.append("('contente','Contente', 5),");
        sql.append("('desagradavel','Desagradavel', 5),");
        sql.append("('feliz','Feliz', 5),");
        sql.append("('inrridado','Inrridado', 5),");
        sql.append("('nao_gosto','Não gosto', 5),");
        sql.append("('nervoso','Nervoso', 5),");
        sql.append("('satisfeito','Satisfeito', 5);");

        return  sql.toString();
    }
}
