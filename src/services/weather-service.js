import axios from 'axios';

import { env } from '../config/env.js';
import { WeatherResponse } from '../responses/weather-response.js';
import { errorMessage } from '../utils/chalk.js';
import { spinner } from '../utils/ora.js';

class WeatherService {
  constructor() {
    this.apiURL = axios.create({
      baseURL: env.baseApiURL,
    });

    this.weatherResponse = new WeatherResponse();
    this.spinner = spinner;
  }

  async execute(city, units) {
    try {
      this.spinner.start();

      const { data } = await this.apiURL.get(`?city=${city}&units=${units}`);

      this.spinner.stop();

      this.weatherResponse.generateResponse(data, units);
    } catch (err) {
      this.spinner.stop();

      console.log(errorMessage('\nError'), {
        statusCode: err.response.status,
        statusText: err.response.statusText,
        message: 'Oops... something went wrong with your request!',
      });
    }
  }
}

export const weatherService = new WeatherService();
