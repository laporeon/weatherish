import { formatDate } from '../utils/date.js';
import { convertWindSpeed } from '../utils/wind.js';
import { formatTemperature } from '../utils/temperature.js';

export class WeatherResponse {
  constructor() {
    this.date = new Date();
    this.localTimeFormat = 'pt-BR';
    this.tempUnit = '°C';
    this.windSpeedUnit = 'km/h';
  }

  generateResponse({ status, statusText }, weatherData, units) {
    const {
      name,
      main: { temp, temp_max, humidity },
      wind: { speed },
    } = weatherData;

    this.isImperial(units);

    console.log({
      status,
      code: statusText,
      data: {
        city: weatherData.name,
        localTime: formatDate(this.date, this.localTimeFormat),
        temperature: formatTemperature(temp, this.tempUnit),
        maxTemperature: formatTemperature(temp_max, this.tempUnit),
        humidity: `${humidity}%`,
        wind: convertWindSpeed(units, speed, this.windSpeedUnit),
      },
    });
  }

  isImperial = units => {
    if (units === 'imperial') {
      this.localTimeFormat = 'en-US';
      this.tempUnit = '°F';
      this.windSpeedUnit = 'mph';
    }
  };
}
