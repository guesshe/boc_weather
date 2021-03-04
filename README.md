# boc_weather
assignment from boc

# Nodejs and NPM is required to run the frontend
sudo apt-get install npm
sudo apt-get install nodejs

# To run integration tests
./gradlew clean test -x buildReactApp -i

# To run this application in bundled mode
./gradlew bootRun

# To only run the backend
./gradlew bootRun -x buildReactApp

# To access frontend 
http://localhost:8090

# Using following if you want an isolated frontend dev env
git clone git@github.com:guesshe/boc_weather_frontend.git