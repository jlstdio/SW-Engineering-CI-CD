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
            // Run JUnit Test using the defined environment classpath'
            junit 'book_junitTest/src/book_junitTest/BookTest.java' > ${WORKSPACE}/test_results.txt

            // JUnit 5 테스트 실행을 위한 classpath 설정
            // def classpath = "classes;lib/; Users/joonheelee/eclipse/plugins/junit-platform-console-standalone-1.7.1.jar" 
            // JUnit 5 테스트 실행
            // bat 'java -cp classes;lib/; /Users/joonheelee/eclipse/plugins/junit-platform-console-standalone-1.7.1.jar org.junit.platform.console.ConsoleLauncher --scan-classpath > test_results.txt'
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
