package learn.spring.formtags;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class GendersConfiguration {
    @Bean("genders")
    public PropertiesFactoryBean getGenders() {
        var bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("properties/genders.properties"));

        return bean;
    }
}
