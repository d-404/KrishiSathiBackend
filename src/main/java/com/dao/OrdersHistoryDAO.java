package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.OrdersHistory;


@Service
public class OrdersHistoryDAO {
	
	@Autowired
	OrdersHistoryRepository ordersHistoryRepository;
	
	public List<OrdersHistory> getAllOrders(){
		List<OrdersHistory> ordersList = ordersHistoryRepository.findAll();
		return ordersList;
	}

	public OrdersHistory add(OrdersHistory order) {
		return ordersHistoryRepository.save(order);
	}
	
	public List<OrdersHistory> getOrdersById(int userId){
		List<OrdersHistory> ordersList = ordersHistoryRepository.getOrdersById(userId);
		return ordersList;
	}

}
