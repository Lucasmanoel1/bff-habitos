package com.lucasmanoel.bff_habitos.infrastructure.client;

import com.lucasmanoel.bff_habitos.business.in.UsuarioDTORequest;
import com.lucasmanoel.bff_habitos.business.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @PostMapping
    UsuarioDTOResponse cadastraUsuario(@RequestBody UsuarioDTORequest dto);

    @PutMapping
    UsuarioDTOResponse alteraUsuario(@RequestHeader("Authorization") String token, @RequestBody UsuarioDTORequest dto);

    @GetMapping
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestHeader("Authorization") String token, @RequestParam String email);

    @PostMapping("/login")
    String login (@RequestBody UsuarioDTORequest dto);

    @DeleteMapping("/{email}")
    void deletaUsuario(@RequestHeader("Authorization") String token, @PathVariable String email);


}
