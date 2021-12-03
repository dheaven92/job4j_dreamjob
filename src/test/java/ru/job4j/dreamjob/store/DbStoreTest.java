package ru.job4j.dreamjob.store;

import org.junit.Test;
import ru.job4j.dreamjob.model.Candidate;
import ru.job4j.dreamjob.model.Post;
import ru.job4j.dreamjob.model.User;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class DbStoreTest {

    @Test
    public void whenCreatePost() {
        Store store = DbStore.instanceOf();
        Post post = new Post(0, "Java Job");
        store.savePost(post);
        Post postInDb = store.findPostById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Test
    public void whenUpdatePost() {
        Store store = DbStore.instanceOf();
        Post post = new Post(0, "Java Job");
        store.savePost(post);
        post.setName("Java Job Updated");
        store.savePost(post);
        Post postInDb = store.findPostById(post.getId());
        assertThat(postInDb.getName(), is("Java Job Updated"));
    }

    @Test
    public void whenCreateCandidate() {
        Store store = DbStore.instanceOf();
        Candidate candidate = new Candidate(0, "Java Junior");
        store.saveCandidate(candidate);
        Candidate candidateInDb = store.findCandidateById(candidate.getId());
        assertThat(candidateInDb.getName(), is(candidate.getName()));
    }

    @Test
    public void whenUpdateCandidate() {
        Store store = DbStore.instanceOf();
        Candidate candidate = new Candidate(0, "Java Junior");
        store.saveCandidate(candidate);
        candidate.setName("Java Middle");
        store.saveCandidate(candidate);
        Candidate candidateInDb = store.findCandidateById(candidate.getId());
        assertThat(candidateInDb.getName(), is("Java Middle"));
    }

    @Test
    public void whenDeleteCandidate() {
        Store store = DbStore.instanceOf();
        Candidate candidate = new Candidate(0, "Java Junior");
        store.saveCandidate(candidate);
        Candidate candidateInDb = store.findCandidateById(candidate.getId());
        store.deleteCandidate(candidateInDb.getId());
        assertThat(store.findCandidateById(candidateInDb.getId()), is(nullValue()));
    }

    @Test
    public void whenCreateUser() {
        Store store = DbStore.instanceOf();
        User user = new User(0, "Bob", "bob@mail.com", "");
        store.saveUser(user);
        User userInDb = store.findUserById(user.getId());
        assertThat(userInDb.getName(), is(user.getName()));
    }

    @Test
    public void whenFindUserByEmail() {
        Store store = DbStore.instanceOf();
        User user1 = new User(0, "Alex", "alex@mail.com", "");
        store.saveUser(user1);
        User user2 = new User(0, "Jim", "jim@mail.com", "");
        store.saveUser(user2);
        User userInDb = store.findUserByEmail(user2.getEmail());
        assertThat(userInDb.getEmail(), is(user2.getEmail()));
    }

    @Test
    public void whenDeleteUser() {
        Store store = DbStore.instanceOf();
        User user = new User(0, "Sam", "sam@mail.com", "");
        store.saveUser(user);
        store.deleteUser(user.getId());
        assertThat(store.findUserById(user.getId()), is(nullValue()));
    }
}