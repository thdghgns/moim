package ac.moim.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.OAuth2Parameters;

/**
 * Created by SONG_HOHOON on 2016-12-15.
 */
@Configuration
public class GoogleConfiguration {

	@Autowired
	Environment env;

	@Bean(name = "googleConnectionFactory")
	public GoogleConnectionFactory googleConnectionFactory() {

		String clientId = env.getProperty("google.api.oauth.client.id");
		String clientSecret = env.getProperty("google.api.oauth.client.secret");

		GoogleConnectionFactory googleConnectionFactory = new GoogleConnectionFactory(clientId, clientSecret);

		return googleConnectionFactory;
	}

	@Bean(name = "googleOAuth2Parameters")
	public OAuth2Parameters googleOAuth2Parameters() {

		String scope = env.getProperty("google.api.oauth.scope");
		String redirectUrl = env.getProperty("google.api.oauth.redirect.url");

		OAuth2Parameters oAuth2Parameters = new OAuth2Parameters();
		oAuth2Parameters.setScope(scope);
		oAuth2Parameters.setRedirectUri(redirectUrl);

		return oAuth2Parameters;
	}
}
