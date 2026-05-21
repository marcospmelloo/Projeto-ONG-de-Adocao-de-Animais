package org.serratec.ong_adocao.exception;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroResposta> tratarNotFound(ResourceNotFoundException ex) {
        ErroResposta erro = new ErroResposta(404, ex.getMessage());
        return ResponseEntity.status(404).body(erro);
    }

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<ErroResposta> tratarNotFound(DuplicateEntryException ex) {
        ErroResposta erro = new ErroResposta(409, ex.getMessage());
        return ResponseEntity.status(409).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResposta> tratarValidation(MethodArgumentNotValidException ex) {
        String mensagem = ex.getBindingResult().getFieldError().getDefaultMessage();

        ErroResposta erro = new ErroResposta(400, mensagem);
        return ResponseEntity.status(400).body(erro);
    }
}
