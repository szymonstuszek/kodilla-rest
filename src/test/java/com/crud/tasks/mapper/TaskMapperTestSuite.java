package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.dto.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskMapperTestSuite {

    @Autowired
    private TaskMapper taskMapper;


    @Test
    public void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Test task title", "My newest task");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(1L, (long) task.getId());
        assertEquals("Test task title", task.getTitle());
        assertEquals("My newest task", task.getContent());
        assertEquals(Task.class, task.getClass());
    }

    @Test
    public void testMapToTaskDto() {
        //Given
        Task task = new Task(1L, "Test task title", "My newest task");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(1L, (long) task.getId());
        assertEquals("Test task title", task.getTitle());
        assertEquals("My newest task", task.getContent());
        assertEquals(TaskDto.class, taskDto.getClass());
    }

    @Test
    public void testMapToTaskDtoList() {
        //Given
        List<Task> taskList = new ArrayList<>();
        Task task1 = new Task(1L, "Test task title1", "My newest task1");
        Task task2 = new Task(2L, "Test task title2", "My newest task2");
        Task task3 = new Task(3L, "Test task title3", "My newest task3");

        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);

        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals(1L, (long) taskDtoList.get(0).getId());
        assertEquals("Test task title1", taskDtoList.get(0).getTitle());
        assertEquals("My newest task1", taskDtoList.get(0).getContent());
        assertEquals(TaskDto.class, taskDtoList.get(0).getClass());
        assertEquals(3, taskDtoList.size());
    }
}