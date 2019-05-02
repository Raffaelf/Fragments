package com.example.fragments;

import android.widget.ImageView;

import java.io.Serializable;

public class Hotel implements Serializable {
    private String nome;
    private float estrela;
    private int img;
    private double preco;

    public Hotel(String nome, double preco, float estrela, int img) {
        this.nome = nome;
        this.preco = preco;
        this.estrela = estrela;
        this.img = img;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getEstrela() {
        return estrela;
    }

    public void setEstrela(float estrela) {
        this.estrela = estrela;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
