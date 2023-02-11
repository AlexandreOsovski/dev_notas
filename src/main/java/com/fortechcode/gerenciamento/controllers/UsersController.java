package com.fortechcode.gerenciamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fortechcode.gerenciamento.entities.Users;
import com.fortechcode.gerenciamento.repository.UsersRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UsersRepository repository;

    @GetMapping
    public List<Users> findAll() {
        List<Users> resultado = repository.findAll();
        return resultado;

    }

    // Pega pelo id específico
    @GetMapping("/users/{id}")
    public Users findById(@PathVariable Long id) {
        Users resultado = repository.findById(id).get();
        return resultado;

    }

    // salva um usuário
    @PostMapping
    public Users InsertUser(@RequestBody Users users) {
        Users resultado = repository.save(users);

        return resultado;

    }

    // atualiza as informações de um usuário
    @PutMapping("/{id}")
    public Users UpdateUser(@PathVariable("id") Long id, @RequestBody Users users) {
        Users user = repository.findById(id)
                .orElseThrow(() -> new User("User not found with id " + id));

        user.setName(users.getName());
        user.setEmail(users.getEmail());
        user.setPassword(users.getPassword());

        Users resultado = repository.save(user);

        return resultado;
    }

}
