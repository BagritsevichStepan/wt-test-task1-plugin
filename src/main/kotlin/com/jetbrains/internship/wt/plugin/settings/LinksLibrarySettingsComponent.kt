package com.jetbrains.internship.wt.plugin.settings

import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.*
import kotlin.streams.toList

class LinksLibrarySettingsComponent {
    private val mainPanel: JPanel
    val openInInternalBrowser: JBCheckBox
    private val buttonsDescription: List<JBTextField>
    private val buttonsUrl: List<JBTextField>

    init {
        val settings = getSettings()

        openInInternalBrowser = JBCheckBox(
            "Open in internal browser",
            settings.openInInternalBrowser
        )

        buttonsDescription = ArrayList(settings.buttonsDescription.stream()
            .map { JBTextField(it) }.toList())
        buttonsUrl = ArrayList(settings.buttonsUrl.stream()
            .map { JBTextField(it) }.toList())

        val formBuilder = FormBuilder.createFormBuilder()
            .addComponent(openInInternalBrowser)
        for (i in buttonsDescription.indices) {
            formBuilder
                .addLabeledComponent("Button ${i + 1}. Description ", buttonsDescription[i])
                .addLabeledComponent("Button ${i + 1}. Link ", buttonsUrl[i])
        }

        mainPanel = formBuilder.addComponentFillVertically(JPanel(), 0).panel
    }

    fun setDefault() {
        val settings = getSettings()
        openInInternalBrowser.isSelected = settings.openInInternalBrowser
        for (i in buttonsDescription.indices) {
            buttonsDescription[i].text = settings.buttonsDescription[i]
            buttonsUrl[i].text = settings.buttonsUrl[i]
        }
    }

    fun getButtonsDescription(): List<String> = buttonsDescription.stream().map { it.text }.toList()

    fun getButtonsUrl(): List<String> = buttonsUrl.stream().map { it.text }.toList()

    fun getPanel() = mainPanel

    private fun getSettings() = LinksLibrarySettingsState.getInstance()
}