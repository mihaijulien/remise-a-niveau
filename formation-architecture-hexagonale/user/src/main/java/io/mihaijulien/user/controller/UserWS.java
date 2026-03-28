package io.mihaijulien.user.controller;

import io.mihaijulien.user.domain.api.createuser.CreateUserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserWS {
    private final CreateUserUseCase createUserUseCase;

    public UserWS(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@RequestBody CreateUserHttpRequest request){
        createUserUseCase.create(request.firstName(), request.lastName());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
