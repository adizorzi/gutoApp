package br.com.zorzitecnologia.gutoapp;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.zorzitecnologia.gutoapp.entidades.Imagens;

/**
 * Created by adriano on 12/02/18.
 */

public class PreFraseAdapter extends RecyclerView.Adapter<PreFraseAdapter.ViewHorderFrase> {
    private List<Imagens> dados;
    public List<Imagens> listImg = new ArrayList<>();
    private Context context;
    private PreFraseAdapter preFraseAdapter;

    public PreFraseAdapter(List<Imagens> dados, Context applicationContext, Context context) {
        this.dados = dados;
        this.context = context;
    }
    public void setDados(List<Imagens> dados){
        this.dados = dados;
        this.listImg = dados;
    }

    @Override
    public PreFraseAdapter.ViewHorderFrase onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.linha_pre_frase, parent, false);

        ViewHorderFrase horderFrase = new ViewHorderFrase(view);

        return horderFrase;
    }

    @Override
    public void onBindViewHolder(PreFraseAdapter.ViewHorderFrase holder, final int position) {
        Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier(dados.get(position).imgimagem, "drawable",
                context.getPackageName());

        holder.txtPreTituloFrase.setText(dados.get(position).imgdescricao);
        holder.imgPreFrase.setImageDrawable(resources.getDrawable(resourceId));
        holder.imgPreFrase.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "asdfasdf", Toast.LENGTH_SHORT).show();
                Imagens img = dados.get(position);
//                if(holder.imgSelected.getVisibility() == View.VISIBLE){
//                    holder.imgSelected.setVisibility(View.INVISIBLE);
                    listImg.remove(img);
                    setDados(listImg);
                    notifyDataSetChanged();



//                } else {
//                    holder.imgSelected.setVisibility(View.VISIBLE);
    //                listImg.add(img);
    //                preFraseAdapter.setDados(listImg);
    //                preFraseAdapter.notifyDataSetChanged();

//                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class ViewHorderFrase extends RecyclerView.ViewHolder {

        public TextView txtPreTituloFrase;
        public ImageView imgPreFrase;

        public ViewHorderFrase(View itemView) {
            super(itemView);
            txtPreTituloFrase= itemView.findViewById(R.id.txtPreTituloFrase);
            imgPreFrase = itemView.findViewById(R.id.imgPreFrase);
        }
    }
}
