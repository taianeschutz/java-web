package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Product product;
    @ManyToOne
    private User user;

    private double precoUnitario;
    private int quantidade;
    private double precoTotal;


    protected Cart() {}

    public Cart(double precoUnitario, int quantidade, Product produto, User cliente) {
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.precoTotal = precoUnitario * quantidade;
        this.product = produto;
        this.user = cliente;
    }    

    public double getPrecoUnitario() {
        return this.precoUnitario;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public double getPrecoTotal() {
        return this.precoTotal;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

}
