pipeline{

	agent any

	environment {
		DOCKERHUB_CREDENTIALS=credentials('developer-demo')
	}

	stages {

		stage('Build') {

			steps {
				sh 'docker build -t tejnal/springboot-k8s-app:latest .'
			}
		}

		stage('Login') {

			steps {
				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
			}
		}

		stage('Push') {

			steps {
				sh 'docker push tejnal/springboot-k8s-app:latest'
			}
		}
	}

	post {
		always {
			sh 'docker logout'
		}
	}

}
