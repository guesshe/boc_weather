# boc_weather
assignment from boc

# Nodejs and NPM is required to run the frontend
sudo apt-get install npm

sudo apt-get install nodejs

# To run integration tests
./gradlew clean test -x buildReactApp -i
test report can be accessed at <project_root>/build/reports/tests/test/index.html

# To run this application in bundled mode
./gradlew bootRun

# To only run the backend. Note! If you run backend only mode, you need to clone the boc_weather_frontend repo to access the frontend, please follow instructions on that project
./gradlew bootRun -x buildReactApp

# To access frontend 
http://localhost:8090

# Using following if you run the project in backend only mode or want an isolated frontend dev env
git clone git@github.com:guesshe/boc_weather_frontend.git
