package org.example.repositories;

import org.example.moduls.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    Coffee findByCoffeeName(String coffeeName);

}
