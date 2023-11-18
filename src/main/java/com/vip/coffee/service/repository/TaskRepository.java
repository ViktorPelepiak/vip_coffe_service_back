package com.vip.coffee.service.repository;

import com.vip.coffee.service.model.CoffeeMachine;
import com.vip.coffee.service.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByCoffeeMachine(CoffeeMachine coffeeMachine);
}
