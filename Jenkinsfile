node {
   
   stage('Compile') {
       withMaven(jdk: 'jdk11', maven: 'maven3') {
        sh 'mvn compile'
     }
   }

   stage('Unit Testing') {
       withMaven(jdk: 'jdk11', maven: 'maven3') {
        sh 'mvn test'
     }
   }

      stage('Package') {
       withMaven(jdk: 'jdk11', maven: 'maven3') {
        sh 'mvn package'
     }
   }
   
   stage('Puslish Test Report'){
       junit 'target/**/*.xml'
   }
   
   stage('Archive Artifact') {
       archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false
   }
   stage('Email Notification') {
       emailext attachLog: true, body: '', subject: 'Build Sucessful', to: 'atin.singh@pragra.co'
   }


}