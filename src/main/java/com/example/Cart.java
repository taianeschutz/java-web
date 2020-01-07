package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @OneToOne(optional = false)
    private Product product;
    @OneToOne(optional = false)
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

    @Override
    public String toString() {
      return String.format(
          "[id=%d, customer='%s', product='%s']",
          id,precoUnitario, quantidade, user, product);
    }

    public Long getId() {
        return id;
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

	public void setProduct(Product product) {
        this.product = product;
    }

	public void setUser(User user) {
        this.user = user;
	}

}
