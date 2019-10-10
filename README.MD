### What is this repository
This is a POC repository created to test pull wso2 project to pull from git and run through jenkins pipeline, execute cucumber test and deploy artifacts to JFrog artifactory.

### Technologies Used
+ WSO2 EI
+ WSO2 Enterprise Integrator
+ Cucumber
+ Gradle
+ Jenkins
+ JFrog

### How to execute
Create and deploy artifacts to prod environment with prod configurations
`./gradlew buildAndDeploy -Penvironment=prod` 
Create and deploy artifacts to local environment with local configurations
`./gradlew buildAndDeploy -Penvironment=local` 