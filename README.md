# MediMate - A medication reminder application

MediMate is an application where the user can input a list of medications they are currently using and set the time when each medication is taken. The app will alarm the user when it’s time to take a certain medication. The app is targeting smartphones running Android OS.

## Getting Started

Clone / Download the repository and open it using Android Studio. 
    
### Development environment 

The app is written entirely in Kotlin and uses the Gradle build system.

To build the app, use the gradlew build command or use "Import Project" in Android Studio. A canary or stable version >= 3.2 of Android Studio is required.

### Architecture

This app is built using:

    - Android Architectural Components
        - LiveData
        - Room
        - ViewModel
        - MVVM 
    - Dependency Injection
        - Koin
    - Testing frameworks
        - JUnit
        - Espresso
        - Roboelectric
        - Mockito
    - Utility
        - LiveEvent (https://github.com/hadilq/LiveEvent)

## Running the tests

Instrumentation tests are located under the "androidTest" folder. Run by right-clicking the folder and execute tests.
Unit tests are located under the "test" folder. Run by right-clicking the folder and execute tests.

## Authors

* **Niklas Poussu* - [npoussu](https://github.com/npoussu)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

