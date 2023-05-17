package com.example.Restaurantmanagementapi.controller;

import com.example.Restaurantmanagementapi.model.Orders;
import com.example.Restaurantmanagementapi.model.User;
import com.example.Restaurantmanagementapi.service.OrderService;
import com.example.Restaurantmanagementapi.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    TokenService tokenService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@Valid @RequestParam String email,@RequestParam String token, @RequestBody Orders order) {

        HttpStatus status;
        String msg = "";
        if (tokenService.authenticate(email, token)) {

            User user =  tokenService.findUserByToken(token);
            order.setUser(user);
            Orders createdOrder = orderService.createOrder(order);
            msg = " order created successfully";
            status = HttpStatus.OK;
        }
        else
        {
            msg = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(msg , status);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long orderId) {
        Optional<Orders> order = Optional.ofNullable(orderService.getOrderById(orderId));
        return order.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable Long id,@RequestBody Orders order) {
        Orders updatedOrder = orderService.updateOrder(id,order);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok().build();
    }

}
