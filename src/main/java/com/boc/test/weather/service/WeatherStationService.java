package com.boc.test.weather.service;

import com.boc.test.weather.dto.*;
import com.boc.test.weather.entity.WeatherStation;
import com.boc.test.weather.exception.RecordNotFoundException;
import com.boc.test.weather.repository.WeatherStationRepository;
import com.boc.test.weather.utils.IServiceHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service()
public class WeatherStationService implements IServiceHelper {

    private static final Logger logger =
            LoggerFactory.getLogger(WeatherStationService.class.getCanonicalName());

    @Autowired
    private WeatherStationRepository weatherStationRepository;

    public ResultBean<Object> findById(String id) {
        Optional<WeatherStation> ws = weatherStationRepository.findById(Long.parseLong(id));
        if (!ws.isPresent()) {
            throw new RecordNotFoundException("Requested resource not found!");
        }
        WeatherStationDetailDTO wsDetailDTO = new WeatherStationDetailDTO();
        copyPropertiesIgnoreNull(ws.get(), wsDetailDTO);
        return setResultBeanSuccessContent(HttpStatus.OK.value(), wsDetailDTO);
    }

    public ResultBean<Object> findAll(PaginationRequest pRequest) {
        logger.info("Calling WeatherStationService.findAll()");
        final int page = pRequest.getPage();
        final int max = pRequest.getMax();
        final String order = pRequest.getOrder();
        final String sort = pRequest.getSort();
        final Page<WeatherStation> wsPage =
                weatherStationRepository.findAll(createPageRequest(page - 1, max, order, sort));
        return setResultBeanSuccessContent(
                HttpStatus.OK.value(), returnListOfFoundRecords(wsPage));
    }

    public ResultBean<Object> filter(WeatherStationFilter wSB) {
        logger.info("Calling WeatherStationService.filter()");
        String appendedStartDate = wSB.getStartDate() + " 01:00:00.00000000";
        String appendedEndDate = wSB.getEndDate() + " 01:00:00.00000000";
        Timestamp startDate = Timestamp.valueOf(appendedStartDate);
        Timestamp endDate = Timestamp.valueOf(appendedEndDate);
        final int page = wSB.getPage().getPage();
        final int max = wSB.getPage().getMax();
        final String order = wSB.getPage().getOrder();
        final String sort = wSB.getPage().getSort();
        final Page<WeatherStation> wsPage = weatherStationRepository.findAllByDateGreaterThanEqualAndDateLessThanEqual(
                startDate, endDate, createPageRequest(page - 1, max, order, sort));
        return setResultBeanSuccessContent(
                HttpStatus.OK.value(), returnListOfFoundRecords(wsPage));
    }

    private WeatherStationListDTO returnListOfFoundRecords(Page<WeatherStation> wsPage) {
        final List<WeatherStation> wsList = wsPage.getContent();
        final List<WeatherStationDTO> wsDTOList = new LinkedList<>();
        for (WeatherStation ws : wsList) {
            WeatherStationDTO wsDTO = new WeatherStationDTO();
            copyPropertiesIgnoreNull(ws, wsDTO);
            wsDTOList.add(wsDTO);
        }
        final int pagesCount = wsPage.getTotalPages();
        final long itemsCount = wsPage.getTotalElements();
        WeatherStationListDTO weatherStationListDTO = new WeatherStationListDTO();
        MetaData metaData = new MetaData(itemsCount, pagesCount);
        weatherStationListDTO.setStations(wsDTOList);
        weatherStationListDTO.setMetaData(metaData);
        return weatherStationListDTO;
    }
}
