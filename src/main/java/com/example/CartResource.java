package com.example;

import java.util.HashMap;
import java.util.Map;

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
    private CartRepository repository;

    @Autowired
    private ProductRepository products;

    @Autowired
    private UserRepository users;


    public CartResource(final CartRepository repository) {
        this.repository = repository;
    }
    @RequestMapping(value = "/carrinho/comprar/",  method=RequestMethod.POST)
    public Map<String,String> finalizarCarrinho() {
      this.repository.deleteAll();
      Map<String,String> res = new HashMap<>();
      res.put("Mensagem", "Compra finalizada");
      return res;
    }

    @RequestMapping(value = "/carrinho/", method = RequestMethod.GET)
    public Iterable<Cart> buscar(@RequestParam(required = false) final String produtos) {
        return this.repository.findAll();
    }

   
    @RequestMapping(value = "/carrinho/", method = RequestMethod.POST)
    public Cart criar(@RequestBody Cart cart) {
        Product product = this.products.findById(cart.getProduct().getId()).get();
        double preco = product.getValor();
        int quantidade = product.getQuantidade();
        User user = this.users.findById(cart.getUser().getId()).get();
        return this.repository.save(new Cart(preco, quantidade, product, user));
    }

    @RequestMapping(value = "/carrinho/{id}", method = RequestMethod.PUT)
    public void alterar(@PathVariable Long id, @RequestBody Cart produtoParam) {
        Cart carrinho = this.repository.findById(id).get();
        carrinho.setProduct(this.products.findById(produtoParam.getProduct().getId()).get());
        carrinho.setUser(this.users.findById(produtoParam.getUser().getId()).get());
        this.repository.save(carrinho);
    }

    @RequestMapping(value = "/carrinho/", method = RequestMethod.DELETE)
    public void remover(@PathVariable Long id) {
        this.repository.deleteById(id);
    }

}