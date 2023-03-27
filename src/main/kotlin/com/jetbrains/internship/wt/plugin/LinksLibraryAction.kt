package com.jetbrains.internship.wt.plugin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.jetbrains.internship.wt.plugin.dialog.LinksLibraryDialogWrapper
import com.jetbrains.internship.wt.plugin.settings.LinksLibrarySettingsState
import kotlin.streams.toList

class LinksLibraryAction: AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val settings = LinksLibrarySettingsState.getInstance()
        LinksLibraryDialogWrapper(
            e.project!!,
            settings.openInInternalBrowser,
            settings.buttonsUrls.keys.stream().toList(),
            settings.buttonsUrls.values.stream().toList()
        ).show()
    }

    override fun update(e: AnActionEvent) {
        val project: Project? = e.project
        e.presentation.isEnabledAndVisible = project != null
    }
}