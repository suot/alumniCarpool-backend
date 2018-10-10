package com.uwindsor.alumniCarpool.service;

import com.uwindsor.alumniCarpool.model.Car;
import com.uwindsor.alumniCarpool.model.Order;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface IOrderService {
    public List<Order> getOrderByInput(String departureCity, String arrivalCity, Date departureDate);
    public List<Order> getOrderById(String id);
    public Car getCarByOrderId(String id);
}
