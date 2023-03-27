package com.jetbrains.internship.wt.plugin.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil
import org.jetbrains.annotations.NotNull

@State(
    name = "com.jetbrains.internship.wt.plugin.settings.LinksLibrarySettingsState",
    storages = [Storage("LinksLibrarySettingsState.xml")]
)
class LinksLibrarySettingsState: PersistentStateComponent<LinksLibrarySettingsState> {
    var openInInternalBrowser: Boolean = true
    var buttonsDescription: List<String> = arrayListOf("JetBrains", "Best plugin")
    var buttonsUrl: List<String>  = arrayListOf(
        "https://www.jetbrains.com",
        "https://github.com/BagritsevichStepan/chatGPT-solution-generator-intellij-plugin"
    )

    companion object {
        fun getInstance(): LinksLibrarySettingsState =
            ApplicationManager.getApplication().getService(LinksLibrarySettingsState::class.java)
    }

    override fun getState() = this

    override fun loadState(@NotNull state: LinksLibrarySettingsState) {
        XmlSerializerUtil.copyBean(state, this)
    }
}