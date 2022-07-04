package com.example.prac.repository;

import com.example.prac.entity.Item;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item,Integer> {
}
