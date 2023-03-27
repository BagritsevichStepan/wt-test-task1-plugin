package com.jetbrains.internship.wt.plugin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.jetbrains.internship.wt.plugin.dialog.LinksLibraryDialogWrapper
import com.jetbrains.internship.wt.plugin.settings.LinksLibrarySettingsState

class LinksLibraryAction: AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val settings = LinksLibrarySettingsState.getInstance()
        LinksLibraryDialogWrapper(
            e.project!!,
            settings.openInInternalBrowser,
            settings.buttonsDescription,
            settings.buttonsUrl,
        ).show()
    }

    override fun update(e: AnActionEvent) {
        val project: Project? = e.project
        e.presentation.isEnabledAndVisible = project != null
    }
}