def call(Map stageParams) {
    
  env.targetDir = "${stageParams.targetDir}"
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.branch ]],
        userRemoteConfigs: [[ url: stageParams.url ]],
        extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: env.targetDir]],
    ])
}
