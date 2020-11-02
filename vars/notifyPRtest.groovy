def call(Map stageParams) {
 
    //node ('master') {
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
    env.action=stageParams.action
    env.status=stageParams.status
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
        export action="${action}"
        export status="${status}"
        export text="${text}"
        echo $destinationRepositoryOwner
        echo $destinationRepositoryName
        echo $sourceBranch
        echo $srcLatestCommit
        echo $pullRequestId        
        echo $JobURL
        echo $JobName
        echo $BuildNO
        echo $BuildJobURL
        echo $message
        echo $action
        echo $status
        echo $text
        /opt/deploy/continuous-integration/notifyPR            
     '''  
    //}
}
