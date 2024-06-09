pipeline {
   agent any
   
   environment {
       // Define classpath in the environment section dynamically based on the OS
       CLASSPATH = "${isUnix() ? '${WORKSPACE}/classes:${WORKSPACE}/lib/*:/Users/joonheelee/eclipse/plugins/junit-platform-console-standalone-1.7.1.jar' : '${WORKSPACE}\\classes;${WORKSPACE}\\lib\\*;C:\\Users\\joonheelee\\eclipse\\plugins\\junit-platform-console-standalone-1.7.1.jar'}"
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
            script {
                if (isUnix()) {
                    // Compile the Java code on Unix/Linux
                    sh 'javac -encoding UTF-8 -d ${WORKSPACE}/classes book_junitTest/src/book_junitTest/Book.java'
                } else {
                    // Compile the Java code on Windows
                    bat 'javac -encoding UTF-8 -d ${WORKSPACE}\\classes book_junitTest\\src\\book_junitTest\\Book.java'
                }
            }
         }
      }
      
      stage('Test') {
         steps {
            script {
                if (isUnix()) {
                    // Run JUnit Test on Unix/Linux
                    sh 'java -cp ${CLASSPATH} org.junit.platform.console.ConsoleLauncher --scan-class-path --reports-dir=${WORKSPACE}/test-results > ${WORKSPACE}/test_results.txt'
                } else {
                    // Run JUnit Test on Windows
                    bat 'java -cp ${CLASSPATH} org.junit.platform.console.ConsoleLauncher --scan-class-path --reports-dir=${WORKSPACE}\\test-results > ${WORKSPACE}\\test_results.txt'
                }
            }
         }
      }
   }
   
   post {
      always {
         // Archive test results and artifacts, dynamically adapted for OS
         archiveArtifacts artifacts: "${isUnix() ? '**/test-results/*.xml, test_results.txt' : '**\\test-results\\*.xml, test_results.txt'}", onlyIfSuccessful: true
      }
      failure {
         echo 'Build or test failed'
      }
      success {
         echo 'Build and test succeeded'
      }
   }
}