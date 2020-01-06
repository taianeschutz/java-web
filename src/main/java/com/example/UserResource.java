package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

    @Autowired
    private final UserRepository repository;


    public UserResource(final UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/usuarios/", method = RequestMethod.GET)
    public Iterable<User> buscarUsuario(@RequestParam(required = false) final String nome) {
        return this.repository.findAll();
    }
   
    @RequestMapping(value = "/usuarios/", method = RequestMethod.POST)
    public User criarUsuario(@RequestBody final User user) {
        final String nome = user.getNome();
        final String email = user.getEmail();
        final String senha = user.getSenha();
        return this.repository.save(new User(nome, email, senha));
    }

    @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.PUT)
    public void alterarUsuario(@PathVariable Long id, @RequestBody User usuarioParam) {
        User usuario = this.repository.findById(id).get();
        usuario.setEmail(usuarioParam.getEmail());
        usuario.setEmail(usuarioParam.getNome());
        usuario.setEmail(usuarioParam.getSenha());
    }

    @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.DELETE)
    public void removerUsuario(@PathVariable Long id) {
        this.repository.deleteById(id);
    }

}
