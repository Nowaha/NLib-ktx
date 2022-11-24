# NLib-ktx <a href="https://github.com/Nowaha/NLib-ktx/releases/"><img alt="GitHub Workflow Status" src="https://img.shields.io/github/workflow/status/nowaha/nlib-ktx/Gradle%20Package"></a> <a href="https://github.com/Nowaha/NLib-ktx/packages/1712122"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/nowaha/nlib-ktx?display_name=tag"></a>

The Kotlin-specific functionalities from my library, NLib. This should be used together with [the Java version](https://github.com/Nowaha/NLib) to have a full library.

I created this library because none of the pre-existing libraries I found were really fitting for my preferences. A lot of them like to put huge disgusting wrappers
around everything to the point where you don't even know what's going on anymore, and can't really access any of the barebone things. I really felt like that's
something I want to keep, so instead of using wrappers like that I thought to make use of the great feature in Kotlin, extension functions.

This way I can easily add functionality to already existing classes and you can just call it on the objects themselves, without losing access to the original object
or having to go through some weird side route to get to it.

## Documentation
The documentation for this project is generated using Kotlin [dokka](https://github.com/Kotlin/dokka).\
I've hosted it at https://nowaha.xyz/nlib-ktx/

## Installation
I publish the latest build to [GitHub packages](https://github.com/Nowaha/NLib-ktx/packages/1712122).

You can add it as a dependency by putting the following in your `build.gradle` file:
```groovy
repositories {
  maven {
      name = "nlibktx"
      url = uri("https://maven.pkg.github.com/nowaha/nlib-ktx")
      credentials(PasswordCredentials)
  }
}
```

```groovy
dependencies {
  implementation('xyz.nowaha:nlib-ktx:<latest version>') {
        exclude group: 'org.jetbrains.kotlin', module: 'kotlin-stdlib-jdk8'
    }
}
```

For the `PasswordCredentials` to be filled in properly, you need to add to your `gradle.properties`
```groovy
nlibktxUsername=<username>
nlibktxPassword=ghp_XXXXXXXXXXXXXX
```
