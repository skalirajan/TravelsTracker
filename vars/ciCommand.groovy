def call(Map stageParams) {

  env.buildworkspace=stageParams.buildworkspace
  env.command=stageParams.command

  def estatus=sh (script: "$buildworkspace/$command", returnStatus: true)
  if (estatus != 0)
  {
      echo "${command} : Command Failed"
      sh "exit 1"
  }
}
