package exercise;

import exercise.daytime.Day;
import exercise.daytime.Daytime;
import exercise.daytime.Night;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

// BEGIN

// END

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @Scope("prototype")
    @Bean
    public Daytime getDayTime() {
        if(LocalDateTime.now().getHour() >= 6 && LocalDateTime.now().getHour() <= 22) {
            return new Day();
        } else {
            return new Night();
        }
    };
    // END
}
