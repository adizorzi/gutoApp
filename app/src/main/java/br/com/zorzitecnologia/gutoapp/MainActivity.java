package br.com.zorzitecnologia.gutoapp;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.zorzitecnologia.gutoapp.database.DadosOpenHelper;
import br.com.zorzitecnologia.gutoapp.entidades.Imagens;
import br.com.zorzitecnologia.gutoapp.entidades.ImagensRepositorio;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView lstDados;
    private RecyclerView preFraseDados;
    public List<Imagens> lstSelecionados = new ArrayList<>() ;
    private SQLiteDatabase conexao;
    private ConstraintLayout layoutContentMain;
    private PreFraseAdapter preFraseAdapter;

    private DadosOpenHelper dadosOpenHelper;
    private ImagensRepositorio imagensRepositorio;
    private ImagemAdapter imagemAdapter;
    public FloatingActionButton fab = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lstDados = (RecyclerView)findViewById(R.id.lstDados);

        layoutContentMain = (ConstraintLayout)findViewById(R.id.layoutContentMain);

        criarConexao();

        lstDados.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        lstDados.setLayoutManager(new GridLayoutManager(this,2));

        imagensRepositorio = new ImagensRepositorio(conexao);

        List<Imagens> dados = imagensRepositorio.buscarClasses();

        Intent i = getIntent();
        preFraseDados = (RecyclerView) findViewById(R.id.lstPreFrase);
        preFraseDados.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManagerPrefraze = new LinearLayoutManager(this);
        preFraseDados.setLayoutManager(new GridLayoutManager(this, 4));

        if (lstSelecionados != null) {
            preFraseAdapter = new PreFraseAdapter(lstSelecionados, getApplicationContext(), this);
            preFraseDados.setAdapter(preFraseAdapter);

        }

        imagemAdapter = new ImagemAdapter(dados, getApplicationContext(), this, preFraseAdapter);
        lstDados.setAdapter(imagemAdapter);


        lstDados.setAdapter(imagemAdapter);

        fab = (FloatingActionButton) findViewById(R.id.fab);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            List<Imagens> dados = imagensRepositorio.buscaCategoriaImg(1);
            imagemAdapter.setDados(dados);
            imagemAdapter.notifyDataSetChanged();
        } else if (id == R.id.nav_gallery) {
            List<Imagens> dados = imagensRepositorio.buscaCategoriaImg(2);
            imagemAdapter.setDados(dados);
            imagemAdapter.notifyDataSetChanged();
        } else if (id == R.id.nav_slideshow) {
            List<Imagens> dados = imagensRepositorio.buscaCategoriaImg(3);
            imagemAdapter.setDados(dados);
            imagemAdapter.notifyDataSetChanged();
        } else if (id == R.id.nav_manage) {
            List<Imagens> dados = imagensRepositorio.buscaCategoriaImg(4);
            imagemAdapter.setDados(dados);
            imagemAdapter.notifyDataSetChanged();
        } else if (id == R.id.nav_share) {
            List<Imagens> dados = imagensRepositorio.buscaCategoriaImg(5);
            imagemAdapter.setDados(dados);
            imagemAdapter.notifyDataSetChanged();
        }else if (id == R.id.nav_todos) {
            List<Imagens> dados = imagensRepositorio.buscarClasses();
            imagemAdapter.setDados(dados);
            imagemAdapter.notifyDataSetChanged();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void criarConexao(){
        try {
            dadosOpenHelper = new DadosOpenHelper(this);
            conexao = dadosOpenHelper.getWritableDatabase();

        }catch (SQLException ex){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Erro");
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton("Ok", null);
            dlg.show();
        }
    }
}
