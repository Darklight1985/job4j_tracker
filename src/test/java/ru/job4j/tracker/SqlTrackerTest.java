package ru.job4j.tracker;

import org.hamcrest.core.IsNull;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = tracker.add(new Item("First"));
        Item second = tracker.add(new Item("Second"));
        Item three = tracker.add(new Item("First"));
        assertThat(tracker.findByName(first.getName()), is(List.of(first, three)));
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = tracker.add(new Item("First"));
        Item second = tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        assertThat(tracker.findByName(second.getName()).get(1).getName(), is(second.getName()));
    }

    @Test
    public void whenTestFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item bug = tracker.add(new Item("Bug"));
        Item result = tracker.findById(bug.getId());
        assertThat(result.getName(), is(bug.getName()));
    }

    @Test
    public void whenTestFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = tracker.add(new Item("First"));
        Item second = tracker.add(new Item("Second"));
        assertThat(tracker.findAll().get(0).getName(), is(first.getName()));
    }

    @Test
    public void whenReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item bug = tracker.add(new Item("Bug"));
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item bug = tracker.add(new Item("Bug"));
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(IsNull.nullValue()));
    }
}