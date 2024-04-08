package example_project.repository;

import lombok.Getter;

public class RepositoryUtil {

    @Getter
    private static final UserRepository repo = new InMemoryUserRepository();

}
