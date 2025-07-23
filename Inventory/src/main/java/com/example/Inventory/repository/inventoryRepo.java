package com.example.Inventory.repository;

import com.example.Inventory.models.inventory;
import io.micrometer.observation.annotation.Observed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Observed
public interface inventoryRepo extends JpaRepository<inventory, Long> {
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);
}
