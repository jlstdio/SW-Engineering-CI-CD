pipeline {
   agent any
   
   environment {
       // Define classpath in the environment section dynamically based on the OS & Personal Environment
       CLASSPATH = "${isUnix() ? '${WORKSPACE}/classes:${WORKSPACE}/lib/*:/Users/joonheelee/eclipse/plugins/junit-platform-console-standalone-1.7.1.jar' : '${WORKSPACE}\\classes;${WORKSPACE}\\lib\\*;C:\\Users\\joonheelee\\eclipse\\plugins\\junit-platform-console-standalone-1.7.1.jar'}"
   }

   stages {
      stage('Checkout') {
         steps {
            checkout scm
         }
      }
      
      stage('Build For Book') {
         steps {
            script {
                if (isUnix()) {
                    sh 'javac -encoding UTF-8 -d ${WORKSPACE}/classes book_junitTest/src/book_junitTest/Book.java'                    
                } else {
                    bat 'javac -encoding UTF-8 -d ${WORKSPACE}\\classes book_junitTest\\src\\book_junitTest\\Book.java'
                }
            }
         }
      }
      
      stage('Test For Book') {
         steps {
            script {
                if (isUnix()) {
                    sh 'java -cp ${CLASSPATH} org.junit.platform.console.ConsoleLauncher --scan-class-path --reports-dir=${WORKSPACE}/test-results > ${WORKSPACE}/test_results_for_book.txt'
                } else {
                    bat 'java -cp ${CLASSPATH} org.junit.platform.console.ConsoleLauncher --scan-class-path --reports-dir=${WORKSPACE}\\test-results > ${WORKSPACE}\\test_results_for_book.txt'
                }
            }
         }
      }

      stage('Build For BookPerformance') {
         steps {
            script {
                if (isUnix()) {
                    sh 'javac -encoding UTF-8 -d ${WORKSPACE}/classes book_junitTest/src/book_junitTest/BookPerformance.java'
                } else {
                    bat 'javac -encoding UTF-8 -d ${WORKSPACE}\\classes book_junitTest\\src\\book_junitTest\\BookPerformance.java'
                }
            }
         }
      }
      
      stage('Test For BookPerformance') {
         steps {
            script {
                if (isUnix()) {
                    sh 'java -cp ${CLASSPATH} org.junit.platform.console.ConsoleLauncher --scan-class-path --reports-dir=${WORKSPACE}/test-results > ${WORKSPACE}/test_results_for_bookperformance.txt'
                } else {
                    bat 'java -cp ${CLASSPATH} org.junit.platform.console.ConsoleLauncher --scan-class-path --reports-dir=${WORKSPACE}\\test-results > ${WORKSPACE}\\test_results_for_bookperformance.txt'
                }
            }
         }
      }
   }
   
   post {
      always {
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
