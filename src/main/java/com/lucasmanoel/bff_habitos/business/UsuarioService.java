package com.lucasmanoel.bff_habitos.business;

import com.lucasmanoel.bff_habitos.business.in.UsuarioDTORequest;
import com.lucasmanoel.bff_habitos.business.out.UsuarioDTOResponse;
import com.lucasmanoel.bff_habitos.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTOResponse cadastraUsuario(@RequestBody UsuarioDTORequest dto){
        return client.cadastraUsuario(dto);
    }

    public UsuarioDTOResponse alteraUsuario(@RequestHeader("Authorization") String token, @RequestBody UsuarioDTORequest dto){
        return client.alteraUsuario(token, dto);
    }

    public  UsuarioDTOResponse buscaUsuarioPorEmail(@RequestHeader("Authorization") String token, @RequestParam String email){
        return client.buscaUsuarioPorEmail(token, email);
    }

    public String login (@RequestBody UsuarioDTORequest dto){
        return client.login(dto);
    }

    public  void deletaUsuario(@RequestHeader("Authorization") String token, @PathVariable String email){
        client.deletaUsuario(token, email);
    }
}
