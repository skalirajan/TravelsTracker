def call(Map stageParams) {
 
    env.git_url=stageParams.git_url
    env.currentBldNumber=stageParams.currentBldNumber
    env.lastBldID=stageParams.lastBldID    
    env.branch_version=stageParams.branch_version    
    env.notify=stageParams.notify
    
    echo git_url
    echo currentBldNumber
    echo lastBldID
    echo branch_version
    def returnStatus = sh(script: '/opt/deploy/continuous-integration/acp/acp-builddiff-prod', returnStdout: true)
}
