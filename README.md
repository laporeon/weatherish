<h1 align="center"> ⛅ Weather CLI</h1>
<hr/>

![node](https://img.shields.io/static/v1?label=node&message=18.16.1&color=2d3748&logo=node.js&style=flat-square)
![axios](https://img.shields.io/static/v1?label=axios&message=0.27.0&color=2d3748&logo=npm&style=flat-square)
![commander](https://img.shields.io/static/v1?label=commander&message=9.2.0&color=2d3748&logo=npm&style=flat-square)
![figlet](https://img.shields.io/static/v1?label=figlet&message=1.5.2&color=2d3748&logo=npm&style=flat-square)
[![eslint](https://img.shields.io/badge/eslint-8.31.0-4b32c3?style=flat-square&logo=eslint)](https://eslint.org/)
[![MIT License](https://img.shields.io/badge/license-MIT-green?style=flat-square)](https://raw.githubusercontent.com/laporeon/teste/main/LICENSE)

This is a personal project made to learn a little bit about CLI's. It's a simple CLI that fetches weather data from a specific city, returning current local time and temperature, max temperature, feels like, humidity and wind speed.

![project](https://github.com/laporeon/weather-cli/assets/34722707/eaf6faa8-6ae4-45a7-a763-27da36f3caea)

## Table of Contents

- [Getting Started](#getting-started)
  - [Requirements](#requirements)
  - [Installing](#installing)
  - [Configuring](#configuring)
  - [Usage](#usage)
    <br/>

## Getting Started

### **Requirements:**

- [NodeJS](https://nodejs.org/en) v.16.x.x or higher

### **Installing:**

Yarn:

```bash
$ yarn
```

NPM:

```bash
$ npm install
```

### **Configuring**

After installing all the dependencies, inside the project's root folder, run the following command to install it globally. This will allow you to use the commands without the need of being inside the project's folder.

```bash
$ npm install -g .
```

### **Usage**

This project accepts two units of measurement: metric and imperial. This option is not required, but, if you don't pass it, the default unit is going to be `metric` and local datetime format will be `pt_BR`. If you pass `imperial` as an option, all weather data will be displayed in `Fahrenheit` and local datetime format will be `en_US`.

**_Examples_**:

Default:

```bash
$ weather-cli fetch "Curitiba" # data will be display in Celsius and date/time in Brazilian Portuguese
```

![default](https://github.com/laporeon/weather-cli/assets/34722707/9bb5a9a7-b1b1-4b31-b760-6edc4957a447)

Passing unit as an option:

```bash
$ weather-cli fetch "London" --units imperial # data will be display in Fahrenheit and date/time in American English
```

![imperial](https://github.com/laporeon/weather-cli/assets/34722707/9cd3ee65-b845-4227-ad18-3efeae774c9b)

[⬆ Back to the top](#--weather-cli)
