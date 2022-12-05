package com.messageapi.dc.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public class ResponseUtil {

    ResponseUtil(){
    }

    public static ResponseEntity<Object> build(String message_id, Object contact,Object messages ,HttpStatus httpStatus){
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("messaging_product",message_id);
        hashMap.put("contacts",contact);
        hashMap.put("messages",messages);

        return new ResponseEntity<>(hashMap,httpStatus);

    }
}
