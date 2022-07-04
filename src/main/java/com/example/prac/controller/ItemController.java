package com.example.prac.controller;

import com.example.prac.entity.Item;
import com.example.prac.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemService is;

    @PostMapping(value="/createitem")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Item> addItem(@RequestBody Item item){
        Item itm = is.addItem(item);
        return ResponseEntity.created(URI.create(String.format("/createitem",itm.getId()))).body(itm);
    }

    @GetMapping(value="/getAllItems")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Item>> getItems(@RequestParam int pageNumber, @RequestParam int pageSize){
        Sort st = Sort.by(Sort.Direction.ASC,"name");
        List<Item> itmlst = is.getItem(pageNumber, pageSize,st);
        return ResponseEntity.ok(itmlst);
    }

}

