import axios from 'axios';

import { errorMessage } from '../utils/chalk.js';
import { env } from '../config/env.js';

class WeatherService {
  constructor() {
    this.openWeatherMapApi = axios.create({
      baseURL: 'https://api.openweathermap.org/',
      headers: {
        Authorization: `Bearer ${env.apiKey}`,
      },
    });
    this.partialUrl = 'data/2.5/weather?q=';
    this.date = new Date();
    this.apiKey = env.apiKey;
  }

  async execute(city) {
    try {
      const response = await this.openWeatherMapApi.get(
        `${this.partialUrl}${city}&appid=${this.apiKey}&units=metric`,
      );

      const weatherData = await response.data;

      console.log({
        status: response.status,
        code: response.statusText,
        data: {
          city: weatherData.name,
          localTime: this.date.toLocaleString('pt-BR'),
          temperature: `${Math.round(weatherData.main.temp)}°C`,
          maxTemperature: `${Math.round(weatherData.main.temp_max)}°C`,
          humidity: `${weatherData.main.humidity}%`,
          wind: `${(weatherData.wind.speed * 3.6).toFixed(0)} km/h`,
        },
      });
    } catch (err) {
      console.log(errorMessage('Error'), {
        statusCode: err.response.status,
        statusText: err.response.statusText,
        message: 'Oops... something went wrong with your request!',
      });
    }
  }
}

export const weatherService = new WeatherService();
