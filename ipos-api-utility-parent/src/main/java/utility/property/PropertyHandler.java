package utility.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
//import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import utility.logger.LogHelper;

@Configuration
@PropertySources(@PropertySource("classpath:iposapplication.properties"))
public class PropertyHandler extends PropertySourcesPlaceholderConfigurer implements EnvironmentAware {

	@Autowired
	private ConfigurableEnvironment env;

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer(ConfigurableEnvironment env) {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Autowired
	public void setConfigurableEnvironment(ConfigurableEnvironment env) {
		final String fileName = "";
		final Resource resource = new ClassPathResource(fileName);
		if (resource.exists()) {
			try {
				MutablePropertySources sources = env.getPropertySources();
				sources.addFirst(
						new PropertiesPropertySource(fileName, PropertiesLoaderUtils.loadProperties(resource)));
			} catch (Exception ex) {
				LogHelper.error(this.getClass(),ex.getMessage());
				throw new RuntimeException(ex.getMessage(), ex);
			}
		}

		this.env = env;
	}

	public String getPropertyValue(String key) {
		return env.getProperty(key);
	}
}
