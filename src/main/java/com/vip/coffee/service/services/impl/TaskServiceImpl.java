package com.vip.coffee.service.services.impl;

import com.vip.coffee.service.dto.TaskEditDto;
import com.vip.coffee.service.dto.TaskSaveDto;
import com.vip.coffee.service.enums.TaskStatus;
import com.vip.coffee.service.enums.TaskType;
import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.model.CoffeeMachine;
import com.vip.coffee.service.model.Task;
import com.vip.coffee.service.repository.TaskRepository;
import com.vip.coffee.service.services.CoffeeMachineService;
import com.vip.coffee.service.services.TaskService;
import com.vip.coffee.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final CoffeeMachineService machineService;
    private final TaskRepository taskRepository;
    private final UserService userService;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, CoffeeMachineService machineService, UserService userService) {
        this.taskRepository = taskRepository;
        this.machineService = machineService;
        this.userService = userService;
    }

    @Override
    public List<Task> getAllTasksForMachineWithId(Long machineId) throws ElementNotFoundException {
        CoffeeMachine machine = machineService.getById(machineId);
        return taskRepository.findAllByCoffeeMachine(machine);
    }

    @Override
    public Task findById(Long taskId) throws ElementNotFoundException {
        return taskRepository.findById(taskId).orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public Task saveRecord(TaskSaveDto saveDto) throws ElementNotFoundException {
        return taskRepository.save(
                new Task()
                .setCoffeeMachine(machineService.getById(saveDto.getMachineId()))
                .setType(TaskType.valueOf(saveDto.getType()))
                .setStatus(TaskStatus.valueOf(saveDto.getStatus()))
                .setEstimation(saveDto.getEstimation())
                .setStartDate(toLocalDateTime(saveDto.getStartDate()))
                .setEndDate(toLocalDateTime(saveDto.getEndDate()))
                .setDueDate(toLocalDateTime(saveDto.getDueDate()))
                .setAssignee(userService.findByUsername(saveDto.getAssignee()))
                .setInputInformation(saveDto.getInputInformation())
                .setOutputInformation(saveDto.getOutputInformation())
        );
    }

    @Override
    public Task editRecord(TaskEditDto editDto) throws ElementNotFoundException {
        return taskRepository.save(
                findById(editDto.getId())
                        .setCoffeeMachine(machineService.getById(editDto.getMachineId()))
                        .setType(TaskType.valueOf(editDto.getType()))
                        .setStatus(TaskStatus.valueOf(editDto.getStatus()))
                        .setEstimation(editDto.getEstimation())
                        .setStartDate(toLocalDateTime(editDto.getStartDate()))
                        .setEndDate(toLocalDateTime(editDto.getEndDate()))
                        .setDueDate(toLocalDateTime(editDto.getDueDate()))
                        .setAssignee(userService.findByUsername(editDto.getAssignee()))
                        .setInputInformation(editDto.getInputInformation())
                        .setOutputInformation(editDto.getOutputInformation())
        );
    }

    private LocalDateTime toLocalDateTime(String datetime) {
        if(datetime.length() == 0) return null;
        String[] parts = datetime.split("T");
        String[] date = parts[0].split("-");
        String[] time = parts[1].split(":");

        return LocalDateTime.of(
                Integer.parseInt(date[0]),
                Integer.parseInt(date[1]),
                Integer.parseInt(date[2]),
                Integer.parseInt(time[0]),
                Integer.parseInt(time[1])
        );
    }
}
