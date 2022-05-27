package ru.netology.javacore;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodosTests {

    @BeforeAll
    public static void initSuite() {
        System.out.println("Starting tests");
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("All tests completed");
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Starting new test");
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("Test completed");
    }

    @Test
    @DisplayName("Test \"addTask()\" method")
    public void addTaskTest(TestInfo addTaskTestInfo) {

        Todos todo = new Todos();
        todo.addTask("Doing task");
        boolean actual = todo.getAllTasks().contains("Doing task");

        Assertions.assertTrue(actual, addTaskTestInfo.getDisplayName() + "Not completed");
        System.out.println(addTaskTestInfo.getDisplayName() + " completed");
    }

    @Test
    @DisplayName("Test \"removeTask()\" method")
    public void removeTaskTest(TestInfo removeTaskTestInfo) {

        Todos todo = new Todos();
        todo.addTask("Doing something!");
        todo.removeTask("Doing something!");
        boolean actual = todo.getAllTasks().contains("Doing something!");

        Assertions.assertFalse(actual, removeTaskTestInfo.getDisplayName() + " NO complete");
        System.out.println(removeTaskTestInfo.getDisplayName() + " completed");
    }


    @Test
    @DisplayName("Test \"getAllTask()\" method")
    public void getAllTasksTest(TestInfo getAllTasksTestInfo) {

        Todos todo = new Todos();
        String expected = "Task one" +
                " " +
                "Task three" +
                " " +
                "Task two" +
                " ";

        todo.addTask("Task one");
        todo.addTask("Task two");
        todo.addTask("Task three");

        Assertions.assertEquals(expected, todo.getAllTasks(), getAllTasksTestInfo.getDisplayName() + " NO complete!");
        System.out.println(getAllTasksTestInfo.getDisplayName() + " completed");
    }

    @Test
    @DisplayName("Test \"getAllTasksAsList()\" method")
    public void getAllTasksAsListTest(TestInfo getAllTasksAsListTestInfo) {
        Todos todo = new Todos();
        todo.addTask("Task one");
        todo.addTask("Task two");
        todo.addTask("Task three");

        List<String> expected = new ArrayList<>(Arrays.asList("Task one", "Task two", "Task three"));
        List<String> actual = todo.getAllTasksAsList();

        Assertions.assertEquals(expected, actual, getAllTasksAsListTestInfo.getDisplayName() + " NO complete!");
        System.out.println(getAllTasksAsListTestInfo.getDisplayName() + " completed");
    }
}
