package com.sumit.microservices.gita;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BhagwadGitaApplicationTests {

	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setUp() {
		RestAssured.baseURI="http://localhost";
		RestAssured.port=port;
		System.out.println("port is :::   "+port);
	}

	static {
		mongoDBContainer.start();
	}

	@Test
	void shouldCreateShloka() {

		// java multiline strings, introduced after java 14
		String requestBody = """ 
				
				{
					"chapter": 2,
					"verse": 24,
					"shloka": "अच्छेद्योऽयमदाह्योऽयमक्लेद्योऽशोष्य एव च |\\nनित्य: सर्वगत: स्थाणुरचलोऽयं सनातन: || 24||",
					"englishText": "achchhedyo ’yam adāhyo ’yam akledyo ’śhoṣhya eva cha\\nnityaḥ sarva-gataḥ sthāṇur achalo ’yaṁ sanātanaḥ",
					"translation": "BG 2.24: The soul is unbreakable and incombustible; it can neither be dampened nor dried. It is everlasting, in all places, unalterable, immutable, and primordial.",
					"commentary": "The point about immortality is again being driven home here. For the teacher to merely impart perfect knowledge is not enough; for that knowledge to be useful, it must sink deep into the heart of the student. Hence a skillful teacher often repeats a point previously made. In Sanskrit literature, this is called punarukti, or 'repetition.' Shree Krishna has often used punarukti, as a tool in the Bhagavad Gita for stressing the important spiritual principles to ensure that they are grasped deeply by his student."
				}
				
				""";

		RestAssured.given().contentType("application/json").body(requestBody).when().post("/api" +
				"/shloka").then().statusCode(201).body("chapter", Matchers.equalTo(2)).body(
						"verse", Matchers.equalTo(24)).body("shloka", Matchers.equalTo("अच्छेद्योऽयमदाह्योऽयमक्लेद्योऽशोष्य एव च |\nनित्य: सर्वगत: स्थाणुरचलोऽयं सनातन: || 24||"));

	}

}
