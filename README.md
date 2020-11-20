# CodeChallenge
The purpose of this application is to load a set of locations from a JSON file and display the locations as a pin on the map.

## Technologies used
- KotlinX Serialization
- Retrofit & OKHttp
- Kotlin Coroutines
- Live Data (AndroidX)
- ViewModel (AndroidX)
- GoogleMaps
- Leak Canary
- Dagger Hilt

The acceptance criteria for this program is as follows:
- Application shows a map on launch and requests locations
- Locations loaded are sent to the map as markers
On rotation, the API is not called again
- The app is written entirely in Kotlin
- Dependency injection is used, where appropriate
- Unit testing is performed on the API layer
- Pin markers show up for every entry the API provides
- Coroutines are used, no RxJava or other async methods used
