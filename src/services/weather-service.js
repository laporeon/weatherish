import axios from 'axios';

import { env } from '../config/env.js';
import { WeatherResponse } from '../responses/weather-response.js';
import { errorMessage } from '../utils/chalk.js';

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
      const { data } = await this.api.get(
        `${this.path}${city}&appid=${this.key}&units=${units}`,
      );
      this.weatherResponse.generateResponse(data, units);
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
