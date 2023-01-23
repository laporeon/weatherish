import { formatDate } from '../utils/date.js';
import { convertWindSpeed } from '../utils/wind.js';
import { formatTemperature } from '../utils/temperature.js';
import { Units } from '../utils/units.js';

export class WeatherResponse {
  constructor() {
    this.date = new Date();
  }

  generateResponse({ status, statusText }, weatherData, units) {
    const {
      name,
      main: { temp, temp_max, humidity },
      wind: { speed },
    } = weatherData;

    console.log({
      status,
      code: statusText,
      data: {
        city: name,
        localTime: formatDate(this.date, Units[units].localTimeFormat),
        temperature: formatTemperature(temp, Units[units].temperatureUnit),
        maxTemperature: formatTemperature(temp_max, Units[units].temperatureUnit),
        humidity: `${humidity}%`,
        wind: convertWindSpeed(units, speed, Units[units].windSpeedUnit),
      },
    });
  }
}
