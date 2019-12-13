package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ProductResource {
  private List<Product> produtos;
  /*
   * Construtor do ProductResource, preparando uma lista de produtos
   */
  public ProductResource() {
    this.produtos = new ArrayList<>();
    this.produtos.add(new Product("cao", 50.00, 5));
    this.produtos.add(new Product("gato", 30.00, 7));
  }

  /**
   * Metodo de requisicao do tipo GET, para uma lista
   * @param raca tipo de raca para filtrar
   * @return lista de produtos, filtrados ou nao
   */
  @RequestMapping(value = "/produtos/", method = RequestMethod.GET)
  public List<Product> buscarProdutos(@RequestParam(required = false) String raca) {
    if(raca == null) {
      return this.produtos;
    } else {
      List<Product> prod = new ArrayList<>();
      for(Product p: this.produtos) {
        if(raca.equals(p.getRaca())) prod.add(p);
      }
      return prod;
    }
  }

  /**
   * Metodo de requisicao do tipo GET, para um item
   * @param id identificador ou indice da colecao dos produtos
   * @return item de produto unico
   */
  @RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
  public Product buscarProduto(@PathVariable Integer id) {
    return this.produtos.get(id - 1);
  }

  @RequestMapping(value = "/produtos/{id}", 
  method = RequestMethod.DELETE)
  public void removerProduto(@PathVariable Integer id) {
    this.produtos.remove(id - 1);
  }
  
  /**
   * Metodo de requisicao do tipo DELETE, para remover um item
   * @param id identificador ou indice da colecao dos produtos
   */
  @RequestMapping(value = "/produtos/{id}", method = RequestMethod.DELETE)
  public void removerProduto(@PathVariable Integer id) {
    this.produtos.remove(id - 1);
  }

  @RequestMapping(value = "/produtos/", 
  method = RequestMethod.POST)
  public Product criarProduto(@RequestBody Product product) {
    String raca = product.getRaca();
    double valor = product.getValor();
    int quantidade = product.getQuantidade();
    return new Product(raca, valor, quantidade);
  }

  @RequestMapping(value="/produtos/{id}", 
  method=RequestMethod.PUT)
  public void requestMethodName(@PathVariable Integer id,
  @RequestBody Product produtoParam) {
      Product produto = this.produtos.get(id - 1);
      produto.setQuantidade(produtoParam.getQuantidade());
      produto.setValor(produtoParam.getValor());
      produto.setRaca(produtoParam.getRaca());
  }

}
