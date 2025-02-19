#!/usr/bin/env node

import inquirer from 'inquirer';
import 'dotenv/config';

import { getWeather } from './services/weather-service';
import { displayLogo } from './utils/logo';
import { spinner } from './utils/ora';
import { generateResponse } from './utils/response';

displayLogo();

inquirer
  .prompt([
    {
      type: 'input',
      message: 'Enter the city name:',
      name: 'city',
      validate(answer) {
        if (answer.length === 0) {
          return "City name can't be empty!";
        }

        return true;
      },
    },
    {
      type: 'list',
      name: 'units',
      message: 'Choose what measurement unit you want to use:',
      default: 'metric',
      choices: ['metric', 'imperial'],
    },
    {
      type: 'list',
      name: 'date',
      message: 'Choose how you want to display date: ',
      default: 'dd/MM/YYYY',
      choices: ['dd/MM/yyyy', 'MM/dd/yyyy'],
    },
    {
      type: 'list',
      name: 'time',
      message: 'Choose how you want to display time:',
      default: 'HH:MM',
      choices: ['HH:MM', 'hh:mm a'],
    },
  ])
  .then(async answers => {
    const { city, units, date, time } = answers;

    const datetime = `${date} ${time}`;

    spinner.start();

    const data = await getWeather(city, units);

    spinner.stop();

    generateResponse(data, units, datetime);
  })
  .catch(error => {
    spinner.stop();

    console.error('\nError', {
      statusCode: error.response.status,
      statusText: error.response.statusText,
      message: 'Oops... something went wrong with your request!',
    });
  });
