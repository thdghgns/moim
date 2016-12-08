package ac.moim.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;

/**
 * Created by SONG_HOHOON on 2016-11-17.
 */
@Configuration
@EnableSpringDataWebSupport
public class WebConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	Environment environment;

	@Bean
	public Filter characterEncodingFilter() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return characterEncodingFilter;
	}

	@Bean(name = "googleConnectionFactory")
	public GoogleConnectionFactory googleConnectionFactory() {

		String clientId = environment.getProperty("google.api.oauth.client.id");
		String clientSecret = environment.getProperty("google.api.oauth.client.secret");

		GoogleConnectionFactory googleConnectionFactory = new GoogleConnectionFactory(clientId, clientSecret);

		return googleConnectionFactory;
	}

	@Bean(name = "googleOAuth2Parameters")
	public OAuth2Parameters googleOAuth2Parameters() {

		String scope = environment.getProperty("google.api.oauth.scope");
		String redirectUrl = environment.getProperty("google.api.oauth.redirect.url");

		OAuth2Parameters oAuth2Parameters = new OAuth2Parameters();
		oAuth2Parameters.setScope(scope);
		oAuth2Parameters.setRedirectUri(redirectUrl);

		return oAuth2Parameters;
	}
}
