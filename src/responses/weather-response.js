import { formatDate } from '../utils/date.js';
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
      main: { temp, feels_like, humidity },
      wind: { speed },
    } = data;

    console.log(`
    📌 City: ${name}
    🕓 Local Time: ${formatDate(this.date, Units[units].localTimeFormat)}
    ⛅ Temperature: ${formatTemperature(temp, Units[units].temperatureUnit)}
    🔥 Feels like: ${formatTemperature(
      feels_like,
      Units[units].temperatureUnit,
    )}
    💨 Wind: ${convertWindSpeed(units, speed, Units[units].windSpeedUnit)}
    💦 Humidity: ${humidity}%
    `);
  }
}
