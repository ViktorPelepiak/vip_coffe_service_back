package com.vip.coffee.service.controller;

import com.vip.coffee.service.dto.TaskEditDto;
import com.vip.coffee.service.dto.TaskFullDto;
import com.vip.coffee.service.dto.TaskSaveDto;
import com.vip.coffee.service.dto.TaskShortDto;
import com.vip.coffee.service.enums.TaskStatus;
import com.vip.coffee.service.enums.TaskType;
import com.vip.coffee.service.exceptions.ElementNotFoundException;
import com.vip.coffee.service.model.Task;
import com.vip.coffee.service.rest.GenericResponse;
import com.vip.coffee.service.services.TaskService;
import com.vip.coffee.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("task")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("types")
    public GenericResponse<List<Pair<String, String>>> getTaskTypes() {
        return GenericResponse.of(
                Arrays.stream(TaskType.values())
                        .map(type -> Pair.of(type.name(), type.getValue()))
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("statuses")
    public GenericResponse<List<Pair<String, String>>> getTaskStatuses() {
        return GenericResponse.of(
                Arrays.stream(TaskStatus.values())
                        .map(status -> Pair.of(status.name(), status.getValue()))
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("masters")
    public GenericResponse<List<Pair<String, String>>> getTaskMasters() {
        return GenericResponse.of(
                userService.findAllMasters().stream()
                        .map(master -> Pair.of(master.getId().toString(), master.getUsername()))
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("{taskId}")
    public GenericResponse<TaskFullDto> getTaskById(@PathVariable Long taskId) {
        try {
            return GenericResponse.of(TaskFullDto.toDto(taskService.findById(taskId)));
        } catch (ElementNotFoundException e) {
            return GenericResponse.error(e.getMessage());
        }
    }

    @GetMapping("for_machine/{machineId}")
    public GenericResponse<List<TaskShortDto>> getAllTasksForMachineWithId(@PathVariable Long machineId) {
        try {
            return GenericResponse.of(
                    taskService.getAllTasksForMachineWithId(machineId).stream()
                            .map(TaskShortDto::toDto)
                            .collect(Collectors.toList())
            );
        } catch (ElementNotFoundException e) {
            return GenericResponse.error(e.getMessage());
        }
    }

    @PostMapping
    public GenericResponse<Task> saveRecord(@RequestBody TaskSaveDto saveDto) {
        try {
            return GenericResponse.of(taskService.saveRecord(saveDto));
        } catch (ElementNotFoundException e) {
            return GenericResponse.error(e.getMessage());
        }
    }

    @PutMapping
    public GenericResponse<Task> editRecord(@RequestBody TaskEditDto editDto) {
        try {
            return GenericResponse.of(taskService.editRecord(editDto));
        } catch (ElementNotFoundException e) {
            return GenericResponse.error(e.getMessage());
        }
    }
}
