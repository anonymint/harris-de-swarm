package com.anonymint.sso;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Resource Application Service
 *
 * @author <a href="mailto:mint.coml@gmail.com">anonymint</a>
 * @since 2015-11-23
 */

@SpringBootApplication
@RestController
@EnableResourceServer
//@EnableEurekaClient
public class ResourceApplication {
    private static final Logger log = LoggerFactory.getLogger(ResourceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }

    @Value("${special.promotion}")
    String specialPromotion;

    @RequestMapping("/")
    HomeResource home() {
        String content = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Rem harum, unde? Id quam iste, quidem nihil quibusdam! Perspiciatis, a explicabo dolorem similique debitis impedit aut? Maiores enim atque doloribus. Itaque sit quasi accusamus tempora laborum sunt magni a officia quia ut! Amet laborum nostrum necessitatibus repellat dolores nesciunt ea placeat, magnam, inventore mollitia vero expedita. Ex facilis mollitia, cum ullam totam labore in quam laboriosam, nostrum velit blanditiis? Maiores incidunt error sequi aut quas! Dolorum est, saepe obcaecati voluptatibus mollitia natus, vero dolorem porro corrupti, aut numquam minima autem cum, itaque magni. Nulla, qui, rem ipsum quidem nostrum similique cupiditate!";
        return new HomeResource(UUID.randomUUID().toString(), content, specialPromotion);
    }

    public class HomeResource {
        private final String id;
        private final String lastUpdate;
        private final String content;
        private final String specialPromotion;

        public HomeResource(String id, String content, String specialPromotion) {
            this.id = id;
            this.content = content;
            this.lastUpdate = LocalDateTime.now().toString();
            this.specialPromotion = specialPromotion;
        }

        public String getId() {
            return id;
        }

        public String getLastUpdate() {
            return lastUpdate;
        }

        public String getContent() {
            return content;
        }

        public String getSpecialPromotion() {
            return specialPromotion;
        }
    }
}
