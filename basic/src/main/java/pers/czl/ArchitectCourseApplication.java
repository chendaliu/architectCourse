package pers.czl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;

@SpringBootApplication
@ComponentScan(excludeFilters =
        {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "pers.czl.spring.*")
        })
public class ArchitectCourseApplication { //extends SpringBootServletInitializer {

    public static void main(String[] args) throws SQLException {

        SpringApplication.run(ArchitectCourseApplication.class);
    }

   /* @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ArchitectCourseApplication.class);
    }*/

/*    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };*/

}
