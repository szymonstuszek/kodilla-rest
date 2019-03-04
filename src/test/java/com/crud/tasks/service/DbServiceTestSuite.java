package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbServiceTestSuite {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private DbService dbService;

    @Test
    public void testSaveTask() {
        //Given
        Task task = new Task(50L, "Save to db", "Sample content");

        //When
        Task savedTask = dbService.saveTask(task);

        //Then
        assertEquals("Save to db", savedTask.getTitle());
    }

    @Test
    public void testGetTaskById() {
        //Given
        Task task = new Task(100L, "Task to retrieve", "Sample content");
        Task savedTask = dbService.saveTask(task);
        Long id = savedTask.getId();

        //When
        Optional<Task> retrievedTask = dbService.getTaskById(id);

        //Then
        assertNotNull(retrievedTask);
    }

    @Test
    public void testRemoveTaskById() {
        //Given
        Task task = new Task(100L, "Task to retrieve", "Sample content");
        Task savedTask = dbService.saveTask(task);
        Long id = savedTask.getId();

        //When

        //Then
        dbService.removeTask(id);
    }

    @Test
    public void testGetAllTasks() {
        //Given
        Task task = new Task(100L, "Task to retrieve", "Sample content");
        Task savedTask = dbService.saveTask(task);

        //When
        List<Task> taskList = dbService.getAllTasks();

        //Then
        assertThat(taskList.size(), greaterThan(0));
    }
}