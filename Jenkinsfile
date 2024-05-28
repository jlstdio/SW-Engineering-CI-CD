pipeline {
   agent any
   
   stages {
      stage('Checkout') {
         steps {
            // Dynamically check out the current branch or specify the correct branch name
            checkout scm
         }
      }
      
      stage('Build') {
         steps {
            // Compile the Java code
            sh 'javac -encoding UTF-8 -d classes book_junitTest/src/Book.java'
         }
      }
      
      stage('Test') {
         steps {
            // classpath configuration for JUnit Test
            classpath = "${env.WORKSPACE}/classes:${env.WORKSPACE}/test-classes"
   
            //run Junit Test
            sh "java -cp ${classpath} org.junit.runner.JUnitCore book_junitTest.BookTest > test_results.txt"
         }
      }
      
      post {
         always {
            // Archive test results
            archiveArtifacts 'test_results.txt'
         }
         failure {
            echo 'Build or test failed'
         }
         success {
            echo 'Build and test succeeded'
         }
      }
   }
}
