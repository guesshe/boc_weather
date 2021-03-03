package com.boc.test.weather.utils;

import com.boc.test.weather.dto.ResultBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service()
public interface IResponseEntityGenerator {

    default ResponseEntity<Object> generateResponseEntity(
            final Object object, final HttpStatus httpStatus) {
        return new ResponseEntity<>(object, new HttpHeaders(), httpStatus);
    }

    /**
     * This method processes resultBean based on httpCode
     *
     * @param resultBean
     * @return ResponseEntity<Object>
     * @throws Exception
     */
    default ResponseEntity<Object> processResultBean(ResultBean resultBean) {
        HttpStatus httpStatus = HttpStatus.valueOf(resultBean.getResponseCode());
        switch(httpStatus){
            case NOT_FOUND: return generateResponseEntity(resultBean.getBody(), HttpStatus.NOT_FOUND);
            default: return generateResponseEntity(resultBean.getBody(), HttpStatus.OK);
        }
    }

    default void setResponseContent(final HttpServletResponse response, final Object object)
            throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object));
    }
}

