import { format } from 'date-fns';

import { formatTemperature } from './temperature.js';
import { Units } from './units.js';
import { convertWindSpeed } from './wind.js';

export function generateResponse(data, units, datetime) {
  const {
    name,
    main: { temp, feels_like, humidity },
    wind: { speed },
  } = data;

  return console.log(`
    📌 City: ${name}
    🕓 Local Time: ${format(new Date(), datetime)}
    ⛅ Temperature: ${formatTemperature(temp, Units[units].temperatureUnit)}
    🔥 Feels like: ${formatTemperature(
      feels_like,
      Units[units].temperatureUnit,
    )}
    💨 Wind: ${convertWindSpeed(units, speed, Units[units].windSpeedUnit)}
    💦 Humidity: ${humidity}%
    `);
}
