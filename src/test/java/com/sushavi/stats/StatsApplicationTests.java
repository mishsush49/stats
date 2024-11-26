package com.sushavi.stats;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StatsApplicationTests {

	@Test
	void contextLoads() {
		String application = "Stats";
		assertEquals("Stats", application);
	}

}
