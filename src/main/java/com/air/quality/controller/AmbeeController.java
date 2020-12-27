package com.air.quality.controller;

import com.air.quality.AirQualityRunner;
import com.air.quality.entity.AmbeeAirQuality;
import com.air.quality.model.ambee.AirQuality;
import com.air.quality.repository.AmbeeAirQualityRepository;
import com.air.quality.service.AmbeeParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class AmbeeController {
    private static Logger log = LogManager.getLogger();

    @Value("${AMBEE_DATA_BY_CITY_URL}")
    private String ambeeCityUrl;

    @Value("${DATA_COLLECTING_CITY}")
    private String dataCollectingCity;

    @Value("${AMBEE_API_KEY}")
    private String ambeeApiKey;

    @Autowired
    AmbeeParser ambeeParser;

    @PostConstruct
    public void init() throws IOException, URISyntaxException {
        parseCityData();
    }

//    @PostConstruct
    public void loadMockData() throws IOException { //todo extract and run mock class
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("json/initial.json").getFile());
        AirQuality aq = mapper.readValue(file, AirQuality.class);
    }
    
    @GetMapping
    public void parseCityData() throws IOException, URISyntaxException {
        System.out.println(System.getProperty("user.dir"));
//        ambeeParser.parse(Files.readString(Paths.get("target/classes/json/second.json"), StandardCharsets.UTF_8));
        ambeeParser.parse(Files.readString(Paths.get(ClassLoader.getSystemResource("json/second.json")
                                                                .toURI()), StandardCharsets.UTF_8));

//        HttpResponse<String> response = Unirest.get(ambeeCityUrl + dataCollectingCity)
//                .header("x-api-key", ambeeApiKey)
//                .header("Content-type", "application/json")
//                .asString();
//        ambeeParser.parse(response.getBody());
    }
}
