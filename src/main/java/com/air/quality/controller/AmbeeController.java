package com.air.quality.controller;

import com.air.quality.service.AmbeeParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

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

    @GetMapping
    public void parseCityData() throws IOException, URISyntaxException {
        Class currentClass = this.getClass();
        ClassLoader classLoader = currentClass.getClassLoader();
        ambeeParser.parse(Files.readString(Path.of(classLoader.getResource("json/second.json").toURI())));

//        HttpResponse<String> response = Unirest.get(ambeeCityUrl + dataCollectingCity)
//                .header("x-api-key", ambeeApiKey)
//                .header("Content-type", "application/json")
//                .asString();
//        ambeeParser.parse(response.getBody());
    }
}
