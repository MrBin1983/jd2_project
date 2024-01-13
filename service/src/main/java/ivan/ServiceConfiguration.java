package ivan;

import ivan.DataConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "ivan")
@Import(DataConfiguration.class)
public class ServiceConfiguration {

}
