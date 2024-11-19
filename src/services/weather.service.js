import openWeatherBaseURL from '../config/api.js';

export async function getWeather(city, units) {
  const uri = `data/2.5/weather?q=${city}&appid=${process.env.API_KEY}&units=${units}`;

  const { data } = await openWeatherBaseURL.get(uri);

  return data;
}
