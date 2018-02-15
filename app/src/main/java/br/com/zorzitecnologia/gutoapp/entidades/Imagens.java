package br.com.zorzitecnologia.gutoapp.entidades;

import java.io.Serializable;

/**
 * Created by adriano on 24/01/18.
 */

public class Imagens implements Serializable{
    public int imgid;
    public String imgimagem;
    public String imgdescricao;
    public int imgimgid;

    public Imagens(int imgid, String imgimagem, String imgdescricao, int imgimgid) {
        this.imgid = imgid;
        this.imgimagem = imgimagem;
        this.imgdescricao = imgdescricao;
        this.imgimgid = imgimgid;
    }
}
