package com.example;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CartBuy {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)        
    private User usuario;

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

    public void setPrecoUnitario(final double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public void setQuantidade(final int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPrecoTotal(final double precoTotal) {
        this.precoTotal = precoTotal;
    }

	public Product getProduto() {
		return null;
	}
}