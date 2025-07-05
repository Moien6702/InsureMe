pipeline {
  agent any

  environment {
    DOCKER_IMAGE = "yourdockerhubusername/policy-service"
    DOCKER_CREDENTIALS_ID = "dockerhub-creds"
    KUBECONFIG_CREDENTIALS_ID = "kubeconfig-creds"
  }

  stages {
    stage('Clone') {
      steps {
        git 'https://github.com/your-username/InsureMe.git'
      }
    }

    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }

    stage('Docker Build & Push') {
      steps {
        withCredentials([usernamePassword(
          credentialsId: "${DOCKER_CREDENTIALS_ID}",
          usernameVariable: 'USERNAME',
          passwordVariable: 'PASSWORD'
        )]) {
          sh '''
            docker build -t $DOCKER_IMAGE .
            echo $PASSWORD | docker login -u $USERNAME --password-stdin
            docker push $DOCKER_IMAGE
          '''
        }
      }
    }

    stage('Deploy to Kubernetes') {
      steps {
        withCredentials([file(
          credentialsId: "${KUBECONFIG_CREDENTIALS_ID}",
          variable: 'KUBECONFIG'
        )]) {
          sh 'kubectl apply -f kubernetes/policy-service/'
        }
      }
    }
  }
}
