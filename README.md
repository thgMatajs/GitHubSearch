
# GitHub Search Repositories

#### Android app to search repositories in github.
    
 ## This project leverages on: 
 - **[Kotlin](https://kotlinlang.org/)** (main programming language)  
 - **MVVM Clean Architecture with Repository Pattern**
 - **[Retrofit](https://square.github.io/retrofit/)** (for networking over HTTP)  
 - **[Gson](https://github.com/google/gson)** (for serialized objects)
 - **Architecture Components** (LiveData, ViewModel, Room Persistence, Paging)
 - **[RxJava](https://github.com/ReactiveX/RxJava) e [RxAndroid](https://github.com/ReactiveX/RxAndroid)** (for asynchronous programming)  
 - **[Koin](https://insert-koin.io/)** (for Dependency Injection)  
 - **[coil](https://coil-kt.github.io/coil/getting_started/)** (for load images) 
 - **Mockito, JUnit4** for testing
    
## Modules and their responsibilities
- **model** - standardization of models using interfaces
- **base** - abstracts logics
- **di** - centralization of module di so as not to overload the `app module`
- **domain** - use cases logic
- **data** - logic of interaction with `cache module` or `remote module`
- **remote** - call logic in api
- **cache** - persistence local logic
- **presentation** - view model logic
- **app** - ui logic
## Next steps  
  
- Implement more instrumentation and unit tests  
- Improve error handling  
- Include support to use a CI/CD platform (Circle CI, Bitrise, Fastlane)  
- Change app to be used in 100% offline 
- Implement ktlint
- Implement detekt

## Getting started

There are a few ways to open this project.

### Android Studio

1. Android Studio -> File -> New -> From Version control -> Git
2. Enter `https://github.com/thgcode0101/GitHubSearch.git` into URL field

### Command line + Android Studio

1. Run `git clone https://github.com/thgcode0101/GitHubSearch.git`
2. Android Studio -> File -> Open

## LICENSE  
  
```  
MIT License  
  
Copyright (c) 2020 gentalhacode  
  
Permission is hereby granted, free of charge, to any person obtaining a copy  
of this software and associated documentation files (the "Software"), to deal  
in the Software without restriction, including without limitation the rights  
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell  
copies of the Software, and to permit persons to whom the Software is  
furnished to do so, subject to the following conditions:  
  
The above copyright notice and this permission notice shall be included in all  
copies or substantial portions of the Software.  
  
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR  
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,  
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE  
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER  
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,  
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  
SOFTWARE.
