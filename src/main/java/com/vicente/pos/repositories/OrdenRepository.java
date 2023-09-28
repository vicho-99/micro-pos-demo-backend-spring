package com.vicente.pos.repositories;

import com.vicente.pos.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends JpaRepository<OrderModel,Integer> {

}
