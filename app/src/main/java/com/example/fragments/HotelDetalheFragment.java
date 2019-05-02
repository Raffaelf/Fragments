package com.example.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class HotelDetalheFragment extends Fragment {

    public static final String TAG_DETALHE = "tagDetalhe";
    private TextView txtNome;
    private TextView txtEndereco;
    private RatingBar ratingBar;
    private Hotel produto;
    private ImageView img_produto;


    //Recebe um produto e cria a
    //instância do fragment.
    public static HotelDetalheFragment instanciaFragment(Hotel produto) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("produto", produto);
        HotelDetalheFragment fragment = new HotelDetalheFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        produto = (Hotel) getArguments().getSerializable("produto");
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.hotel_detalhe_fragment, container, false);
        img_produto = layout.findViewById(R.id.img_hotel_fragment);
        txtNome = layout.findViewById(R.id.txt_nome);
        txtEndereco = layout.findViewById(R.id.txt_preco);
        ratingBar = layout.findViewById(R.id.rtbar);
        if (produto != null) {
            img_produto.setImageResource(produto.getImg());
            txtNome.setText(produto.getNome());
            txtEndereco.setText("R$ " + String.valueOf(String.format("%.2f", produto.getPreco())));
            ratingBar.setRating(produto.getEstrela());
        }
        return layout;
    }
}