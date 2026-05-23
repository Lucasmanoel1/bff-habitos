package com.lucasmanoel.bff_habitos.business;

import com.lucasmanoel.bff_habitos.business.in.UsuarioDTORequest;
import com.lucasmanoel.bff_habitos.business.in.UsuarioLoginRequest;
import com.lucasmanoel.bff_habitos.business.out.UsuarioDTOResponse;
import com.lucasmanoel.bff_habitos.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTOResponse cadastraUsuario(UsuarioDTORequest dto){
        return client.cadastraUsuario(dto);
    }

    public UsuarioDTOResponse alteraUsuario(String token, UsuarioDTORequest dto){
        return client.alteraUsuario(token, dto);
    }

    public  UsuarioDTOResponse buscaUsuarioPorEmail(String token, String email){
        return client.buscaUsuarioPorEmail(token, email);
    }

    public String login ( UsuarioLoginRequest dto){
        return client.login(dto);
    }

    public  void deletaUsuario( String token, String email){
        client.deletaUsuario(token, email);
    }
}
