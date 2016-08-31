package innoday.echostar.com.echopath;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Sheshank.Kodam on 3/16/2016.
 */
public class LocationsRetriever {
    public static LocationsDTO getLcoationsDTO(){
        final String url = "http://10.73.81.104:8080/echopath/location/locationsOnly";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        LocationsDTO locationsDTO = restTemplate.getForObject(url, LocationsDTO.class);
        return locationsDTO;
    }
}
