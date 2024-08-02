package ru.pr1nkos.islandsimulation.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.lang.NonNull;

import java.util.Objects;

/**
 * The type Yaml property source factory.
 */
public class YamlPropertySourceFactory implements PropertySourceFactory {
    @Override
    public @NonNull PropertySource<?> createPropertySource(String name, EncodedResource resource) {
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(resource.getResource());
        return new org.springframework.core.env.PropertiesPropertySource(name != null
                ? name : Objects.requireNonNull(
                        resource.getResource().getFilename()),
                        Objects.requireNonNull(factory.getObject()
                        )
        );
    }
}
