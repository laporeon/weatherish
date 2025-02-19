import { format } from 'date-fns';

import { formatTemperature } from './temperature';
import { Units, type UnitType } from './units';
import { convertWindSpeed } from './wind';

interface IWeatherData {
  name: string;
  main: {
    temp: number;
    feels_like: number;
    humidity: number;
  };
  wind: {
    speed: number;
  };
}

export const generateResponse = (
  data: IWeatherData,
  units: UnitType,
  datetime: string,
) => {
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
};
