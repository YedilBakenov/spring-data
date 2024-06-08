package com.example.springDataG124.repository2;

import com.example.springDataG124.model2.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CarRepository2 extends JpaRepository<Car, Integer> {
}
