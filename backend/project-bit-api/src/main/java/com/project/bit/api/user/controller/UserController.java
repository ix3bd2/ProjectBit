package com.project.bit.api.user.controller;

import com.project.bit.api.user.model.UserModelAssembler;
import com.project.bit.api.user.repository.UserRepository;
import com.project.bit.api.user.exceptions.UserNotFoundException;
import com.project.bit.api.user.model.User;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {

    private final UserRepository repository;
    private final UserModelAssembler assembler;

    UserController(UserRepository repository, UserModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/users")
    public CollectionModel<EntityModel<User>> all() {
        List<EntityModel<User>> users = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(users, linkTo(methodOn(UserController.class).all()).withSelfRel());
    }

    @PostMapping("/users")
    public ResponseEntity<?> newUser(@RequestBody User newUser) {
        EntityModel<User> entityModel = assembler.toModel(repository.save(newUser));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> one(@PathVariable String id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return assembler.toModel(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> replaceUser(@RequestBody User newUser, @PathVariable String id) {

        User updatedUser = repository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    return repository.save(user);
                }) //
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });

        EntityModel<User> entityModel = assembler.toModel(updatedUser);

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
            repository.deleteById(id);

            return ResponseEntity.noContent().build();
    }
}
