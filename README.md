# Connectify Library

Handling the internet connection in android is a headache given that the methods very often become deprecated. Connectify Library helps to handle internet connection state. Uses Kotlin, coroutines flow under the hood. 
The library works with android version 21.
## Installation

Add it in your root build.gradle at the end of repositories:


```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
	```
Step 2. Add the dependency
```gradle
	dependencies {
	        implementation 'com.github.SanGainTeam:Connectify:![version]'
	}
	```

## Usage
Go to your BaseApplication
```kotlin
class BaseApplication : Application() {
    
    override fun onCreate() {
      ...
     initSanGainConnectify()

    }
}
```
Further, in any place where it is necessary to observe the changes in the state of internet connection, use this code:

```kotlin
class MainActivity : AppCompatActivity(){
private val observer = SanGainConnectify.observer
     override fun onCreate(savedInstanceState: Bundle?) {
      ...
      observer.onEach { status ->
            when(status){
                Status.Available -> {/*Some Code for handle Available State*/}
                Status.Losing ->{/*Some Code for handle Losing State*/}
                Status.Lost -> {/*Some Code for handle Losing Lost*/}
                Status.Unavailable -> {/*Some Code for handle Losing Unavailable*/}
            }
        }.launchWhenCreated(this)

   }
}
```
launchWhenCreated is just an extension function that collects values ​​using lifecycle.
Here is an example:

```kotlin
fun <T> Flow<T>.launchWhenCreated(lifecycleOwner: LifecycleOwner) = with(lifecycleOwner) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.CREATED) {
            try {
                this@launchWhenCreated.collect()
            } catch (t: Throwable) {
                Log.d("LOG", "Collect error")
            }
        }
    }
}

```


## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)
