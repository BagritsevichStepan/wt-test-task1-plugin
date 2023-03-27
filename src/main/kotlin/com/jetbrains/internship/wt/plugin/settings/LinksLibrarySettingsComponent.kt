package com.jetbrains.internship.wt.plugin.settings

import com.intellij.openapi.roots.ui.whenTextModified
import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.components.JBList
import com.intellij.ui.components.JBTextField
import com.intellij.ui.components.fields.IntegerField
import com.intellij.util.ui.FormBuilder
import java.awt.Component
import javax.swing.*
import kotlin.streams.toList

class LinksLibrarySettingsComponent {
    private val mainPanel: JPanel
    val openInInternalBrowser: JBCheckBox
    private var buttonsDescription: List<JBTextField>
    private var buttonsUrl: List<JBTextField>

    init {
        val settings = getSettings()

        openInInternalBrowser = JBCheckBox(
            "Open in internal browser",
            settings.openInInternalBrowser
        )

        buttonsDescription = ArrayList(settings.buttonsUrls.keys.stream()
            .map { JBTextField(it) }.toList())
        buttonsUrl = ArrayList(settings.buttonsUrls.values.stream()
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
        openInInternalBrowser.isSelected = true
        val settings = getSettings()
        val descriptions = settings.buttonsUrls.keys.toList()
        val urls = settings.buttonsUrls.values.toList()
        for (i in buttonsDescription.indices) {
            buttonsDescription[i].text = descriptions[i]
            buttonsUrl[i].text = urls[i]
        }
    }

    fun getButtonsUrls(): Map<String, String> {
        return IntRange(0, buttonsDescription.size - 1)
            .associate { buttonsDescription[it].text to buttonsUrl[it].text }
    }

    fun getPanel() = mainPanel

    private fun getSettings() = LinksLibrarySettingsState.getInstance()
}