pipeline {
   agent any
   
   stages {
      stage('Checkout') {
         steps {
            // Dynamically check out the current branch or specify the correct branch name
            git branch: (env.BRANCH_NAME ?: 'main'), url: 'URL_TO_YOUR_GIT_REPOSITORY'
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
            sh 'javac -cp classes -d test-classes book_junitTest/src/BookTest.java'

            //run Junit Test
            sh 'java -cp test-classes:classes org.junit.runner.JUnitCore book_junitTest.src.BookTest'
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
