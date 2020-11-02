def call(Map stageParams) {
 
    
    env.destinationRepositoryOwner = stageParams.destinationRepositoryOwner
    env.destinationRepositoryName = stageParams.destinationRepositoryName
    env.sourceBranch = stageParams.sourceBranch
    env.srcLatestCommit = stageParams.srcLatestCommit
    env.pullRequestId = stageParams.pullRequestId
    env.text=stageParams.text
    env.JobName=stageParams.JobName
    env.JobURL=stageParams.BUILD_URL
    env.BuildNO=stageParams.BUILD_NUMBER
    env.BuildJobURL=stageParams.BUILD_URL
    env.message=stageParams.message
    sh '''
        export destinationRepositoryName="${destinationRepositoryName}"        
        export destinationRepositoryOwner="${destinationRepositoryOwner}"        
        export sourceBranch="${sourceBranch}"
        export srcLatestCommit="${srcLatestCommit}"
        export pullRequestId="${pullRequestId}"        
        export JobName="${JobName}"
        export JobURL="${JobURL}"
        export BuildNO="${BuildNO}"
        export BuildJobURL=${BuildJobURL}
        export UpdateActivities=1
        export message="${message}"
        export text="${text}"
        /opt/deploy/continuous-integration/central/notifyPRComment/notifyPRComment            
     '''  
}
