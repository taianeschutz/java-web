package com.example;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_product", nullable = false)        
    private Product produto;

    private double precoUnitario;
    private int quantidade;
    private double precoTotal;


    protected Cart() {}

    public Cart(final double precoUnitario, final int quantidade) {
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.precoTotal = precoUnitario * quantidade;
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

	public Product getProduto() {
		return null;
	}
}
