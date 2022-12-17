<h1 align="center"> ⛅ Weather CLI</h1>
<p align="center">Para ver o README deste projeto em Português, <a href="./docs/README.md">clique aqui</a>.
<hr/>

<p align="center">
  <a href="#-technologies">Technologies</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-about-the-project">About the project</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-getting-started">Getting started</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-license">License</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
</p>


<br>

## ✨ Technologies

This project was developed using the following techs:

[Node.js](https://nodejs.org/en/) | [Chalk](https://github.com/chalk/chalk) | [Commander](https://www.npmjs.com/package/commander) | [Figlet](https://www.npmjs.com/package/figlet) | [OpenWeather API](https://openweathermap.org/api)

<br>


## 💻 About the project

This is a personal project made to learn a little bit about CLI's. It's a simple CLI that fetchs weather data from a specific city, returning current local time and temperature, max temperature, humidity and wind speed.

![project](https://user-images.githubusercontent.com/34722707/208252090-11f7890a-4b58-434c-b090-b6b2fad2d776.png)

<br>

## 🚀 Getting started

### **Requirements:**

Before you start, please make sure you have met the following requirements:

- You have [Node.js](https://nodejs.org/en/) installed on your machine. Version required is v16.x.x or higher.

After that, you can follow the steps bellow:

- Clone the project and access its folder:

```bash 
$ git clone https://github.com/laporeon/weather-cli && cd weather-cli
```
- Install the dependencies
```bash
$ npm i
```
- Now, inside the project's folder, use the following command to install it globally:
```bash
$ npm install -g .
```
This will allow you to use the commands without the need of being inside the project's folder.


### **Usage:**

This project accepts two units of measurement: metric and imperial. This option is not required, but, if you don't pass it, the default unit is going to be `metric` and local datetime format will be `pt_BR`. If you pass `imperial` as an option, all weather data will be displayed in `Fahrenheit` and local datetime format will be `en_US`.

***Examples***:

- Default:

```bash
$ weather-cli fetch "Curitiba" # data will be display in Celsius and date/time in Brazilian Portuguese
```
![default](https://user-images.githubusercontent.com/34722707/208251993-97d30b9f-332d-4c34-8093-8f52ff8a3509.png)

- Passing the unit as an option:

```bash
$ weather-cli fetch "London" --units imperial # data will be display in Fahrenheit and date/time in American English
```
![imperial](https://user-images.githubusercontent.com/34722707/208251994-fc7cf988-d21c-4ffd-8cc6-6ed558d8491a.png)

<br>

## 📝 License

This project is licensed under the MIT License. See the file [LICENSE](LICENSE.md) for further details.

[⬆ Back to the top](#--weather-cli)

