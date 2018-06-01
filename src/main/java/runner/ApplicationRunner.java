/**
 * 
 */
package runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Pijush
 *
 */

@SpringBootApplication(scanBasePackages = {"controller", "service"})
public class ApplicationRunner extends SpringBootServletInitializer{

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class, args);
    }
    
}
