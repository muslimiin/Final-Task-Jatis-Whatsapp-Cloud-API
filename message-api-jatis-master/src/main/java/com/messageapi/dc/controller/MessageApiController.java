package com.messageapi.dc.controller;


import com.messageapi.dc.dto.payload.PayloadDTO;
import com.messageapi.dc.service.MessageService;
import org.apache.tomcat.util.http.parser.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/message")
public class MessageApiController {
    Logger logger = LoggerFactory.getLogger(MessageApiController.class);

    @Autowired
    private MessageService messageService;

    @PostMapping(value = "")
    public ResponseEntity<Object> addMessage(@RequestHeader(value = "Authorization",required = false) String author,
                                             @RequestBody PayloadDTO request){
        logger.info("[Message] Controller Message Api Has Hit ");
        return messageService.addMessage(author,request);
    }
}
