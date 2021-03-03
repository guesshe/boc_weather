package com.boc.test.weather;

import com.boc.test.weather.controller.WeatherStationControllerIntegrationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        WeatherStationControllerIntegrationTest.class
})
public class ApplicationIntegrationTest {}
