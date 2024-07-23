package com.kocak.task_management;


import com.kocak.task_management.base.AbstractIntegrationTest;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class TaskRestControllerIntegrationTest extends AbstractIntegrationTest {
    @Autowired
    private Task task;

    @Autowired
    private TaskRepo taskRepo;

    @PostConstruct
    public void init() {
        task = generateUser();
    }

    @Test
    @DisplayName("Happy Path Test: save task and return task list")
    void givenCorrectTask_whenSaveTask_thenReturnTaskList() throws Exception {
        //when
        List<Task> taskList = performPostRequestExpectedSuccess(TASK_API_ENDPOINT,task, List.class);

        assertNotNull(taskList);

    }





}
