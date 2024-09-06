package ftn.devops.audit;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.CassandraContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
class AuditApplicationTests {
	@Container
	public static CassandraContainer<?> database = new CassandraContainer<>("cassandra:4.0.13")
		.withInitScript("init.cql")
		.withStartupTimeout(Duration.ofMinutes(5));

	@DynamicPropertySource
	static void bindCassandraProperties(DynamicPropertyRegistry registry) {
		registry.add("cassandra.keyspace-name", () -> "demo");
		registry.add("cassandra.port", () -> database.getMappedPort(9042));
		registry.add("cassandra.datacenter", () -> "datacenter1");
		registry.add("cassandra.url", () -> "127.0.0.1");
    }

	@BeforeAll
	static void beforeAll() {
		database.start();
	}

	@AfterAll
	static void afterAll() {
		database.stop();
	}

	@Test
	void contextLoads() {
		assertTrue(database.isRunning());
	}

}
