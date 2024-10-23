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

## Task 1

* I assumed that we want to stay with the XML nav graph (the other option to to move completely to Compose nav graphs)
* As we are using XML nav graphs, we should use the Safe Args plugin as per [the documentation](https://developer.android.com/guide/navigation/use-graph/pass-data#Safe-args) 
* Changed `<composable>` to a `<fragment>` that becomes a wrapper for a `ComposableView`. The Fragment is a shell for a composable. It's this or we switch everything to Compose nav graphs. You can see both options [here](https://developer.android.com/guide/navigation/design#frameworks).
* Extracted `Market` class from a nested class inside `GetMarketsResponse` to address `ClassNotFoundException: Didn't find GetMarketsResponse.Market on path: DexPathList` 

## Task 2

* TODO

## Task 3

* I'm going to assume that the `fragment_market_detail.xml` layout was the old XML layout that we want to match in Compose.

## Task 4

* TODO

## Task 5

* TODO

## Task 6

* TODO

## Task 7

* TODO

## Task 8

* TODO