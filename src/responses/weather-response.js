export class WeatherResponse {
  constructor() {
    this.date = new Date();
    this.localTimeFormat = 'pt-BR';
    this.tempUnit = '°C';
    this.windSpeedUnit = 'km/h';
    this.wind = '';
  }

  generateResponse({ status, statusText }, weatherData, units) {
    this.isImperial(units);
    this.convertWindSpeed(units, weatherData.wind.speed);

    console.log({
      status,
      code: statusText,
      data: {
        city: weatherData.name,
        localTime: this.formatDate(this.date),
        temperature: `${Math.round(weatherData.main.temp)}${this.tempUnit}`,
        maxTemperature: `${Math.round(weatherData.main.temp_max)}${this.tempUnit}`,
        humidity: `${weatherData.main.humidity}%`,
        wind: `${this.wind} ${this.windSpeedUnit}`,
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

  convertWindSpeed = (units, wind) => {
    if (units === 'imperial') {
      return (this.wind = `${wind.toFixed(0)}`);
    }

    return (this.wind = `${(wind * 3.6).toFixed(0)}`);
  };


  formatDate = (date) => {
    return new Intl.DateTimeFormat(`${this.localTimeFormat}`, {
      month: '2-digit',
      day: '2-digit',
      hour: '2-digit',
      minute: '2-digit'
    }).format(date)
  }
}
