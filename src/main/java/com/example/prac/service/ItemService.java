package com.example.prac.service;

import com.example.prac.entity.Item;
import com.example.prac.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRepository ir;

    public Item addItem(Item item){
        Item itm = ir.save(item);
        return itm;
    }

    public List<Item> getItem(int pageNumber, int pageSize, Sort sort){
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        List<Item> itm = ir.findAll(pageable).getContent();
        return itm;
    }
//
//    public List<Item> getAll() {
//        return  ir.findAll();
//    }
}
