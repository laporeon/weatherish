import { formatDate } from '../utils/date.js';
import { table } from '../utils/table.js';
import { formatTemperature } from '../utils/temperature.js';
import { Units } from '../utils/units.js';
import { convertWindSpeed } from '../utils/wind.js';

export class WeatherResponse {
  constructor() {
    this.date = new Date();
  }

  generateResponse(data, units) {
    const {
      name,
      main: { temp, feels_like, temp_max, humidity },
      wind: { speed },
    } = data;

    table.push([
      name,
      formatDate(this.date, Units[units].localTimeFormat),
      formatTemperature(temp, Units[units].temperatureUnit),
      formatTemperature(feels_like, Units[units].temperatureUnit),
      formatTemperature(temp_max, Units[units].temperatureUnit),
      convertWindSpeed(units, speed, Units[units].windSpeedUnit),
      `${humidity}%`,
    ]);

    console.log(table.toString());
  }
}
