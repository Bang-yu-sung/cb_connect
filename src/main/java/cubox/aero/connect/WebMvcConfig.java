package cubox.aero.connect;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"cubox.aero.connect"})
public class WebMvcConfig implements WebMvcConfigurer {

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(new String[]{"/js/**"})
                .addResourceLocations(new String[]{"classpath:/static/js/"})
                .setCachePeriod(Integer.valueOf(20));

        registry.addResourceHandler(new String[]{"/css/**"})
                .addResourceLocations(new String[]{"classpath:/static/css/"})
                .setCachePeriod(Integer.valueOf(20));

        registry.addResourceHandler(new String[]{"/font/**"})
                .addResourceLocations(new String[]{"classpath:/static/font/"})
                .setCachePeriod(Integer.valueOf(20));

        registry.addResourceHandler(new String[]{"/img/**"})
                .addResourceLocations(new String[]{"classpath:/static/img/"})
                .setCachePeriod(Integer.valueOf(20));

        registry.addResourceHandler(new String[]{"/favicon.ico"})
                .addResourceLocations(new String[]{"classpath:/static/favicon.ico"})
                .setCachePeriod(Integer.valueOf(20));
    }
}