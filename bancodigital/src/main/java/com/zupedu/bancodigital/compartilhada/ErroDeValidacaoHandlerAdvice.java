package com.zupedu.bancodigital.compartilhada;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class ErroDeValidacaoHandlerAdvice {
    private final MessageSource messageSource;

    public ErroDeValidacaoHandlerAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MensagemDeErroResponse trataValidacoes(MethodArgumentNotValidException exception ) {
        List<FieldError> camposComErros = exception.getBindingResult().getFieldErrors();
        MensagemDeErroResponse mensagemDeErro = new MensagemDeErroResponse(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(), "Um ou mais campos estão com problemas");

        camposComErros.forEach(campoComErro -> {
            String mensagem = messageSource.getMessage(campoComErro, LocaleContextHolder.getLocale());
            mensagemDeErro.adiciona(new CampoComErro(campoComErro.getField(),mensagem));
        });

        return mensagemDeErro;
    }
}
