package com.ks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.OrdersHistoryDAO;
import com.model.OrdersHistory;
import com.model.User;

@RestController
public class OrderHistoryController {
	
	
	@Autowired
	OrdersHistoryDAO ordersHistoryDAO;
	
	@GetMapping("/getAllOrders")
	public List<OrdersHistory> getAllOrders(){
		return ordersHistoryDAO.getAllOrders();
	}
	
	@GetMapping("/getAllOrdersHistory")
	public List<OrdersHistory> getAllOrdersHistory(){
		return ordersHistoryDAO.getAllOrders();
	}
	
	@PostMapping("/registerOrder")
	public OrdersHistory registerOrder(@RequestBody OrdersHistory order){
		return ordersHistoryDAO.add(order);
	}
	
	
	@GetMapping("/getOrdersById/{userId}")
	public List<OrdersHistory> getOrdersById(@PathVariable("userId") int userId){
		return ordersHistoryDAO.getOrdersById(userId);
	}
}
