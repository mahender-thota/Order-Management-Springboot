package com.sb.service.impl;

import com.sb.dao_repo.ItemRepository;
import com.sb.dto.ItemRequestDTO;
import com.sb.dto.ItemResponseDTO;
import com.sb.dto.UpadateItemRequestDTO;
import com.sb.model.Item;
import com.sb.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public ItemResponseDTO saveItem(ItemRequestDTO itemRequestDTO) {
        Item item = new Item();
        BeanUtils.copyProperties(itemRequestDTO, item);
        item.setRating(0);
        Item saveItem = itemRepository.save(item);
        ItemResponseDTO responseDTO = new ItemResponseDTO();
        BeanUtils.copyProperties(saveItem, responseDTO);
        responseDTO.setRating(item.getRating());
        return responseDTO;
    }

    @Override
    public ItemResponseDTO getById(long id) {
        Item item = itemRepository.findById(id).get();
        ItemResponseDTO responseDTO = new ItemResponseDTO();
        BeanUtils.copyProperties(item, responseDTO);
        return responseDTO;
    }

    @Override
    public List<ItemResponseDTO> getAllItemId() {
        List<Item> list = itemRepository.findAll();
        List<ItemResponseDTO> responseDTOList = new ArrayList<>();
        for (Item item : list) {
            ItemResponseDTO responseDTO = new ItemResponseDTO();
            BeanUtils.copyProperties(item, responseDTO);
            responseDTOList.add(responseDTO);
        }
        return responseDTOList;
    }

    @Override
    public List<ItemResponseDTO> findByName(String name) {
        List<Item> byItemNameStartingWith = itemRepository.findByItemNameStartingWith(name);
        List<ItemResponseDTO> responseDTOList = new ArrayList<>();
        for (Item item : byItemNameStartingWith) {
            ItemResponseDTO itemResponseDTO = new ItemResponseDTO();
            BeanUtils.copyProperties(item, itemResponseDTO);
            responseDTOList.add(itemResponseDTO);
        }
        return responseDTOList;
    }

    public List<ItemResponseDTO> findByNameContaining(String name) {
        List<Item> nameContaining = itemRepository.findByItemNameContaining(name);
        List<ItemResponseDTO> responseDTOList = new ArrayList<>();
        for (Item item : nameContaining) {
            ItemResponseDTO itemResponseDTO = new ItemResponseDTO();
            BeanUtils.copyProperties(item, itemResponseDTO);
            responseDTOList.add(itemResponseDTO);
        }
        return responseDTOList;
    }

    @Override
    public ItemResponseDTO updateItem(long id, UpadateItemRequestDTO requestDTO) {
        Item item = itemRepository.findById(id).get();
        BeanUtils.copyProperties(requestDTO, item);
        Item saveItem = itemRepository.save(item);
        ItemResponseDTO responseDTO = new ItemResponseDTO();
        BeanUtils.copyProperties(saveItem, responseDTO);
        return responseDTO;
    }

    @Override
    public void deleteItem(long id) {
        itemRepository.deleteById(id);
    }

    public List<ItemResponseDTO> getItemsByRating(double rating) {
        List<Item> byRatingGreaterThan = itemRepository.findByRatingGreaterThan(rating);
        List<ItemResponseDTO> responseDTOList = new ArrayList<>();
        for (Item item : byRatingGreaterThan) {
            ItemResponseDTO itemResponseDTO = new ItemResponseDTO();
            BeanUtils.copyProperties(item, itemResponseDTO);
            responseDTOList.add(itemResponseDTO);
        }
        return responseDTOList;
    }

    @Override
    public List<ItemResponseDTO> getItemsByPriceBetween(double minPrice, double maxPrice) {
        List<Item> items = itemRepository.findByPriceBetween(minPrice, maxPrice);
        List<ItemResponseDTO> responseDTOList = new ArrayList<>();
        for (Item item : items) {
            ItemResponseDTO dto = new ItemResponseDTO();
            BeanUtils.copyProperties(item, dto);
            responseDTOList.add(dto);
        }
        return responseDTOList;
    }

}
