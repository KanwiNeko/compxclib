<div id="top"></div>

<div align=center>
<img src="https://github.com/KanwiNeko/compxclib/blob/main/assets/Repo%20Icon.png?raw=true" alt="Repository Icon" width="200">
<h1> <b>CompxCLib</b> </h1>
Complex Complete Library
<br/>
<!-- Description  -->

A complete library for all of your <b>complex</b> needs!

<a href="https://github.com/KanwiNeko/compxclib/wiki">Docs →</a>
<br/>

[![contributors][Contributors]][Contributors-url]
[![forks][Forks]][Forks-url]
[![stars][Stars]][Stars-url]
[![issues][Issues]][Issues-url]
[![license][License]][License-url]
[![pull requests][PullRequests]][PullRequests-url]

</div>

<details>
    <summary>Table of contents</summary>
        <ol>
            <li><a href="#About">About</a></li>
                <ul>
                    <li><a href="#Inspiration">Inspiration</a></li>
                    <li><a href="#Tools used">Tools used</a></li>
                </ul>
            <li><a href="#Getting Started">Getting Started</a></li>
                <ul>
                    <li><a href="#Prerequisites">Prerequisites</a></li>
                    <li><a href="#Installation">Installation</a></li>
                </ul>
            <li><a href="#Usage">Usage</a></li>
            <li><a href="#Roadmap">Roadmap</a></li>
            <li><a href="#Contributing">Contributing</a></li>
            <li><a href="#License">License</a></li>
            <li><a href="#Contact">Contact</a></li>
            <li><a href="#Acknowledgements">Acknowledgements</a></li>
        </ol>
</details>

---

## About


<div align="center">


<img src="https://raw.githubusercontent.com/KanwiNeko/compxclib/main/assets/examples/1.png" alt="Graph of a complex function" width="250">
<img src="https://raw.githubusercontent.com/KanwiNeko/compxclib/main/assets/examples/2.png" alt="Graph of a complex function" width="250">
<img src="https://raw.githubusercontent.com/KanwiNeko/compxclib/main/assets/examples/3.png" alt="Graph of a complex function" width="250">

> these images were generated using [Processing].

</div>

CompxCLib is a library targeted at everyone that needs to work with complex numbers in a straightforward and elegant manner, utilizing the features of the Kotlin language to make it accessible and simple.

*but why not use one of the many libraries out there?* compxclib has unique features that make using complex numbers a *breeze*.
### Inspiration
The reason I started working on this library was that I'm in love with complex algebra and I wanted to have a simple-to-use tool in order to create interesting and aesthetically pleasing simulations.
### Tools used
These were some of the tools I used to build this project (except processing, that was used to make the graphics in this document)

 - [![Gradle Logo][GradleIMG]][Gradle]
 - [![Processing Logo][ProcessingIMG]][Processing]
 - [![IntelliJ IDEA logo][IntelliJIMG]][Idea]
 - [![ShadowJar on Github][ShadowJarIMG]][ShadowJar]
 - [![Kotlin Logo][KotlinIMG]][Kotlin]

## Getting Started
### Installation

<div align=center>
<table>
<tr><td>pom.xml</td></tr>
<tr><td align=left>

```xml
<dependency>
    <groupId>gay.kanwi</groupId>
    <artifactId>compxclib</artifactId>
    <version>v0.1-beta</version>
</dependency>
```
</tr></td>

<tr><td>build.gradle</td></tr>
<tr><td align=left>

```gradle
dependencies {
    //other dependencies...
    implementation 'gay.kanwi:compxclib:v0.1-beta'
}
```

</tr></td>

<tr><td>build.gradle.kts</td></tr>
<tr><td align=left>

```kotlin
dependencies {
    //other dependencies...
    implementation("gay.kanwi:compxclib:v0.1-beta")
}
```
</tr></td>

</table>
</div>

## Examples

<div align=center>

<table>
    <tr>
        <td>parsing user input to a complex number</td>
    </tr>
    <tr>
        <td align=left>
            
```java
import compxclib.ComplexNumber;
import compxclib.parser.Parser;
import java.util.Scanner;

public class App{
    private static final Scanner scanner = new Scanner(System.in);
    private static void calculate() {
        String input = scanner.nextLine();
        Parser parser = new Parser(input);
        ComplexNumber result = parser.parse();
        System.out.println(input +" = "+ result);
    }
    public static void main(String[] args) {
        System.out.println("Introduce an expression");
        calculate();
    }
}
```
</table>
    
<table>
    <tr>
        <td>run multiple operations efficiently</td>
    </tr>
    <tr>
        <td align=left>
            
```kotlin
import compxclib.ComplexNumber
import compxclib.functions.sin

fun main() {
    val (width, height) = Pair(1920, 1080)
    val results = Array(height) { Array(width) { ComplexNumber(0,0) } }
    for (i in 0 ..< height) {
        for (j in 0 ..< width){
            val currentNumber = ComplexNumber(height, width)
            val sinOfCurrentNumber = sin(currentNumber)
            results[i][j] = sinOfCurrentNumber
        }
    }
    println(results)
}

```
</table>

</div>   
    
## Roadmap

- [X] Adding a fully functioning complex number class
- [X] Handling typical functions such as `exp(x)` or `log(x)`
- [ ] Handling extra functions
    - [X] Trig functions
    - [ ] Hyperbolic functions
- [ ] Adding a parser
    - [x] Parser returns values
    - [ ] Parser returns functions

## Contributing
## License
## Contact
## Acknowledgements

<!-- LINKS AND IMAGES -->

[Contributors]: https://img.shields.io/github/contributors/KanwiNeKo/compxclib?color=blue&style=for-the-badge
[Forks]: https://img.shields.io/github/forks/kanwineko/compxclib?style=for-the-badge
[Stars]: https://img.shields.io/github/stars/kanwineko/compxclib?style=for-the-badge
[Issues]: https://img.shields.io/github/issues/kanwineko/compxclib?style=for-the-badge
[License]: https://img.shields.io/github/license/kanwineko/compxclib?style=for-the-badge
[PullRequests]: https://img.shields.io/github/issues-pr/kanwineko/compxclib?style=for-the-badge

[Contributors-url]: https://github.com/KanwiNeko/compxclib/graphs/contributors
[Forks-url]: https://github.com/KanwiNeko/compxclib/network/members
[Stars-url]: https://github.com/KanwiNeko/compxclib
[Issues-url]: https://github.com/KanwiNeko/compxclib/issues
[License-url]: https://mit-license.org/
[PullRequests-url]: https://github.com/KanwiNeko/compxclib/pulls

[README-inspiration]: https://github.com/othneildrew/Best-README-Template
[Gradle]: https://gradle.org/
[Processing]: https://processing.org/
[Idea]: https://www.jetbrains.com/idea/
[ShadowJar]: https://github.com/johnrengelman/shadow
[Kotlin]: https://kotlinlang.org/

[GradleIMG]: https://img.shields.io/static/v1?label=&message=Gradle&color=lightgray&logo=Gradle&style=flat-square
[ProcessingIMG]: https://img.shields.io/static/v1?label=&message=Processing&color=4d4d4d&logo=ProcessingFoundation&style=flat-square
[IntelliJIMG]: https://img.shields.io/static/v1?label=&message=IntelliJIDEA&color=000000&logo=IntelliJIDEA&style=flat-square
[ShadowJarIMG]: https://img.shields.io/static/v1?label=&message=ShadowJar&color=gray&logo=GitHub&style=flat-square
[KotlinIMG]:https://img.shields.io/static/v1?label=&message=Kotlin&color=FF3850&logo=kotlin&style=flat-square
