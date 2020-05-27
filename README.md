# Bitso Challenge

This project was made exclusively for a test at Bitso

## Architecture

This project is in **Clean Architecture + MVVM**. Each layer is separated as best practices demands, data, domain and view en separate folders and no one knows about the other. Communication is through interfaces and everything is stick togheter via Dependency Injection. Organization is made by **Package by Feature** philosophy so this can be easily scaled to many other features

### Features

- See available order books from [Bitso API](https://bitso.com/api_info)
- See book detail from [Bitso API](https://bitso.com/api_info)
- Pull to refresh to fech manually changes from server
- Polling every 30 seconds to fetch new data. If screen is destroyed, timer is cancelled
- Night Mode! Change your phone configuration and see the magic
- Offline support. Once the application downloaded at least the first time the data, subsequent calls can be done from cache even without internet connection

## Built With

Tools used for this challenge


* [Retrofit](https://square.github.io/retrofit/) - The networking library used
* [Gson](https://github.com/google/gson) - Serialization and Deserialization tool
* [ThreeTenABP](https://github.com/JakeWharton/ThreeTenABP) - Used to manage the dates
* [Koin](https://insert-koin.io/) - Glued everything with this DI framework
* [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - Async programming for the win
* [Room](https://developer.android.com/topic/libraries/architecture/room) - Persistance library
* [AndroidX](https://developer.android.com/jetpack/androidx) - Supposed to handled UI fragmentation but who knows

## Versioning

Project was managed with [Trunk Based Development](https://trunkbaseddevelopment.com/) methodology and every feature was merged via Pull Request. Develop will always be the Single Source of Truth

## Authors

* **Daniel García Alvarado** - [@iamlordalvarado](https://twitter.com/iamlordalvarado)
