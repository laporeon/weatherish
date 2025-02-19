import axios from 'axios';

const openWeatherBaseURL = axios.create({
  baseURL: 'https://api.openweathermap.org/',
});

export default openWeatherBaseURL;
