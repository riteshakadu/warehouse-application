pipeline{
	agent { 
        	label "Node-Ritesh"
    	}
	stages {
		stage ("Checkout code") {
			steps {
				checkout scmGit(branches: [[name: '${BRANCH_NAME}']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/riteshakadu/warehouse-application.git']])
			}
		}
		stage ("build code") {
			steps {
				sh "mvn package"
			}
		}
	}
}
