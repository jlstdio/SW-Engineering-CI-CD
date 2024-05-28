pipeline {
   agent any
   
   stages {
      stage('Checkout') {
         steps {
            Checkout scm
         }
      }
      
      stage('Build') {
         steps {
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
            // 테스트 결과 파일을 저장하기 위해 아카이브
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