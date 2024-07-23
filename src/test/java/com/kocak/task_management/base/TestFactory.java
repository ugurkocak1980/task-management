package com.kocak.task_management.base;

import com.kocak.task_management.Priority;
import com.kocak.task_management.Task;

import java.time.Instant;


public class TestFactory {

    public static final String TASK_API_ENDPOINT = "/task/v1";

    public static Instant now = Instant.now();

    public Task generateUser() {
        return new Task()
                .setId(5L)
                .setName("name")
                .setDone(false)
                .setPriority(Priority.LOW)
                .setCreated(now);
    }
}