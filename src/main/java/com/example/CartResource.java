package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartResource {

    @Autowired
    private final CartRepository repository;


    public CartResource(final CartRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/carrinho/", method = RequestMethod.GET)
    public Iterable<Cart> buscar(@RequestParam(required = false) final String produtos) {
        return this.repository.findAll();
    }

   
    @RequestMapping(value = "/carrinho/", method = RequestMethod.POST)
    public Cart criar(@RequestBody final Cart cart) {
        final double precoUnitario = cart.getPrecoUnitario();
        final int quantidade = quantidade.getQuantidade();
        final double precoTotal = precoTotal.getPrecoTotal();
        final Product produto = cart.getProduto();

        return this.repository.save(new Cart());
    }

/*
    @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.PUT)
    public void alterar(@PathVariable Long id, @RequestBody User usuarioParam) {
        User usuario = this.repository.findById(id).get();
    }

    @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.DELETE)
    public void remover(@PathVariable Long id) {
        this.repository.deleteById(id);
    }
*/
}