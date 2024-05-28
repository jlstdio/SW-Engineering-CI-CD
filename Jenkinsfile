pipeline {
   agent any
   
   stages {
      stage('Checkout') {
         steps {
            // Checkout your source code from version control
            // For example, using Git:
            git 'https://github.com/your-repo.git'
         }
      }
      
      stage('Build') {
         steps {
            // Build your Java project
            // For example, using Maven:
            sh 'mvn clean package'
         }
      }
      
      stage('Test') {
         steps {
            // Run your tests
            // For example, using Maven:
            sh 'mvn test'
         }
      }
      
      stage('Deploy') {
         steps {
            // Deploy your application
            // For example, using Docker:
            sh 'docker build -t your-app .'
            sh 'docker run -d -p 8080:8080 your-app'
         }
      }
   }
}