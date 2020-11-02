def call(Map stageParams) {
 
    env.giturl=stageParams.giturl
    env.currentBldNumber=stageParams.currentBldNumber
    env.lastBldID=stageParams.lastBldID    
    env.branch_version=stageParams.branch_version    
    env.notify=stageParams.notify
    
    echo giturl
    echo currentBldNumber
    echo lastBldID
    echo branch_version
    def returnStatus = sh(script: '/opt/deploy/continuous-integration/acp/acp-builddiff-prod_v2', returnStdout: true)
}
