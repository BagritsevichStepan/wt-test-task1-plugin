# Link Library Plugin
The repository contains a solution of the test task in [WebTeam](https://internship.jetbrains.com/projects/1332/).

The plugin impelements Link Library for IntelliJ IDEA, you can save your links and open them directly in the editor.

*Implemented with Kotlin*

## Links
* [Usage](#usage)
* [Features](#features)
  1. [Settings](#settings)
  2. [Link Preview](#link-preview)
  3. [AutoClose](#autoclose)
* [Project Structure](#project-structure)
  1. [Action](#action)
  2. [Dialog Window](#dialog-window)
  3. [Settings Window](#settings-window)

## Usage

https://user-images.githubusercontent.com/43710058/227982422-32d93fc1-d87e-46e6-bcfd-d4720cc9445b.mp4

To run the plugin use the command `./gradlew runIde` in the Terminal or open the project in your IDEA and then press the button `Run plugin`.

The plugin is located by the path: Tools -> Internal actions -> UI -> Demos -> Links Library Demo.


## Features

### Settings
To setup the plugin, open Prefences -> Tools -> Links Library.

You can customize the description and links of the buttons. Also you can choose which browser will be used to open your website - the default or internal.

![Prefences](https://github.com/BagritsevichStepan/wt-test-task1-plugin/blob/main/images/2.png)

### Link Preview
When you hover over the button to open the site, the plugin prompts you to which domain you will go.

![Button Hover](https://github.com/BagritsevichStepan/wt-test-task1-plugin/blob/main/images/1.png)

### AutoClose

When you click on the button to open the site you do not need to close the plugin window - it closes automatically.

## Project Structure

The project has three main points: the class that implements action, the dialog window class and the plugin settings classes.

![Button Hover](https://github.com/BagritsevichStepan/wt-test-task1-plugin/blob/main/images/3.png)

### Action

According to the [documentation](https://plugins.jetbrains.com/docs/intellij/working-with-custom-actions.html#registering-an-action-with-the-new-action-form), the plugin must have a class that implements the `AnAction` Interface. This class is `LinksLibraryAction`, it has the method `update` that implements the code that enables or disables an action and the method `actionPerformed` that implements the code that executes when an action is invoked by the user (in this case - opens the dialog window).

The action must also be registered in the `plugin.xml`:

```
<action id="com.jetbrains.internship.wt.plugin.LinksLibraryAction"
        class="com.jetbrains.internship.wt.plugin.LinksLibraryAction" text="Links Library Demo"
        description="Stores links">
    <synonym text="Link"/>
    <add-to-group group-id="Internal.UI.Demos" anchor="last"/>
</action>
```

Here you can also configure the plugin. In addition to configuring the plugin group id, I also added the ability to search for it by the name `Link`.

![Button Hover](https://github.com/BagritsevichStepan/wt-test-task1-plugin/blob/main/images/4.png)

### Dialog Window

According to the [documentation](https://plugins.jetbrains.com/docs/intellij/dialog-wrapper.html) to implement the dialog window, the plugin must have a class that inherits the class `DialogWrapper` and implements the method `createCenterPanel`. This class is `LinksLibraryDialogWrapper` in the package `dialog`.

### Settings Window

To implement the settings, the plugin contains three classes `LinksLibrarySettingsState` (implements `PersistentStateComponent` Interface), `LinksLibrarySettingsComponent` and `LinksLibraryConfigurable` (implements `Configurable` Interface) in package `settings`.

[Settings Tutorial](https://plugins.jetbrains.com/docs/intellij/settings-tutorial.html#creating-the-appsettingsconfigurable-implementation)

Also the settings-classes must be registered in the file `plugin.xml`:
```
<applicationService serviceImplementation="com.jetbrains.internship.wt.plugin.settings.LinksLibrarySettingsState"/>
<applicationConfigurable
        parentId="tools"
        instance="com.jetbrains.internship.wt.plugin.settings.LinksLibraryConfigurable"
        id="com.jetbrains.internship.wt.plugin.settings.LinksLibraryConfigurable"
        displayName="Links Library"/>
```





