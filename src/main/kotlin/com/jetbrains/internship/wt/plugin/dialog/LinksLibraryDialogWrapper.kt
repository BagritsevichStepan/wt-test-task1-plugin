package com.jetbrains.internship.wt.plugin.dialog

import com.intellij.ide.BrowserUtil
import com.intellij.ide.HelpTooltip
import com.intellij.openapi.fileEditor.impl.HTMLEditorProvider
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import java.awt.FlowLayout
import java.awt.GridLayout
import java.net.URI
import javax.swing.*


class LinksLibraryDialogWrapper(private var project: Project?,
                                private var openInInternalBrowser: Boolean,
                                private var buttonsText: List<String>,
                                private var urls: List<String>):DialogWrapper(true) {

    companion object {
        private const val COUNT_BUTTONS_IN_ROW = 2
        private const val GAP = 4

        private fun getDomainName(url: String): String? {
            return URI(url).host
        }
    }

    init {
        title = "Links Library Demo"
        init()
    }

    override fun createCenterPanel(): JComponent {
        val gridPanel = JPanel(GridLayout(
            0, COUNT_BUTTONS_IN_ROW, GAP, GAP))
        for (i in buttonsText.indices) {
            val button = JButton(buttonsText[i])
            HelpTooltip().setDescription(getDomainName(urls[i])).installOn(button)
            button.addActionListener {
                if (urls[i] != null && urls[i].isNotBlank()) {
                    if (openInInternalBrowser) {
                        HTMLEditorProvider.openEditor(
                            project!!,
                            "World Wild Web",
                            urls[i],
                            null
                        )
                    } else {
                        BrowserUtil.browse(urls[i])
                    }
                    clear()
                    this.close(OK_EXIT_CODE)
                }
            }
            gridPanel.add(button)
        }

        val flowPanel = JPanel(FlowLayout(FlowLayout.LEFT))
        flowPanel.add(gridPanel)
        return flowPanel
    }

    private fun clear() {
        project = null;
    }
}