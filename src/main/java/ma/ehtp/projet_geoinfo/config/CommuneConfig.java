package ma.ehtp.projet_geoinfo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import ma.ehtp.projet_geoinfo.custom.CustomGeoJsonSerializer;
import org.locationtech.jts.geom.Geometry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommuneConfig {

    @Bean
    public ObjectMapper getObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule= new SimpleModule();
        simpleModule.addSerializer(Geometry.class, new CustomGeoJsonSerializer());
        objectMapper.registerModule(simpleModule);
        return objectMapper;
    }
}
