def call(Map stageParams) {
 
    env.destinationRepositoryOwner=stageParams.destinationRepositoryOwner
    env.destinationRepositoryName=stageParams.destinationRepositoryName
    env.repoType=stageParams.repoType    
    env.pullRequestId=stageParams.pullRequestId    
    env.filnm=stageParams.filnm
  
  	if (repoType == "singlerepo"){
      		def returnStatus = sh(script: '/opt/deploy/continuous-integration/central/prApprove.py -ro ${destinationRepositoryOwner} -rn ${destinationRepositoryName} -pr ${pullRequestId};', returnStdout: true)
      		print returnStatus
	} else if (repoType == "multirepo") {
            def props = readJSON file: filnm
   			for (ii = 0; ii < props['REPO'].size(); ii++){
					env.pullRequestIDvalue=props['REPO'][ii]['pullRequestId']
                    env.destinationRepositoryOwner=props['REPO'][ii]['destinationRepositoryOwner']
					env.destinationRepositoryName=props['REPO'][ii]['destinationRepositoryName']
              		def returnStatus = sh(script: '/opt/deploy/continuous-integration/central/prApprove.py -ro ${destinationRepositoryOwner} -rn ${destinationRepositoryName} -pr ${pullRequestIDvalue};', returnStdout: true)
              		print returnStatus
				}
	}
}
