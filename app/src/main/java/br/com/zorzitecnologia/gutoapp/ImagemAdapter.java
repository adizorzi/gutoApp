package br.com.zorzitecnologia.gutoapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.zorzitecnologia.gutoapp.entidades.Imagens;

/**
 * Created by adriano on 30/01/18.
 */

public class ImagemAdapter extends RecyclerView.Adapter<ImagemAdapter.ViewHorderImagem>{

    private List<Imagens> dados;
    private Context context;
    public List<Imagens> listImg = new ArrayList<>();
    public MainActivity activity;
    private PreFraseAdapter preFraseAdapter;

    public ImagemAdapter(List<Imagens> dados, Context context, MainActivity activity, PreFraseAdapter preFraseAdapter) {
        this.dados = dados;
        this.context = context;
        this.activity = activity;
        this.preFraseAdapter = preFraseAdapter;
    }

    public void setDados(List<Imagens> dados){
        this.dados = dados;
    }

    @Override
    public ImagemAdapter.ViewHorderImagem onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.linha_imagem, parent, false);

        ViewHorderImagem horderImagem = new ViewHorderImagem(view);

        return horderImagem;
    }

    @Override
    public void onBindViewHolder(final ImagemAdapter.ViewHorderImagem holder, final int position) {

        Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier(dados.get(position).imgimagem, "drawable",
                context.getPackageName());

        holder.txtTituloImg.setText(dados.get(position).imgdescricao);
        holder.imgLista.setImageDrawable(resources.getDrawable(resourceId));
        holder.imgLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Imagens img = dados.get(position);
                    listImg.add(img);
                    preFraseAdapter.setDados(listImg);
                    preFraseAdapter.notifyDataSetChanged();

//                }
            }
        });
        activity.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MostrarFraseActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("listaImg", (Serializable) listImg);
                intent.putExtras(bundle);
                context.startActivity(intent);
                listImg = new ArrayList<>();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class ViewHorderImagem extends RecyclerView.ViewHolder {

        public TextView txtTituloImg;
        public ImageView imgLista;
        public ImageView imgSelected;

        public ViewHorderImagem(View itemView) {

            super(itemView);
            txtTituloImg = itemView.findViewById(R.id.txtTituloImg);
            imgLista = itemView.findViewById(R.id.imgLista);
            imgSelected = itemView.findViewById(R.id.imgSelected);

        }
    }
}
