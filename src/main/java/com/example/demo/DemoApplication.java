
package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
//@RestController
public class DemoApplication implements CommandLineRunner{
  
  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
  
  // @GetMapping("/hello")
  // public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
  //   return String.format("Hello %s!", name);
  // }

  @Override
  public void run(String... args) throws Exception {
      String sql = "INSERT INTO articles (title, body) VALUES ("
              + "'Hello', 'What is up')";
       
      int rows = jdbcTemplate.update(sql);
      if (rows > 0) {
          System.out.println("A new row has been inserted.");
      }
  }
  
}
            