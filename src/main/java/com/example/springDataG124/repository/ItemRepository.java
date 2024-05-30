package com.example.springDataG124.repository;

import com.example.springDataG124.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query("SELECT it FROM Item it " +
            "WHERE it.name ilike concat('%', :search, '%') " +
            "OR it.description ilike concat('%', :search, '%')")
    List<Item>getAllItemsByFilter(String search);

    Item findByName(String name);
}
