package com.order.management.system.ordermanagementsystem.controller;

import com.order.management.system.ordermanagementsystem.dto.OrderRequest;
import com.order.management.system.ordermanagementsystem.dto.OrderResponse;
import com.order.management.system.ordermanagementsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/v1")
public class OderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/order")
    public ResponseEntity<?> saveOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse orderResponse = this.orderService.saveOder(orderRequest);
        return ResponseEntity.ok(orderResponse);
    }

//    @GetMapping("/order")
//    public ResponseEntity<?> fetchPlacedOrder(@RequestParam(ORDER_PLACED )String ORDER_PLACED ) {
//        List<Order> allOrderList = this.orderService.fetchPlacedOrder();
//        return ResponseEntity.ok(allOrderList);
//    }
//}

    @GetMapping("/order")
    public ResponseEntity<?> fetchPlacedOrder(@RequestParam String status ) {
        OrderResponse orderResponse = this.orderService.fetchPlacedOrder(status);
        return ResponseEntity.ok(orderResponse);
    }

    @PostMapping("/order/update")
    public ResponseEntity<?> updateOrderStatus(@RequestBody List<OrderRequest> orderRequests){
        OrderResponse orderResponse = this.orderService.updateOrder(orderRequests);
        return ResponseEntity.ok(orderResponse);
    }
}
