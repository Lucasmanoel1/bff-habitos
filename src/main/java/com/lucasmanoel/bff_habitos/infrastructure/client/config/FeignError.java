package com.lucasmanoel.bff_habitos.infrastructure.client.config;

import com.lucasmanoel.bffagendador.infrastructure.exceptions.*;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FeignError implements ErrorDecoder {


    @Override
    public Exception decode(String s, Response response) {
        String erro = "Erro: ";
        String mensagemErro = mensagemErro(response);

        switch (response.status()){
            case 409:
                return new ConflictExeception(erro+ mensagemErro);

            case 403:
                return new ResourceNotFoundException(erro + mensagemErro);

            case 401:
                return new UnauthorizedException(erro + mensagemErro);

            case 400:
                return new IllegalArgumentException(erro + mensagemErro);

            default:
                return new BusinessException(erro + mensagemErro);
        }
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
