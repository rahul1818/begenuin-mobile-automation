# BeGenuin mobile automation

Appium-based mobile automation for Android and iOS, with web and API coverage. The suite uses Java, TestNG, and reusable page objects under `src/test/java`.

**Release:** Maven `<version>` is **1.0.0**, matching git annotated tag **`v1.0.0`**.

## Stack

- **Java 8**, **Maven**
- **TestNG** for suites (`build/testSuiteNew.xml` is the default in `pom.xml`)
- **Appium** Java client for mobile
- **Selenium** / **WebDriverManager** for browser tests
- **REST Assured** for API tests
- **Allure** for reporting (optional)

## Prerequisites

- JDK 8+
- Maven 3.6+
- For **mobile**: [Appium](https://appium.io/) server, platform tools (Android SDK and/or Xcode for iOS), and a device or emulator with your app installed
- For **web**: Chrome (or the browser you configure)

## Configuration

Copy or edit `src/test/java/Config/runConfig.properties` for your environment:

- **Mobile**: `platformName`, `deviceName`, `platformVersion`, `appPath`, `automationName`, `server` (Appium URL, e.g. `http://127.0.0.1:4723/wd/hub`)
- **Web**: `browser`, `webURL`, credentials, `feURL`, frontend credentials

Properties are loaded by `Config.ReadProperties`. Do not commit real credentials; use local values or secrets management in CI.

## Run tests

From the project root:

```bash
mvn clean test
```

The Surefire plugin uses `build/testSuiteNew.xml` by default. To use another suite:

```bash
mvn clean test -Dsurefire.suiteXmlFiles=build/testSuite.xml
```

Enable or disable tests by editing the `<test>` blocks in the chosen suite XML file.

## Publish (GitHub Packages)

Artifacts are published to this repository’s [GitHub Packages](https://github.com/rahul1818/begenuin-mobile-automation/packages) Maven registry (`distributionManagement` id **`github`**).

**From GitHub Actions:** open **Actions → Publish to GitHub Packages → Run workflow**, or push a version tag matching `v*` (for example `v1.0.0`). The workflow runs `mvn -B deploy -DskipTests` with `GITHUB_TOKEN`.

**From your machine:** create a [classic PAT](https://github.com/settings/tokens) with `write:packages` (and `read:packages` if needed). In `~/.m2/settings.xml`:

```xml
<settings>
  <servers>
    <server>
      <id>github</id>
      <username>YOUR_GITHUB_USERNAME</username>
      <password>YOUR_PAT</password>
    </server>
  </servers>
</settings>
```

Then run:

```bash
mvn -B deploy -DskipTests
```

Published files include the main JAR and a **`tests`** classifier JAR (`Genuin-1.0.0-tests.jar`) that contains compiled test sources.

## Project layout

| Path | Purpose |
|------|---------|
| `src/test/java/Tests/` | Test classes (mobile, web, API, frontend) |
| `src/test/java/Pages/` | Page objects |
| `src/test/java/Utils/` | Shared helpers (`MobileCommon`, `WebCommon`, locators, actions) |
| `src/test/java/Config/` | `runConfig.properties`, `ReadProperties` |
| `build/` | TestNG suite XML files |

## CI and reporting

The POM includes optional integrations (e.g. Allure). The **testreport.io** upload (`qa-parse-maven-plugin`) is **not** bound to the default lifecycle: run **`mvn verify -Pqa-testreport`** (or include that profile after a normal test run) so `target/surefire-reports/testng-results.xml` exists. Default **`mvn deploy`** and **`mvn package`** skip that step so packaging and GitHub Packages deploy do not fail on a missing report file.

## License

See `LICENSE` in the repository root.
