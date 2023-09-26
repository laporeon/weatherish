#!/usr/bin/env node

import { program } from 'commander';
import figlet from 'figlet';

import { weatherService } from './services/weather-service.js';

console.log(
  figlet.textSync('Weather CLI', {
    font: 'Standard',
    horizontalLayout: 'fitted',
  }),
);

program
  .name('weather-cli')
  .description('CLI to fetch weather data from a city.')
  .version('1.0.0');

program
  .command('fetch')
  .description('fetch weather data from a city.')
  .argument('<city>', 'city name')
  .option('-u, --units <value...>', 'choose units of measurement')
  .action(async (city, options) => {
    let units = options.units ?? 'metric';

    await weatherService.execute(city, units);
  })
  .addHelpText(
    'after',
    `\nExamples:
    $ weather-cli fetch "Curitiba"
    $ weather-cli fetch "Curitiba" -u metric
    $ weather-cli fetch "Fortaleza" --units metric
    $ weather-cli fetch "London" -u imperial
    $ weather-cli fetch "California" --units imperial`,
  )
  .showSuggestionAfterError();

program.parse();
