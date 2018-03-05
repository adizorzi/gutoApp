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

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
