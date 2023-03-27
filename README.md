# Link Library Plugin
The repository contains a solution of the test task in [WebTeam](https://internship.jetbrains.com/projects/1332/).

The plugin impelements Link Library for IntelliJ IDEA, you can save your links and open them directly in the editor.

*Implemented with Kotlin*

## Links
* [Usage](#usage)
* [Features](#features)
  1. [Settings](#settings)
  2. [Button Hover](#button-hover)
  3. [AutoClose](#autoclose)
* [Project Structure](#project-structure)

## Usage

https://user-images.githubusercontent.com/43710058/227982422-32d93fc1-d87e-46e6-bcfd-d4720cc9445b.mp4

To run the plugin use the command `./gradlew runIde` in the Terminal or open the project in your IDEA and then press the button `Run plugin`.

The plugin is located by the path: Tools -> Internal actions -> UI -> Demos -> Links Library Demo.


## Features

### Settings
To setup the plugin, open Prefences -> Tools -> Links Library.

You can customize the description and links of the buttons. Also you can choose which browser will be used to open your website - the default or internal.

![Prefences](https://github.com/BagritsevichStepan/wt-test-task1-plugin/blob/main/images/2.png)

### Button Hover
When you hover over the button to open the site, the plugin prompts you to which domain you will go.

![Button Hover](https://github.com/BagritsevichStepan/wt-test-task1-plugin/blob/main/images/1.png)

### AutoClose

When you click on the button to open the site you do not need to close the plugin window - it closes automatically.

## Project Structure

