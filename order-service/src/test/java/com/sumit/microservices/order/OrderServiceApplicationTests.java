package com.sumit.microservices.order;

import com.sumit.microservices.order.stubs.InventoryClientStub;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;

import static org.hamcrest.MatcherAssert.assertThat;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
class OrderServiceApplicationTests {

	@ServiceConnection
	static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.0.26");

	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static {
		mySQLContainer.start();
	}

	@Test
	void shouldSubmitOrder() {
		String submitOrderJSON = """
				{
					"skuCode": "iphone15",
					"price": 1200,
					"quantity": 50
				}
				""";

		InventoryClientStub.stubInventoryCall("iphone15", 50);

		var responseBodyString = RestAssured.given()
				.contentType("application/json")
				.body(submitOrderJSON)
				.when()
				.post("/api/order")
				.then()
				.statusCode(201)
				.extract()
				.body()
				.asString();

		assertThat(responseBodyString, Matchers.is("Order placed successfully"));
	}

}
