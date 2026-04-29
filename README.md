<h1 align="center"> Weatherish

![java](https://img.shields.io/static/v1?label=java&message=21.0.9&labelColor=2d3748&color=grey&logo=openjdk&logoColor=white&style=flat)
![maven](https://img.shields.io/static/v1?label=maven&message=3.9.12&labelColor=2d3748&color=grey&logo=apachemaven&logoColor=white&style=flat)
[![MIT License](https://img.shields.io/badge/license-MIT-green?style=flat-square)](https://github.com/laporeon/weatherish/blob/main/LICENSE.md)


</h1>

## Table of Contents

- [About](#about)
- [Requirements](#requirements)
- [Getting Started](#getting-started)
  - [Configuring](#configuring)
    - [Environment Variables](#environment-variables)
  - [Building](#building)
  - [Running](#running)
    - [Linux and macOS](#linux-and-macos)
    - [Windows](#windows)
- [Usage](#usage)
- [Preview](#preview)
## About

Weatherish is a Java-based CLI that fetches current weather data for any city using the OpenWeatherMap API. It 
displays current temperature, feels like, humidity, wind speed and local time, all from your terminal.

## Requirements

- Java 21+
- Maven 3.9+

## Getting Started

### Configuring

#### Environment Variables

You'll need an API key from [OpenWeatherMap](https://openweathermap.org/api).

Set the `API_KEY` environment variable before running the application.

**Linux / macOS:**

For the current session only:
```bash
export API_KEY=your-api-key
```

To persist, add to your `~/.bashrc` or `~/.zshrc` and reload:
```bash
export API_KEY=your-api-key
source ~/.bashrc  # or source ~/.zshrc
```

**Windows — Command Prompt:**
```cmd
set API_KEY=your-api-key
```

**Windows — PowerShell:**
```powershell
$env:API_KEY = "your-api-key"
```

> [!NOTE]
> `set` and `$env:` are session-only on Windows. To persist, add via System Properties → Environment Variables.

### Building

After cloning this repository, build the project using Maven:

```bash
mvn clean package
```

This will create an executable JAR file at `target/weatherish.jar`.

### Running

#### Linux and macOS

On Linux and macOS, you have several options to run the application:

**Option 1: Direct JAR execution**

```bash
java -jar target/weatherish.jar
```

**Option 2: Using the wrapper script**
> [!NOTE]
> First time only, make the script executable:
> ```bash
> chmod +x weatherish
> ```

```bash
./weatherish 
```

**Option 3: Create a system-wide alias by adding this to your `.bashrc` or `.zshrc`:**

```bash
alias weatherish='java -jar /full/path/to/weatherish/target/weatherish.jar'
```

Then reload your profile (`source ~/.bashrc` or `source ~/.zshrc`) or restart your terminal.

Now you can use `weatherish` from anywhere in your terminal.

#### Windows

For Windows environments, you can execute the application by choosing one of the following options:

**Option 1: Using the wrapper script**
```bat
weatherish.bat 
```

**Option 2: Create a system-wide alias by adding this to your PowerShell profile:**
```powershell
function weatherish { java -jar "C:\full\path\to\weatherish\target\weatherish.jar" }
```
Then reload your profile (`. $PROFILE`) or restart your terminal.

Now you can use `weatherish` from anywhere in your terminal.


## Usage

Run the application using preferred option and enter the desired city when prompted. The CLI will display current weather information for that location.

## Preview

![weatherish](./src/main/resources/assets/weatherish.gif)

[⬆ Back to the top](#-weatherish)
