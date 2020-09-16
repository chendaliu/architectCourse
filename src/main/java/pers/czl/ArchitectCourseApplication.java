package pers.czl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.convert.converter.Converter;

import java.sql.SQLException;

@SpringBootApplication
public class ArchitectCourseApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws SQLException {
        Converter<String, Integer> converter = Integer::valueOf;
        converter.convert("1");
        SpringApplication.run(ArchitectCourseApplication.class, args);
    }

/*    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };*/

}
