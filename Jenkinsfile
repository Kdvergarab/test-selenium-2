pipeline {
    agent {
        docker {
            image 'maven:3.8.7-eclipse-temurin-8'
            args '-v $HOME/.m2:/root/.m2'
        }
    }
    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: "*/main"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [],
                userRemoteConfigs: [[credentialsId: 'github-credentials', url: "https://github.com/johanfabi/test-selenium"]]])
            }
        }
        stage('Test') {
            steps {
                sh 'echo $TAGS'
                sh 'mvn -v'
                sh '''
                    mvn clean test -Dtest="MainRun"  -Dcucumber.filter.tags="$TAGS"
                '''
            }
        }
    }
}