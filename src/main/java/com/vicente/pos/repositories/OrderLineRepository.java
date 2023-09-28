package com.vicente.pos.repositories;

import com.vicente.pos.models.OrderLineModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLineModel,Integer> {

}
