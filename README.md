# DOGS APP 

This is the sample app to use API at https://dog.ceo/ 

These dependencies and structures were utilized:

Architecture: MVVM

Views: Hybrid (XML and jetpack Compose)

Dependency Injection: Hilt

Navigator: Navigation Component

Http client: Retrofit

DataBinding


## Project contain three different screen:

1- Presentation Screen
It provides an introduction to help you understand what the app works.
I used an XML base view using viewPager2 to slide each intro.

2- Dog Breeds List Screen
Recycle View displays all dog breeds with a random image by using proper APIs.

3- Dog Breed Images Screen
It uses Jetpack Compose LazyGridLayout to display twenty images of each dog breed.
