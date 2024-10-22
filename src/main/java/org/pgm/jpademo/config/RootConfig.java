package org.pgm.jpademo.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {
    @Bean
    public ModelMapper getMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true) // 매치를 사용 가능하게 만듬
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE) // private만 필드 매핑에 사용
                .setMatchingStrategy(MatchingStrategies.LOOSE); // LOOSE, STRICT
        return modelMapper;
    }
}
