package com.example.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ListViewHolder> {

    private List<Hotel> produtos;
    private Context context;

    public HotelAdapter(List<Hotel> produtos, Context context) {
        this.produtos = produtos;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        context = viewGroup.getContext();
        LayoutInflater inflater =  LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.hoteis_list,viewGroup,false);
        ListViewHolder listViewHolder = new ListViewHolder(view);


        return listViewHolder;
    }





    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder listViewHolder, final int position) {

        //Captura os clicks nos cardViews
        listViewHolder.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Hotel produto = produtos.get(position);


                        if ((v.findViewById(R.id.detalhe) != null) || (v.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)){

                            HotelDetalheFragment fragment = HotelDetalheFragment.instanciaFragment(produto);
                            FragmentManager fm = ((AppCompatActivity) context).getSupportFragmentManager();

                            FragmentTransaction ft = fm.beginTransaction();
                            ft.replace(R.id.detalhe, fragment, HotelDetalheFragment.TAG_DETALHE);
                            ft.commit();

                        }else {


                            Intent intent = new Intent(v.getContext(), HotelDetalheActivity.class);
                            intent.putExtra("produto", produto);
                            v.getContext().startActivity(intent);

                        }

                    }
                }
        );

        Hotel produto = produtos.get(position);

        TextView nome_produto =  listViewHolder.nomeProduto;
        nome_produto.setText(String.valueOf(produto.getNome()));

        RatingBar estrelas_produto =  listViewHolder.estrelasProduto;
        estrelas_produto.setRating(produto.getEstrela());

        TextView preco_produto = listViewHolder.precoProduto;
        preco_produto.setText("R$" + String.valueOf(String.format("%.2f", produto.getPreco())));

        ImageView imagem = listViewHolder.imgProduto;
        //Resources res = context.getResources();
        imagem.setImageResource(produtos.get(position).getImg());
        //imagem.setImageResource(produtos.get(position).getImg());

    }



    public class ListViewHolder extends  RecyclerView.ViewHolder {

        public ImageView imgProduto;
        public TextView nomeProduto;
        public RatingBar estrelasProduto;
        public TextView precoProduto;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProduto = (ImageView) itemView.findViewById(R.id.img_hotel);
            nomeProduto = (TextView) itemView.findViewById(R.id.nome_hotel);
            estrelasProduto = (RatingBar) itemView.findViewById(R.id.estrela_hotel);
            precoProduto = (TextView) itemView.findViewById(R.id.preco_produto);
        }
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }


}
