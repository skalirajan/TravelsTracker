def call(Map stageParams) {
    
    env.giturl=stageParams.giturl
    env.currentBldNumber=stageParams.currentBldNumber
    env.notify=stageParams.notify
    env.branch_name=stageParams.branch_name
    env.commitHash=stageParams.commitHash
    env.branch_version=stageParams.branch_version    
  
    echo giturl
    echo currentBldNumber
    echo notify
    echo branch_name
    echo commitHash
    echo branch_version
  
    def returnStatus = sh(script: '/opt/deploy/continuous-integration/acp/acp-apply-tag_v2', returnStdout: true)
}
