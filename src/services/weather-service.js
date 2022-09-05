import 'dotenv/config';
import axios from 'axios';

import { Formatter } from '../utils/formatter.js';
import { table } from '../utils/table.js';
import { errorMessage } from '../utils/chalk.js';

class WeatherService {
  constructor() {
    this.url = 'http://api.weatherapi.com/v1/current.json';
    this.apiKey = process.env.API_KEY;
    this.formatter = new Formatter();
  }

  async execute(city) {
    try {
      const response = await axios.get(
        `${this.url}?key=${this.apiKey}&q=${city}`,
      );

      this.createWeatherDataTable(response.data);
    } catch (err) {
      console.log(errorMessage('Error'), {
        statusCode: err.response.status,
        message: 'Oops... something went wrong with your request!',
      });
    }
  }

  createWeatherDataTable(weatherData) {
    const {
      location: { name },
      current: { temp_c, wind_kph, humidity },
    } = weatherData;

    table.push([
      name,
      this.formatter.getFormattedDate(),
      this.formatter.getFormattedTime(),
      `${temp_c}°C`,
      `${wind_kph} km/h`,
      `${humidity}%`,
    ]);

    console.log(table.toString());
  }
}

export const weatherService = new WeatherService();
