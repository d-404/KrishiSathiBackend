package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.OrdersHistory;

public interface OrdersHistoryRepository extends JpaRepository<OrdersHistory, Integer> {

	//get orders by user id
	@Query("from OrdersHistory o where o.userId = :userId")
	List<OrdersHistory> getOrdersById(@Param("userId") int userId);
}
