package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      userService.addUser(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.addUser(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.addUser(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.addUser(new User("User4", "Lastname4", "user4@mail.ru"));

      userService.addUser(new User("User5", "Lastname5",
              "user5@mail.ru", new Car("Lada", 159)));
      userService.addUser(new User("User6", "Lastname6",
              "user6@mail.ru", new Car("Ural", 8877)));
      userService.addUser(new User("User7", "Lastname7",
              "user7@mail.ru", new Car("BelaZ", 91915)));

      List<User> users = userService.printUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         if (user.getCar() != null) {
            System.out.println("Car Id = "+user.getCar().getId());
            System.out.println("Model = "+user.getCar().getModel());
            System.out.println("Series = "+user.getCar().getSeries());
         }
         System.out.println();
      }

      List<User> usersByCar = carService.printCar("Lada", 159);
      for (User user : usersByCar) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car Id = "+user.getCar().getId());
         System.out.println("Model = "+user.getCar().getModel());
         System.out.println("Series = "+user.getCar().getSeries());
         System.out.println();
      }

      context.close();
   }
}
