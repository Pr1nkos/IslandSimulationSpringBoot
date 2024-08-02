package ru.pr1nkos.islandsimulation.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Island config.
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "island")
public class IslandConfig {

    private int width;
    private int height;
    private String[][] island;

    /**
     * Island string [ ] [ ].
     *
     * @return the string [ ] [ ]
     */
    @Bean
    public String[][] island() {
        island = new String[width][height];
        return island;
    }

}
