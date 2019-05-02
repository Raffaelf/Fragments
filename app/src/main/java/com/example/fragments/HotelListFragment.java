package com.example.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HotelListFragment extends Fragment {
    private List<Hotel> produtos;
    private ArrayAdapter<Hotel> adapter;
    View view;

    private RecyclerView myrecyclerview;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    private List<Hotel> carregarHoteis() {
        List<Hotel> produtos = new ArrayList<>();
        produtos.add(new Hotel("Jaqueta Palace Refletiva", 179.90,4.5f, R.drawable.produto1));
        produtos.add(new Hotel("Tênis EST Slim", 159.90,4.0f, R.drawable.produto2));
        produtos.add(new Hotel("Calça Camuflada Feminina Laranja", 139.90,5.0f, R.drawable.produto3));
        produtos.add(new Hotel("Jaqueta Camuflada Street Line", 179.90,4.7f, R.drawable.produto4));
        produtos.add(new Hotel("Tênis Camuflado Masculino", 189.90,3.9f, R.drawable.produto5));

        return produtos;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.hoteis_view_list,container,false);

        produtos = carregarHoteis();

        myrecyclerview = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        HotelAdapter produtoListAdapter = new HotelAdapter(produtos,getContext());
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        //myrecyclerview.setLayoutManager(new GridLayoutManager(getActivity(),2));

        myrecyclerview.setAdapter(produtoListAdapter);



        return view;
    }


    public interface AoClicarNoProduto {
        void clicouNoProduto(Hotel produto);
    }

}
