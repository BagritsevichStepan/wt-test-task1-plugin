package com.jetbrains.internship.wt.plugin.settings

import com.intellij.openapi.options.Configurable
import org.jetbrains.annotations.Nls
import org.jetbrains.annotations.Nullable
import javax.swing.JComponent


class LinksLibraryConfigurable: Configurable {
    private var settingsComponent: LinksLibrarySettingsComponent? = null

    @Nls(capitalization = Nls.Capitalization.Title)
    override fun getDisplayName() = "Links Library"

    @Nullable
    override fun createComponent(): JComponent? {
        settingsComponent = LinksLibrarySettingsComponent()
        return settingsComponent?.getPanel()
    }

    override fun isModified(): Boolean {
        val settings = getSettings()
        return !(settings.openInInternalBrowser == settingsComponent?.openInInternalBrowser?.isSelected &&
                        settings.buttonsDescription == settingsComponent?.getButtonsDescription() &&
                        settings.buttonsUrl == settingsComponent?.getButtonsUrl())
    }

    override fun apply() {
        val settings = getSettings()
        settings.openInInternalBrowser = settingsComponent?.openInInternalBrowser?.isSelected!!
        settings.buttonsDescription = settingsComponent?.getButtonsDescription()!!
        settings.buttonsUrl = settingsComponent?.getButtonsUrl()!!
    }

    private fun getSettings() = LinksLibrarySettingsState.getInstance()

    override fun reset() {
        settingsComponent?.setDefault()
    }

    override fun disposeUIResources() {
        settingsComponent = null
    }
}