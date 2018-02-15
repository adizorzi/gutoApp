package br.com.zorzitecnologia.gutoapp;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.zorzitecnologia.gutoapp.entidades.Imagens;

/**
 * Created by adriano on 12/02/18.
 */

public class FraseAdapter extends RecyclerView.Adapter<FraseAdapter.ViewHorderFrase> {
    private List<Imagens> dados;
    private Context context;

    public FraseAdapter(List<Imagens> dados, Context context) {
        this.dados = dados;
        this.context = context;
    }
    public void setDados(List<Imagens> dados){
        this.dados = dados;
    }

    @Override
    public FraseAdapter.ViewHorderFrase onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.linha_frase, parent, false);

        ViewHorderFrase horderFrase = new ViewHorderFrase(view);

        return horderFrase;
    }

    @Override
    public void onBindViewHolder(FraseAdapter.ViewHorderFrase holder, int position) {
        Resources resources = context.getResources();
        final  int resourceId = resources.getIdentifier(dados.get(position).imgimagem, "drawable", context.getPackageCodePath());

        holder.txtTituloFrase.setText(dados.get(position).imgdescricao);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHorderFrase extends RecyclerView.ViewHolder {

        public TextView txtTituloFrase;
        public ImageView imgFrase;

        public ViewHorderFrase(View itemView) {
            super(itemView);
            txtTituloFrase= itemView.findViewById(R.id.txtTituloFrase);
            imgFrase = itemView.findViewById(R.id.imgLista);
        }
    }
}
