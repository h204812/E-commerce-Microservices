package com.example.orderService.Repository;

import com.example.orderService.model.order;
import io.micrometer.observation.annotation.Observed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Observed
@Repository
public interface orderRepo extends JpaRepository<order,Long> {
}
