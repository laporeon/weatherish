import axios from 'axios';

import { env } from '../config/env.js';
import { errorMessage } from '../utils/chalk.js';
import { WeatherResponse } from '../responses/weather-response.js';

class WeatherService {
  constructor() {
    this.api = axios.create({
      baseURL: env.api_base_url,
    });
    this.path = env.api_path;
    this.key = env.api_key;
    this.weatherResponse = new WeatherResponse();
  }

  async execute(city, units) {
    try {
      const response = await this.api.get(`${this.path}${city}&appid=${this.key}&units=${units}`);

      const { status, statusText } = response;

      const weatherData = await response.data;

      this.weatherResponse.generateResponse({ status, statusText }, weatherData, units);
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
