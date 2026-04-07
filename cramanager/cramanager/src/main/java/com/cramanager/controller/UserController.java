package com.cramanager.controller;

import com.cramanager.dto.User.UpdateRequest;
import com.cramanager.dto.User.UserResponseRequest;
import com.cramanager.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Utilisateurs", description = "Gestion des collaborateurs — admin seulement")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Lister tous les collaborateurs")
    @GetMapping
    public ResponseEntity<List<UserResponseRequest>> listUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Operation(summary = "Récupérer un collaborateur par son id")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseRequest> UserInfo(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Operation(summary = "Modifier un collaborateur, lemail non modifiable")
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseRequest> majuser(@PathVariable Long id, @RequestBody UpdateRequest request) {
        return ResponseEntity.ok(userService.updateUser(id, request));
    }

    @Operation(summary = "Activer ou désactiver un compte collaborateur")
    @PatchMapping("/{id}/toggle")
    public ResponseEntity<Void> activation(@PathVariable Long id) {
        userService.toggleActive(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Activer un compte via token email")
    @GetMapping("/activate")
    public ResponseEntity<Void> activeviatoken(@RequestParam String token) {
        userService.activateAccount(token);
        return ResponseEntity.noContent().build();
    }
}