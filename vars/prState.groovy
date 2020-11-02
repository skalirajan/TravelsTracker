def call(Map stageParams) {
 
    
    env.destinationRepositoryOwner = stageParams.destinationRepositoryOwner
    env.destinationRepositoryName = stageParams.destinationRepositoryName
    env.pullRequestId = stageParams.pullRequestId
    sh '''
        export destinationRepositoryName="${destinationRepositoryName}"
        export destinationRepositoryOwner="${destinationRepositoryOwner}"
        export pullRequestId="${pullRequestId}"
        echo $destinationRepositoryOwner
        echo $destinationRepositoryName
        echo $pullRequestId
     '''  
}
