package com.rushi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.rushi.entity.OrderItem;

@RepositoryRestResource
@CrossOrigin("http://localhost:4200")
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	
}
