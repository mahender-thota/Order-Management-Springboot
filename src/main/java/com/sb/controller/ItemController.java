package com.sb.controller;

import com.sb.dto.ItemRequestDTO;
import com.sb.dto.ItemResponseDTO;
import com.sb.dto.UpadateItemRequestDTO;
import com.sb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/add")
    public ItemResponseDTO addItem(@RequestBody ItemRequestDTO item) {
        return itemService.saveItem(item);
    }

    @GetMapping("/get/{id}")
    public ItemResponseDTO getByItemId(@PathVariable long id) {
        return itemService.getById(id);
    }

    @GetMapping
    public List<ItemResponseDTO> getAllItemId() {
        return itemService.getAllItemId();
    }

    @GetMapping("/name/{name}")
    public List<ItemResponseDTO> getNameStartWith(@PathVariable String name) {
        return itemService.findByName(name);
    }

    @GetMapping("/contains/{name}")
    public List<ItemResponseDTO> getItemsContainingName(@PathVariable String name) {
        return itemService.findByNameContaining(name);
    }

    @PutMapping("/update/{id}")
    public ItemResponseDTO updateItem(@PathVariable long id, @RequestBody UpadateItemRequestDTO upadateItemRequestDTO) {
        return itemService.updateItem(id, upadateItemRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteItem(@PathVariable long id) {
        itemService.deleteItem(id);
    }

    @GetMapping("/rating/{rating}")
    public List<ItemResponseDTO> getByRating(@PathVariable double rating){
        return itemService.getItemsByRating(rating);
    }
    @GetMapping("/between/price")
    public List<ItemResponseDTO> getItemsByPriceBetween(
            @RequestParam double minPrice,
            @RequestParam double maxPrice) {

        return itemService.getItemsByPriceBetween(minPrice, maxPrice);
    }
}
