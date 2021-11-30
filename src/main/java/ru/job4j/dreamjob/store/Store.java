package ru.job4j.dreamjob.store;

import ru.job4j.dreamjob.model.Post;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Store {

    private static final Store INST = new Store();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private Store() {
        posts.put(1, new Post(
                1,
                "Junior Java Job",
                "Some vacancy description goes here",
                LocalDateTime.now().minusDays(6)
        ));
        posts.put(2, new Post(
                2,
                "Middle Java Job",
                "Some vacancy description goes here",
                LocalDateTime.now().minusDays(10)
        ));
        posts.put(3, new Post(
                3,
                "Senior Java Job",
                "Some vacancy description goes here",
                LocalDateTime.now().minusDays(14)
        ));
    }

    public static Store instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }
}
