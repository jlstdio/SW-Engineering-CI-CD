pipeline {
   agent any
   
   environment {
       // Define classpath in the environment section
       CLASSPATH = "${WORKSPACE}/classes:${WORKSPACE}/test-classes"
   }

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
            sh 'javac -encoding UTF-8 -d ${WORKSPACE}/classes book_junitTest/src/book_junitTest/Book.java'
         }
      }
      
      stage('Test') {
         steps {
            // Run JUnit Test using the defined environment classpath
            sh "java -cp ${env.CLASSPATH} org.junit.runner.JUnitCore book_junitTest.BookTest > ${WORKSPACE}/test_results.txt"

         }
      }
   }
   
   post {
      always {
         // Archive test results
         archiveArtifacts artifacts: 'test_results.txt', onlyIfSuccessful: true
      }
      failure {
         echo 'Build or test failed'
      }
      success {
         echo 'Build and test succeeded'
      }
   }
}
