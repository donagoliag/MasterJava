package com.cramanager.controller;

import com.cramanager.dto.USER.UpdateRequest;
import com.cramanager.dto.USER.UserResponseRequest;
import com.cramanager.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //Lister tous les users
    @GetMapping
    public ResponseEntity<List<UserResponseRequest>> listUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    //Retrouver un user avec son id
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseRequest> UserInfo(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    //modifier un user
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseRequest> majuser (@PathVariable Long id, @RequestBody UpdateRequest request){
        return ResponseEntity.ok(userService.updateUser(id,request));
    }

    //Activer/Desactiver un user
    @PatchMapping("/{id}/toggle")
    public ResponseEntity<Void> activation(@PathVariable Long id){
        userService.toggleActive(id);
        return ResponseEntity.noContent().build();
    }

    //Activer le compte via token
    @GetMapping("/activate")
    public ResponseEntity<Void> activeviatoken (@RequestParam String token){
        userService.activateAccount(token);
        return ResponseEntity.noContent().build();
    }

}
