import com.sterhov.rest.config.MyConfig;
import com.sterhov.rest.models.User;
import com.sterhov.rest.service.CommunicationImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        CommunicationImpl communication = context.getBean(CommunicationImpl.class);

//       List<User> allUser = communication.showAllUsers();
//        System.out.println(allUser);
//
//        User user = communication.getUser(2);
//        System.out.println(user);


        User userUpdate = new User("FOREST", "TRUMP", 25, "forest@gmail.com");
        userUpdate.setId(50);
        communication.saveUser(userUpdate);

        communication.deleteUser(46);

        context.close(); // не забудьте закрыть контекст после использования
    }
}
