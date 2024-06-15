pipeline {
   agent any
   
   environment {
       // Define classpath in the environment section dynamically based on the OS
       CLASSPATH = "${isUnix() ? '${WORKSPACE}/classes:${WORKSPACE}/lib/*:/Users/gimdaegyeom/eclipse/java-2024-03/Eclipse.app/Contents/Eclipse/plugins/org.eclipse.equinox.launcher_1.6.700.v20240213-1244.jar' : '${WORKSPACE}\\classes;${WORKSPACE}\Users/gimdaegyeom/eclipse/java-2024-03/Eclipse.app/Contents/Eclipse/plugins/org.eclipse.equinox.launcher_1.6.700.v20240213-1244.jar'}"
   }

   stages {
      stage('Checkout') {
         steps {
            checkout scm
         }
      }
      
      stage('Build For Book.java') {
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
      
      stage('Test') {
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

      stage('Build For BookPerformance.java') {
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
      
      stage('Test') {
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
