package com.neog.helloproject.controller;

import com.neog.helloproject.dto.ResponseDTO;
import jakarta.servlet.http.HttpServletRequest;

public class MasterController {

    public ResponseDTO generateResponse(HttpServletRequest request, String data){
        ResponseDTO response = new ResponseDTO();
        response.setPath(request.getRequestURI());
        response.setDetails(data);
        response.setStatus(200);
        return response;
    }
}
