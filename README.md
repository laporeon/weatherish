<h1 align="center"> ⛅ Weatherish

![node](https://img.shields.io/static/v1?label=node&message=20.9.0&color=2d3748&logo=node.js&style=flat-square)
![axios](https://img.shields.io/static/v1?label=axios&message=1.7.7&color=2d3748&logo=npm&style=flat-square)
![inquirer](https://img.shields.io/static/v1?label=inquirer&message=12.1.0&color=2d3748&logo=npm&style=flat-square)
[![eslint](https://img.shields.io/badge/eslint-8.31.0-4b32c3?style=flat-square&logo=eslint)](https://eslint.org/)
[![MIT License](https://img.shields.io/badge/license-MIT-green?style=flat-square)](https://github.com/daspeon/weatherish/blob/main/LICENSE.md)

</h1>

## Table of Contents

- [About](#about)
- [Requirements](#requirements)
- [Installing](#installing)
  - [Configuring](#configuring)
    - [.env](#env)
- [Usage](#usage)
- [Preview](#preview)

## About

This is a personal project made to learn a little bit about Command Line Interfaces. It's a simple CLI that fetches weather data from a specific city, provided by the user, returning current local time and temperature, feels like, humidity and wind speed. As a couple of extra features, user can choose which unit of measurement to use and how date and time will be displayed.

## Requirements:

- [NodeJS](https://nodejs.org/en) v.20 or higher
- [OpenWeatherMap](https://openweathermap.org/api) - The API that provides weather information.

If you use [NVM](https://github.com/nvm-sh/nvm), just run `nvm use` inside of the root folder.

## **Installing:**

Yarn:

```bash
$ yarn
```

NPM:

```bash
$ npm i
```

### **Configuring**

For this step, you'll need to generate your api key at [OpenWeatherMap](https://openweathermap.org/api) website.

#### **.env**

Rename the `.env.example` file to `.env` and update the variables with your settings.

| key     | description              | default |
| ------- | ------------------------ | ------- |
| API_KEY | OpenWeatherMap's api key | -       |

## Usage

### **Starting**

```bash
$ npm start
```

## Preview

![weatherish](./assets/weatherish.gif)

[⬆ Back to the top](#--weatherish)
