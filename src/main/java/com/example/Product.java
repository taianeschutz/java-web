package com.example;

public class Product {
    private double valor;
    private int quantidade;
    public Product() {
        this.valor = 0.00;
        this.quantidade = 0;
    }
    public double getValor() {
        return this.valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public double getQuantidade() {
        return this.quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}