<h1 align="center"> ⛅ Weatherish</h1>
<hr/>

![node](https://img.shields.io/static/v1?label=node&message=18.16.1&color=2d3748&logo=node.js&style=flat-square)
![axios](https://img.shields.io/static/v1?label=axios&message=0.27.0&color=2d3748&logo=npm&style=flat-square)
![commander](https://img.shields.io/static/v1?label=commander&message=9.2.0&color=2d3748&logo=npm&style=flat-square)
![figlet](https://img.shields.io/static/v1?label=figlet&message=1.5.2&color=2d3748&logo=npm&style=flat-square)
[![eslint](https://img.shields.io/badge/eslint-8.31.0-4b32c3?style=flat-square&logo=eslint)](https://eslint.org/)
[![MIT License](https://img.shields.io/badge/license-MIT-green?style=flat-square)](https://raw.githubusercontent.com/laporeon/teste/main/LICENSE)

This is a personal project made to learn a little bit about CLI's. It's a simple CLI that fetches weather data from a specific city, returning current local time and temperature, max temperature, feels like, humidity and wind speed.

## Table of Contents

- [Getting Started](#getting-started)
  - [Installing](#installing)
  - [Usage](#usage)
    <br/>

## Getting Started

### **Installing:**

| NPM                                  | Yarn                                  |
| ------------------------------------ | ------------------------------------- |
| <pre>npm install -g weatherish</pre> | <pre>yarn global add weatherish</pre> |

### **Usage**

This project accepts two units of measurement: metric and imperial. This option is not required, but, if you don't pass it, the default unit is going to be `metric` and local datetime format will be `pt_BR`. If you pass `imperial` as an option, all weather data will be displayed in `Fahrenheit` and local datetime format will be `en_US`.

```text
Usage: weather [options]

A CLI to check the weather from a city.

Options:
  -V, --version              Output the version number
  -c, --city <value>         Enter the city name
  -u, --units <value>        Choose units of measurement
  -h, --help                 Display help for command

Examples:
  weather -c "Curitiba"
  weather -c "London" -u imperial
```

**_Examples_**:

Default:

![default](https://github.com/laporeon/weatherish/assets/34722707/33d1fc72-9bc1-4ca7-9800-1990b5260ea1)

Passing unit as an option:

![imperial](https://github.com/laporeon/weatherish/assets/34722707/e9d2bf77-a0e5-474d-808b-4ae1b9b7bd81)

[⬆ Back to the top](#--weatherish)
