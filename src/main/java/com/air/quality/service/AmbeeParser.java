package com.air.quality.service;

import com.air.quality.entity.AmbeeAirQuality;
import com.air.quality.model.ambee.AirQuality;
import com.air.quality.model.ambee.Station;
import com.air.quality.repository.AmbeeAirQualityRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AmbeeParser {
    private static Logger log = LogManager.getLogger();

    @Autowired
    AmbeeAirQualityRepository ambeeRepository;

    @Transactional
    public void parse(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        AirQuality ambeeAQ = mapper.readValue(json, AirQuality.class);
        List<AmbeeAirQuality> aaqList = extractEntities(ambeeAQ);
        ambeeRepository.saveAll(aaqList);
    }

    private List<AmbeeAirQuality> extractEntities(AirQuality aaq) {
        return aaq.getStations()
                  .stream()
                  .map(x -> convertStationToEntity(x))
                  .collect(Collectors.toList());
    }

    private AmbeeAirQuality convertStationToEntity(Station station) {
        return new AmbeeAirQuality()
                .withLatitude(station.getLat())
                .withLongitude(station.getLng())
                .withNo2(station.getNo2())
                .withPm10(station.getPm10())
                .withPm25(station.getPm25())
                .withSo2(station.getSo2())
                .withOzone(station.getOzone())
                .withPostalCode(station.getPostalCode())
                .withCreatedAt(station.getCreatedAt())
                .withUpdateTimestamp(station.getUpdateTs())
                .withDistance(station.getDistance())
                .build();
    }
}
