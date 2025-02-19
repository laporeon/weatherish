import openWeatherBaseURL from '../config/api';

export async function getWeather(city: string, units: string) {
  const uri = `data/2.5/weather?q=${city}&appid=${process.env.API_KEY}&units=${units}`;

  const { data } = await openWeatherBaseURL.get(uri);

  return data;
}
