package ac.moim.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by SONG_HOHOON on 2017-01-05.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(
		basePackages = {"ac.moim"},
		useDefaultFilters = false,
		includeFilters = {
				@ComponentScan.Filter(value = Repository.class, type = FilterType.ANNOTATION)
				,@ComponentScan.Filter(value = Service.class, type = FilterType.ANNOTATION)
		}
)
@Import(value = {DatabaseConfiguration.class, GoogleConfiguration.class, WebConfiguration.class})
public class ServiceTestConfiguration {

}