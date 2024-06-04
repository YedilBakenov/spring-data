package com.example.springDataG124.repository;

import com.example.springDataG124.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface StoreRepository extends JpaRepository<Store, Integer> {
}
