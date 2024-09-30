package com.deepjyot.job_seeker_service;

import com.deepjyot.job_seeker_service.dto.Service;
import org.junit.ClassRule;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.io.File;


@Testcontainers
public abstract class BaseTest {


    public static final Service MONGO = new Service(
            "mongo", 27017, "0","mongodb://candidate_user:candidate_password@%s:%s/candidate",
            "HOST_PORT1"
    );

    private static final Service JOB = new Service(
            "job-mock", 1080, "0","http://%s:%s/job/",
            "HOST_PORT2"
    );

    @ClassRule
    public static final DockerComposeContainer<?> compose = new
            DockerComposeContainer<>(new File("docker-compose.yaml"));


    @DynamicPropertySource
    static void mongoProperties(DynamicPropertyRegistry registry) {
        compose.withEnv(MONGO.getHostPortEnvVariable() , MONGO.getHostPort())
                .withEnv(JOB.getHostPortEnvVariable() , JOB.getHostPort())
                .withExposedService(MONGO.getName(), MONGO.getPort(), Wait.forListeningPort())
                .withExposedService(JOB.getName(), JOB.getPort(), Wait.forHttp("/health").forStatusCode(200))
                .start();

        var mongoHost = compose.getServiceHost(MONGO.getName(), MONGO.getPort());
        var mongoPort = compose.getServicePort(MONGO.getName(), MONGO.getPort());
        var jobHost = compose.getServiceHost(JOB.getName(), JOB.getPort());
        var jobPort = compose.getServicePort(JOB.getName(), JOB.getPort());

        registry.add("spring.data.mongodb.uri", () -> String.format(MONGO.getUri(), mongoHost, mongoPort));
        registry.add("job.service.url", () -> String.format(JOB.getUri(), jobHost, jobPort));
    }
}
