package com.sb.dao_repo;

import com.sb.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    public List<Item> findByItemNameStartingWith(String itemName);

    public List<Item> findByItemNameContaining(String itemName);

    public List<Item> findByRatingGreaterThan(double rating);

    public List<Item> findByPriceBetween(double minPrice, double maxPrice);
}
