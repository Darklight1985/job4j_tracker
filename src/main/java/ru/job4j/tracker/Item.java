package ru.job4j.tracker;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name, LocalDateTime time) {
        this.id = id;
        this.name = name;
        this.created = time;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Timestamp getCreatedTimeStemp() {
        Timestamp timestampFromLDT = Timestamp.valueOf(created);
        return timestampFromLDT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", created=" + created.format(FORMATTER)
                + '}';
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}