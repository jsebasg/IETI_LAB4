package edu.eci.ieti.lab2.exception;

import edu.eci.ieti.lab2.data.ErrorCodeEnum;
import edu.eci.ieti.lab2.data.User;
import edu.eci.ieti.lab2.dto.ServerErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.ws.rs.core.Response;

import javax.ws.rs.InternalServerErrorException;

public class InvalidCredentialsException extends InternalServerErrorException
{
    public InvalidCredentialsException() {
        super(new ServerErrorResponseDto("User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND).getMessage());
    }
}
