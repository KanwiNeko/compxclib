<!--suppress ALL -->
<div id="top"></div>

<div align=center>
<img src="https://github.com/KatieUmbra/compxclib/blob/main/assets/Repo%20Icon.png?raw=true" alt="Repository Icon" width="200">
<h1> <b>CompxCLib</b> </h1>
Complex Complete Library
<br/>
<!-- Description  -->

A complete library for all of your <b>complex</b> needs!

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
            <li><a href="#Installation">Installation</a></li>
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


<img src="https://raw.githubusercontent.com/KatieUmbra/compxclib/main/assets/examples/1.png" alt="Graph of a complex function" width="250">
<img src="https://raw.githubusercontent.com/KatieUmbra/compxclib/main/assets/examples/2.png" alt="Graph of a complex function" width="250">
<img src="https://raw.githubusercontent.com/KatieUmbra/compxclib/main/assets/examples/3.png" alt="Graph of a complex function" width="250">

> these images were generated using [Processing].

</div>

CompxCLib is a library targeted at everyone that needs to work with complex numbers in a straightforward and elegant manner, utilizing the features of the Kotlin language to make it accessible and simple.

*but why not use one of the many libraries out there?* compxclib has unique features that make using complex numbers a *breeze*.

Here are some of the unique features that **Compxclib** has:

- Main intuitive complex number class, with plenty of operator extensions and `infix pow` function (kotlin exclusive)
- Number operator extensions
- Trig, exp, and other kinds of operations that are well optimized
- An **expression parser** to quickly evaluate mathematical expressions that use complex numbers.

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

[![repository][MavenCentral]][MavenCentral-url]

<details> <summary>Maven</summary>
<div align=center>
<table>
<tr><td>pom.xml</td></tr>
<tr><td align=left>

```xml

<dependency>
  <groupId>dev.kaytea</groupId>
  <artifactId>compxclib</artifactId>
  <version>1.2</version>
</dependency>
```
</tr>
</table></div>
</details>

<details> <summary>Gradle</summary>
<div align=center>
<table>
<tr><td>build.gradle</td></tr>
<tr><td align=left>

```gradle
dependencies {
    //other dependencies...
    implementation 'dev.kaytea:compxclib:1.2'
}
```

</tr>
</table></div>
</details>

<details> <summary>Gradle kotlin</summary>
<div align=center>
<table>
<tr><td>build.gradle.kts</td></tr>
<tr><td align=left>

```kotlin
dependencies {
  //other dependencies...
  implementation("dev.kaytea:compxclib:1.2")
}
```
</tr></table></div>
</details>

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
- [ ] Refractor codebase and optimize
- [ ] Handling extra functions
  - [X] Trig functions
  - [ ] Hyperbolic functions
- [ ] Adding a parser
  - [x] Parser returns values
  - [ ] Parser returns functions
- [ ] Examples inside the documentation

## Contributing

Contributing is what makes open source projects so magical, and it unites the community.
if you want to suggest a feature then you could either
- Create a new issue with the "Suggestion tag"
- Create a pull request:
  1. Fork the Project
  2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
  3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
  4. Push to the Branch (`git push origin feature/AmazingFeature`)
  5. Open a Pull Request

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Contact

You can contact me with the name "Katherine" 
- Email: `katherine@kaytea.dev`
- Repo: `https://github.com/KatieUmbra/compxclib`
## Acknowledgements

- [This readme is heavily inspired on this][README-inspiration]
- [Processing framework used for the images][Processing]

<!-- LINKS AND IMAGES -->

[Contributors]: https://img.shields.io/github/contributors/KatieUmbra/compxclib?color=blue&style=for-the-badge
[Forks]: https://img.shields.io/github/forks/KatieUmbra/compxclib?style=for-the-badge
[Stars]: https://img.shields.io/github/stars/KatieUmbra/compxclib?style=for-the-badge
[Issues]: https://img.shields.io/github/issues/KatieUmbra/compxclib?style=for-the-badge
[License]: https://img.shields.io/github/license/KatieUmbra/compxclib?style=for-the-badge
[PullRequests]: https://img.shields.io/github/issues-pr/KatieUmbra/compxclib?style=for-the-badge
[MavenCentral]: https://img.shields.io/maven-central/v/dev.kaytea/compxclib?style=for-the-badge

[Contributors-url]: https://github.com/KatieUmbra/compxclib/graphs/contributors
[Forks-url]: https://github.com/KatieUmbra/compxclib/network/members
[Stars-url]: https://github.com/KatieUmbra/compxclib
[Issues-url]: https://github.com/KatieUmbra/compxclib/issues
[License-url]: https://mit-license.org/
[PullRequests-url]: https://github.com/KatieUmbra/compxclib/pulls
[MavenCentral-url]: https://repo1.maven.org/maven2/dev/kaytea/compxclib/

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
