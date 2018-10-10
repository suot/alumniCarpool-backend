package com.uwindsor.alumniCarpool.service.Impl;

import com.uwindsor.alumniCarpool.model.Car;
import com.uwindsor.alumniCarpool.model.Order;
import com.uwindsor.alumniCarpool.service.IOrderService;

import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements IOrderService {
    @Override
    public List<Order> getOrderByInput(String departureCity, String arrivalCity, Date departureDate){

        return null;
    }
    public List<Order> getOrderById(String id){

        return null;
    }
    public Car getCarByOrderId(String id){

        return null;
    }
}
