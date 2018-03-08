# Java CI/CD pipeline example with CircleCI

The goal of this project is to show a simple CD/CI pipeline of a Spring Boot java application using 
CircleCI.

The java application is a simple Spring Boot web app, with a single web page.

Below there is an overview of the pipeline:

```
BUILD -----> RUN INTEGRATION TESTS -----> DEPLOY*
```
\* not implemented yet

## Jobs
A brief description of what we wanted to achieve with each goal.

### Build
The build job is responsible to use gradle to build the project. During the build, gradle will also 
run the unit tests and fail the job if any test fails.

The output of the build job is a executable jar file.

### Run Integration Tests
In this job, we build a docker image with the generated jar file ready to run the web app. After 
starting the docker instance with the application, the job will start another container with the 
integration tests in the same docker network of the first container. After that, we'll use gradle to 
invoke the integration tests from the second container, running them against the application running
on the first container.

If any of the integration test fails, the job fails.  

###  Deploy
The deploy job will deploy the web application to Heroku, where it will be accessible to anyone.
This job has not been implemented yet.