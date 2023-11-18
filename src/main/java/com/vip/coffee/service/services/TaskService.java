package com.vip.coffee.service.services;

import com.vip.coffee.service.dto.TaskEditDto;
import com.vip.coffee.service.dto.TaskSaveDto;
import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasksForMachineWithId(Long machineId) throws ElementNotFoundException;

    Task findById(Long taskId) throws ElementNotFoundException;

    Task saveRecord(TaskSaveDto saveDto) throws ElementNotFoundException;

    Task editRecord(TaskEditDto editDto) throws ElementNotFoundException;
}
