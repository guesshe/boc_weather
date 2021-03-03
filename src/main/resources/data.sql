DROP TABLE WEATHER_STATION IF EXISTS;

CREATE TABLE WEATHER_STATION  (
    ID INT NOT NULL IDENTITY PRIMARY KEY,
    Station_Name VARCHAR(100),
    Province VARCHAR(10),
    Date TIMESTAMP,
    Mean_Temp DOUBLE,
    Highest_Monthly_Maxi_Temp DOUBLE,
    Lowest_Monthly_Min_Temp DOUBLE
);

INSERT INTO WEATHER_STATION (
    Station_Name,
    Province,
    Date,
    Mean_Temp,
    Highest_Monthly_Maxi_Temp,
    Lowest_Monthly_Min_Temp
)  select Station_Name,Province,convert(parseDateTime(Date,'dd/mm/yyyy'),timestamp) as Date,Mean_Temp,Highest_Monthly_Maxi_Temp, Lowest_Monthly_Min_Temp from CSVREAD('classpath:/input/eng-climate-summary.csv', null);