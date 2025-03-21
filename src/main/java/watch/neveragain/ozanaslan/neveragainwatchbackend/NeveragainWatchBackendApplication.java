package watch.neveragain.ozanaslan.neveragainwatchbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NeveragainWatchBackendApplication {


    //TODO: implement article versioning using hibernate envers
    //TODO: implement custom user detail (service)
    //TODO: implement basic repos and services to access database contents
    //TODO: implement basic CRUD controllers to edit articles, browse revisions, and to edit users as well as an auth config.

    public static void main(String[] args) {
        SpringApplication.run(NeveragainWatchBackendApplication.class, args);
    }

}
