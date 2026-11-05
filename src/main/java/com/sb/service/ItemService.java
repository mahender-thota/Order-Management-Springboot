package com.sb.service;

import com.sb.dto.ItemRequestDTO;
import com.sb.dto.ItemResponseDTO;
import com.sb.dto.UpadateItemRequestDTO;

import java.util.List;

public interface ItemService {

    public ItemResponseDTO saveItem(ItemRequestDTO item);

    public ItemResponseDTO getById(long id);

    public List<ItemResponseDTO> getAllItemId();

    public ItemResponseDTO updateItem(long id, UpadateItemRequestDTO requestDTO);

    public void deleteItem(long id);

    public List<ItemResponseDTO> findByName(String name);

    public List<ItemResponseDTO> findByNameContaining(String name);

    public List<ItemResponseDTO> getItemsByRating(double rating);

    public List<ItemResponseDTO> getItemsByPriceBetween(double minPrice, double maxPrice);
}
