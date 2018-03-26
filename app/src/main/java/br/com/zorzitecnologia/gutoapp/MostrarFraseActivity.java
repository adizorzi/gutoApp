package br.com.zorzitecnologia.gutoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.zorzitecnologia.gutoapp.entidades.Imagens;

public class MostrarFraseActivity extends AppCompatActivity {

    public List<Imagens> listaSelecionados;
    List<Imagens> listImg = new ArrayList<Imagens>();
    private RecyclerView lstFrase;
    private ConstraintLayout layoutContentMostraFrase;
    private FraseAdapter fraseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_frase);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Intent i = getIntent();
        lstFrase = (RecyclerView)findViewById(R.id.lstFrase);
        layoutContentMostraFrase = (ConstraintLayout)findViewById(R.id.layoutContentMostraFrase);
        lstFrase.setLayoutManager(new GridLayoutManager(this, 2));

        lstFrase.setHasFixedSize(true);

        listaSelecionados = (List<Imagens>) i.getSerializableExtra("listaImg");





        if (listaSelecionados != null) {
            fraseAdapter = new FraseAdapter(listaSelecionados, getApplicationContext(), this);
            lstFrase.setAdapter(fraseAdapter);

        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
