package com.lucasmanoel.bff_habitos.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "usuario", url = "${usuario.url}")
public class UsuarioClient {

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastraUsuario(@RequestBody UsuarioDTO dto);
}
