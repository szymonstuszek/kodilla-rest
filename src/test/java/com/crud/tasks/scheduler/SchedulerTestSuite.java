package com.crud.tasks.scheduler;

import org.junit.Test;

public class SchedulerTestSuite {

    @Test
    public void sendInformationMailStringTest() {
        //Given
        long count = 1;

        String message = "Currently in the database you have: " + count + " task";
        if(count == 0 || count > 1) {
            message += "s";
        }

        //When

        //Then
        System.out.println(message);
    }
}
