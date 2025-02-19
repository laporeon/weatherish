export type UnitType = 'metric' | 'imperial';

interface UnitConfig {
  localTimeFormat: string;
  temperatureUnit: string;
  windSpeedUnit: string;
}

export const Units: Record<UnitType, UnitConfig> = {
  metric: {
    localTimeFormat: 'pt-BR',
    temperatureUnit: '°C',
    windSpeedUnit: 'km/h',
  },
  imperial: {
    localTimeFormat: 'en-US',
    temperatureUnit: '°F',
    windSpeedUnit: 'mph',
  },
};
