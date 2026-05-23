package com.lucasmanoel.bff_habitos.infrastructure.client.config;


import com.lucasmanoel.bff_habitos.infrastructure.exceptions.BusinessException;
import com.lucasmanoel.bff_habitos.infrastructure.exceptions.ConflictException;
import com.lucasmanoel.bff_habitos.infrastructure.exceptions.ResourceNotFoundException;
import com.lucasmanoel.bff_habitos.infrastructure.exceptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FeignError implements ErrorDecoder {


    @Override
    public Exception decode(String s, Response response) {
        String mensagem = mensagemErro(response);
        return switch (response.status()) {
            case 400 -> new BusinessException(mensagem);
            case 401 -> new UnauthorizedException(mensagem);
            case 403 -> new UnauthorizedException(mensagem);
            case 404 -> new ResourceNotFoundException(mensagem);
            case 409 -> new ConflictException(mensagem);
            default  -> new BusinessException(mensagem);
        };
    }

    public String mensagemErro(Response response){
        try {
            if (Objects.isNull(response.body())){
                return "";
            }
            return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
