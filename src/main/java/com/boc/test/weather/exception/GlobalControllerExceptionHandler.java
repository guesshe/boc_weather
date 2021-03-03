package com.boc.test.weather.exception;

import com.boc.test.weather.config.ApiError;
import com.boc.test.weather.utils.IResponseEntityGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice("com.boc.test.weather.controller")
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler
        implements IResponseEntityGenerator {

    private static final Logger logger =
            LoggerFactory.getLogger(GlobalControllerExceptionHandler.class.getCanonicalName());
    private static final String LOGGER_TAG = "[GlobalControllerExceptionHandler]";

    // HttpCode 400
    @ExceptionHandler({
            NumberFormatException.class,
            ClassCastException.class,
            GeneralNotAcceptableException.class,
            org.hibernate.exception.ConstraintViolationException.class,
            java.lang.IllegalArgumentException.class
    })
    public ResponseEntity<Object> handleConversionException(final Exception ex) {
        logger.error(LOGGER_TAG + ex.getMessage());
        return generateResponseEntity(
                new ApiError(ex.getMessage(), "BAD_REQUEST"), HttpStatus.BAD_REQUEST);
    }

    // HttpCode 400
    @ExceptionHandler({InvalidDataAccessApiUsageException.class})
    public ResponseEntity<Object> handInvalidDataAccessApiUsageException(
            final InvalidDataAccessApiUsageException ex) {
        logger.error(LOGGER_TAG + ex.getMessage());
        final String errorMessage = ex.getCause().getCause().getMessage().split("of")[0];
        return generateResponseEntity(
                new ApiError(errorMessage, "BAD_REQUEST"), HttpStatus.BAD_REQUEST);
    }

    // HttpCode 400
    @Override()
    public ResponseEntity<Object> handleBindException(
            BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.error(LOGGER_TAG + ex.getMessage());
        final String errorMessage =
                ex.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .collect(Collectors.toList())
                        .toString();
        return generateResponseEntity(
                new ApiError(errorMessage, "BAD_REQUEST"), HttpStatus.BAD_REQUEST);
    }

    // HttpCode 403 not needed coz security features are disabled for now
    @ExceptionHandler({org.springframework.security.access.AccessDeniedException.class})
    public ResponseEntity<Object> handleAccessDeniedException(final AccessDeniedException ex) {
        logger.error(LOGGER_TAG + ex.getMessage());
        return generateResponseEntity(
                new ApiError(ex.getMessage(), "Access_Denied"), HttpStatus.FORBIDDEN);
    }

    // HttpCode 404
    @ExceptionHandler({RecordNotFoundException.class, EmptyResultDataAccessException.class})
    public ResponseEntity<Object> handleInvalidHttpResponse(final Exception ex) {
        logger.error(LOGGER_TAG + ex.getMessage());
        return generateResponseEntity(
                new ApiError(ex.getMessage(), "NOT_FOUND"), HttpStatus.NOT_FOUND);
    }

    // default exception handler, no annotations
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> defaultExceptionHandler(final Exception ex) throws Exception {
        logger.error(LOGGER_TAG + ex.getMessage());
        if (AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null) {
            throw ex;
        }
        return generateResponseEntity(
                new ApiError(ex.getMessage(), "UNKNOWN_SERVER_ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // HttpCode 400
    @Override()
    public ResponseEntity<Object> handleServletRequestBindingException(
            final ServletRequestBindingException ex,
            final HttpHeaders headers,
            final HttpStatus status,
            final WebRequest request) {
        logger.error(LOGGER_TAG + ex.getMessage());
        return generateResponseEntity(
                new ApiError(ex.getMessage(), "BAD_REQUEST"), HttpStatus.BAD_REQUEST);
    }

    // HttpCode 400
    @Override()
    public ResponseEntity<Object> handleHttpMessageNotReadable(
            final HttpMessageNotReadableException ex,
            final HttpHeaders headers,
            final HttpStatus status,
            final WebRequest request) {
        logger.error(LOGGER_TAG + ex.getMessage());
        return generateResponseEntity(
                new ApiError(ex.getMessage(), "BAD_REQUEST"), HttpStatus.BAD_REQUEST);
    }

    // HttpCode 404
    @Override()
    public ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return generateResponseEntity(
                new ApiError(ex.getMessage(), "NOT_FOUND"), HttpStatus.NOT_FOUND);
    }

    // HttpCode 406
    @Override()
    public ResponseEntity<Object> handleHttpMediaTypeNotSupported(
            final HttpMediaTypeNotSupportedException ex,
            final HttpHeaders headers,
            final HttpStatus status,
            final WebRequest request) {
        logger.error(LOGGER_TAG + ex.getMessage());
        return generateResponseEntity(
                new ApiError(ex.getMessage(), "NOT_ACCEPTABLE"), HttpStatus.NOT_ACCEPTABLE);
    }
}

