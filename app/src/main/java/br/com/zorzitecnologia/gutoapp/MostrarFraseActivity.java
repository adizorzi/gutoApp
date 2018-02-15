package br.com.zorzitecnologia.gutoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.zorzitecnologia.gutoapp.entidades.Imagens;

public class MostrarFraseActivity extends AppCompatActivity {

    public List<Imagens> listaSelecionados;
    List<Imagens> listImg = new ArrayList<Imagens>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_frase);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        Intent i = getIntent();
        listaSelecionados = (List<Imagens>) i.getSerializableExtra("listaImg");

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (listaSelecionados != null) {
            for (Imagens imagens:listaSelecionados) {
                Log.d("teste ", imagens.imgdescricao);
            }
        }
    }

}
