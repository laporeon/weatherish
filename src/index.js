#!/usr/bin/env node

import { program } from 'commander';

import { weatherService } from './services/weather-service.js';
import { title } from './utils/chalk.js';

console.log(title('\nWeatherish'));

program
  .name('weatherish')
  .description('A CLI to check the weather from a city.')
  .version('1.0.0');

program
  .option('-c, --city <value...>', 'city name')
  .option('-u, --units <value...>', 'choose units of measurement', 'metric')
  .action(async options => {
    const { city, units } = options;

    await weatherService.execute(city, units);
  })
  .addHelpText(
    'after',
    `\nExamples:
    $ weather -c "Curitiba"
    $ weather -c "Curitiba" -u metric
    $ weather -c "Fortaleza" --units metric
    $ weather -c "London" -u imperial
    $ weather -c "California" --units imperial`,
  )
  .showSuggestionAfterError();

program.parse();
