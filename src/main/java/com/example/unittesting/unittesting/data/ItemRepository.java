package com.example.unittesting.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unittesting.unittesting.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
