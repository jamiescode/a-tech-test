# Technical test

[![Build Status](https://github.com/jamiescode/a-tech-test/actions/workflows/build.yml/badge.svg)](https://github.com/jamiescode/a-tech-test/actions/workflows/build.yml)
[![Codebeat](https://codebeat.co/badges/c5e98b1c-6946-439b-b18d-de78bbf8149e)](https://codebeat.co/projects/github-com-jamiescode-a-tech-test-main)
[![CodeFactor](https://www.codefactor.io/repository/github/jamiescode/a-tech-test/badge)](https://www.codefactor.io/repository/github/jamiescode/a-tech-test)

[![Kotlin Version](https://img.shields.io/badge/Kotlin-2.0.x-blue.svg)](https://kotlinlang.org)
[![AGP](https://img.shields.io/badge/AGP-8.x-blue?style=flat)](https://developer.android.com/studio/releases/gradle-plugin)
[![Gradle](https://img.shields.io/badge/Gradle-8.x-blue?style=flat)](https://gradle.org)
![Min SDK 29](https://img.shields.io/badge/Min%20SDK-29-839192?logo=android&logoColor=white)
![Target SDK 35](https://img.shields.io/badge/Target%20SDK-35-566573?logo=android&logoColor=white)
[![Language: Kotlin](https://img.shields.io/github/languages/top/jamiescode/a-tech-test.svg)](https://github.com/jamiescode/a-tech-test/search?l=kotlin)

# Tasks

1. Update the project to pass the selected market object from the MarketListFragment to the MarketDetailScreen (Compose).
2. Implement the MVVM (Model-View-ViewModel) architecture in the MarketDetailScreen.
3. Populate the following fields in the MarketDetailScreen from the selected market object using the Text component:
      Epic
      Current Price
      Current Change
      Current Change Percentage
4. Use proper state composables to display the MarketDetailScreen effectively.
5. Ensure that any business logic in the ViewModel is covered by unit tests.
6. After completing the first task, what would you choose to do next? In this task we would like to see which would be your next priority and why.
7. If you had more time what would you improve?
8. What would you do differently if you were to start from scratch?

# Actions taken

## Project setup (before addressing tasks):

* Renamed the package name to something less obvious for a public repository
* Set up GitHub workflows and code quality tools. I want to start from a code base with good quality code and a CI checking quality on every PR
* Configured repo settings to add branch protection - everything must go through a PR that passes the status checks
* I set up Renovate (GitHub app that creates PRs for dependency updates)
* Added code quality/status badges to the readme. This creates visibility of the health of the project.

## Task 1 - Pass the selected market object

* I assumed that we want to stay with the XML nav graph (the other option to to move completely to Compose nav graphs)
* As we are using XML nav graphs, we should use the Safe Args plugin as per [the documentation](https://developer.android.com/guide/navigation/use-graph/pass-data#Safe-args) 
* Changed `<composable>` to a `<fragment>` that becomes a wrapper for a `ComposableView`. The Fragment is a shell for a composable. It's this or we switch everything to Compose nav graphs. You can see both options [here](https://developer.android.com/guide/navigation/design#frameworks).
* Extracted `Market` class from a nested class inside `GetMarketsResponse` to address `ClassNotFoundException: Didn't find GetMarketsResponse.Market on path: DexPathList` 

## Task 2 - Implement MVVM

* I added `MarketDetailsViewModel`, which only has a single method `setMarket()`. I chose to use `LiveData` to represent the view state. The fragment gets the navigation argument and calls `setMarket` on the view model.
* The composable listens to the `LiveData` state of the screen. I've set these to be `Loading` and `Loaded`, where `Loaded` contains the market data.
* I wrote view model tests as part of this task, so I've already done number 5.
* I added the [Turbine library](https://github.com/cashapp/turbine) in order to easily test the view states being sent by the `ViewModel`
* I needed to include some extensions in order to unit test the `ViewModel`. I added another module called `testutils` which includes the files for tests and included the module as a test dependency for the `app` module.

## Task 3 - Populate fields

* I have implemented Epic, Current Price, Current Change & Current Change Percentage in the MarketDetailScreen
* I used the Text Composable, along with the material design tokens for text styling. This means that the style can be easily changed in the future
* Added `MarketDetailsRow` which is a composable to represent a title and value in a row. This is used for each attribute.
* Extracted strings to `strings.xml`, ready for localisation
* I've used values from `Market` directly in the view here. There is an argument that I should have had a domain object to represent `Market` and a mapper to format the text. For something this small, I don't see the need.

## Task 4 - Use proper state composables

* I have extracted the composables into `detail/composable`. They are `AppBar`, `LoadingScreen`, `MarketDetailsContent`, `MarketDetailsRow`.
* Each composable has a `@Preview` so you can see what it looks like in Android Studio

## Task 5 - Add unit tests to the ViewModel

* Completed as part of task 2 - I consider writing units tests as part of adding the `ViewModel`

## Task 6 - After the first task, what would you do next?

* Make the composable view and XML views use the same theme.
* The `AppBar` height is different between the two screens, which makes the transition jarring for the user
* Go back to `MarketListViewModel` and the other classes to add unit/UI tests

## Task 7 - What would you improve if you had more time?

* Convert `GetMarketsResponse` into a fully fledged API request and response, ideally using Retrofit
* Look into the issue that when you switch between fragments, the AppBar is of different heights
* Consider switching the entire navigation to compose navigation. For a small project like this, it's ok. For a large project you would need to keep using fragment wrappers until the majority of the UI is in compose.
* Write unit tests. Especially for `MarketListViewModel`
* Consider adding Timber / Analytics / Crash reporting
* Don't expose the `Context` in `InterviewApplication`
* Change `LiveEvent` code formatting to match the result of the code. It's currently the AOSP standard e.g. `mData` instead of `data`.
* Tidy up `libs.versions.toml` dependency list. I've already organised some of it and updated all the versions, but there are still libraries that aren't used.
* Investigate theming - it's likely that the XML theme is not going to match the theme used in the compose screens.
* Set an app icon
* Consider if we need the high min SDK version of 29. According to [API Levels](https://apilevels.com/), this would target 87.1% as of the time of writing this. A min API of 26 hitting 95.7% of the market might be more appropriate. I suggest API 26 because at this level you need a lot less variations of the app icon - most of it is provided by XML files instead of images.
* Write UI tests. Investigate screenshot testing using [Shot](https://github.com/pedrovgs/Shot) or something similar.
* Set up a code coverage tool that can report on each PR. Also add a code coverage percentage badge to the project readme.
* Set up DI using [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
* ~Change `containerColor` in `AppBar` to not be hardcoded. It should us a predefined colour, ideally from the MaterialTheme with a token. Once this is changed I can remove `@Suppress(MagicNumber)` as well.~ Replaced with `purple_500`

## Task 8 - What would you do differently from scratch?

* Not spend so long thinking about the `<composable>` in the navigation graph. I had to do some research into this to work out if it was possible.
* I didn't think it was possible to mix XML and compose in the XML navigation graph, but maybe I'm wrong!
* I would probably rewrite `MarketListFragment` in compose and use compose navigation
* I spent a decent amount of time doing project setup like CI, build statuses and code quality. I would do it again. It's worth it even for technical tests like this.