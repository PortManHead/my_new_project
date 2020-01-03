package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.powerShell
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'Build'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("Build")) {
    params {
        add {
            param("my_new_parameter", "HOWDY!")
        }
    }

    expectSteps {
    }
    steps {
        insert(0) {
            script {
                scriptContent = "call my_cmd.bat"
            }
        }
        insert(1) {
            powerShell {
                name = "PowerShell"
                scriptMode = script {
                    content = "${'$'}env:computername"
                }
            }
        }
        insert(2) {
            script {
                enabled = false
                scriptContent = "time /t"
                dockerImage = "my_container"
                dockerImagePlatform = ScriptBuildStep.ImagePlatform.Windows
            }
        }
    }
}
