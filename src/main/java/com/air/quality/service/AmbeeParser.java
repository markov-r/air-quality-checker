package com.air.quality.service;

import com.air.quality.entity.AmbeeAqBatch;
import com.air.quality.entity.AmbeeAqData;
import com.air.quality.model.ambee.AirQuality;
import com.air.quality.model.ambee.Station;
import com.air.quality.repository.AmbeeAqBatchRepository;
import com.air.quality.repository.AmbeeAqDataRepository;
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
    AmbeeAqDataRepository ambeeAqDataRepository;

    @Autowired
    AmbeeAqBatchRepository ambeeAqBatchRepository;

    @Transactional
    public void parse(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        AirQuality ambeeAQ = mapper.readValue(json, AirQuality.class);
        List<AmbeeAqData> aaqList = extractEntities(ambeeAQ);
        ambeeAqBatchRepository.save(new AmbeeAqBatch(aaqList));
        ambeeAqDataRepository.saveAll(aaqList);
    }

    private List<AmbeeAqData> extractEntities(AirQuality aaq) {
        return aaq.getStations()
                  .stream()
                  .map(x -> convertStationToEntity(x))
                  .collect(Collectors.toList());
    }

    private AmbeeAqData convertStationToEntity(Station station) {
        return new AmbeeAqData()
                .withLatitude(station.getLat())
                .withLongitude(station.getLng())
                .withNo2(station.getNo2())
                .withPm10(station.getPm10())
                .withPm25(station.getPm25())
                .withSo2(station.getSo2())
                .withOzone(station.getOzone())
                .withPostalCode(station.getPostalCode())
                .withCreatedAt(station.getCreatedAt())
                .withUpdatedAt(station.getUpdateTs())
                .withDistance(station.getDistance())
                .build();
    }
}
