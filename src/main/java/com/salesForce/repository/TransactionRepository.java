package com.salesForce.repository;

import com.salesForce.entity.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<MovimientoDinero,Long> {

}
