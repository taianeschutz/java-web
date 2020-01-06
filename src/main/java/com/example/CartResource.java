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
    @RequestMapping(value = "/carrinho/comprar/", method = RequestMethod.POST)
    public String comprar(@RequestParam(required = false) final String produtos) {
        this.repository.deleteAll();
        return "Ok!";
    }

    @RequestMapping(value = "/carrinho/", method = RequestMethod.GET)
    public Iterable<Cart> buscar(@RequestParam(required = false) final String produtos) {
        return this.repository.findAll();
    }

   
    @RequestMapping(value = "/carrinho/", method = RequestMethod.POST)
    public Cart criar(@RequestBody final Cart cart) {
        double precoUnitario = cart.getPrecoUnitario();
        int quantidade = cart.getQuantidade();
        Product produto = cart.getProduct();
        User cliente = cart.getUser();
        return this.repository.save(new Cart(precoUnitario, quantidade, produto, cliente));
    }

    @RequestMapping(value = "/carrinho/", method = RequestMethod.PUT)
    public void alterar(@PathVariable Long id, @RequestBody Cart carrinhoParam) {
        Cart carrinho = this.repository.findById(id).get();
        carrinho.setPrecoUnitario(carrinhoParam.getPrecoUnitario());
        carrinho.setQuantidade(carrinhoParam.getQuantidade());
        this.repository.save(carrinho);
    }

    @RequestMapping(value = "/carrinho/", method = RequestMethod.DELETE)
    public void remover(@PathVariable Long id) {
        this.repository.deleteById(id);
    }

}