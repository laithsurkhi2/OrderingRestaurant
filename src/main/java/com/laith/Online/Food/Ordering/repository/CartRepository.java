package com.laith.Online.Food.Ordering.repository;

import com.laith.Online.Food.Ordering.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
