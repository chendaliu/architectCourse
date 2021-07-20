package pers.czl.architectCourse;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArchitectCourseApplicationTests {

	//@Test
	void contextLoads() {
	}

	public static void main(String[] args) {
		ArchitectCourseApplicationTests tests = new ArchitectCourseApplicationTests();
		tests.test();
	}

	@Test
	public void test() {
		String str = "123456".substring(0, 1);
		System.out.println(str);
	}


}
