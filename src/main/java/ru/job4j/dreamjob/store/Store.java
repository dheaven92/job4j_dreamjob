package ru.job4j.dreamjob.store;

import ru.job4j.dreamjob.model.Candidate;
import ru.job4j.dreamjob.model.Post;
import ru.job4j.dreamjob.model.User;

import java.util.Collection;

public interface Store {

    Collection<Post> findAllPosts();

    void savePost(Post post);

    Post findPostById(int id);

    Collection<Candidate> findAllCandidates();

    void saveCandidate(Candidate candidate);

    Candidate findCandidateById(int id);

    void deleteCandidate(int id);

    Collection<User> findAllUsers();

    void saveUser(User user);

    User findUserById(int id);

    User findUserByEmail(String email);

    void deleteUser(int id);
}
