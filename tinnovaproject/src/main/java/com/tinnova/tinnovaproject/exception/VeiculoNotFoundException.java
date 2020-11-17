package com.tinnova.tinnovaproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Veiculo not found")
public class VeiculoNotFoundException extends RuntimeException{
}
