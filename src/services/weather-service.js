import axios from 'axios';

import { env } from '../config/env.js';
import { WeatherResponse } from '../responses/weather-response.js';
import { errorMessage } from '../utils/chalk.js';

class WeatherService {
  constructor() {
    this.apiURL = axios.create({
      baseURL: env.baseApiURL,
    });

    this.weatherResponse = new WeatherResponse();
  }

  async execute(city, units) {
    try {
      const { data } = await this.apiURL.get(`?city=${city}&units=${units}`);

      this.weatherResponse.generateResponse(data, units);
    } catch (err) {
      console.log(errorMessage('\nError'), {
        statusCode: err.response.status,
        statusText: err.response.statusText,
        message: 'Oops... something went wrong with your request!',
      });
    }
  }
}

export const weatherService = new WeatherService();
