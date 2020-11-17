package com.tinnova.tinnovaproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Fornecedor Incorreto")
public class FornecedorNotFoundException extends RuntimeException{
}
