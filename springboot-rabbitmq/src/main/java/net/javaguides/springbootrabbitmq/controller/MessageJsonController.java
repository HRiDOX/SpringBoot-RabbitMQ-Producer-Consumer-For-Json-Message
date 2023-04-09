package net.javaguides.springbootrabbitmq.controller;

import net.javaguides.springbootrabbitmq.dto.Order;
import net.javaguides.springbootrabbitmq.dto.User;
import net.javaguides.springbootrabbitmq.publisher.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

    private RabbitMQJsonProducer jsonProducer;


    public MessageJsonController(RabbitMQJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }
    @PostMapping("/order")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Order order){
        jsonProducer.sendJsonMessage(order);
        return ResponseEntity.ok("Json Message sent to RabbitMQ ...");
    }
}
