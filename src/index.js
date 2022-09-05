#!/usr/bin/env node

import { program } from 'commander';
import figlet from 'figlet';

import { cliName } from './utils/chalk.js';
import { weatherService } from './services/weather-service.js';

console.log(cliName(figlet.textSync('Weather CLI')));

program
  .name('weather-cli')
  .description('CLI to fetch weather data from a city.')
  .version('1.0.0');

program
  .command('fetch')
  .description('fetch weather data from a city.')
  .argument('<city>', 'city name')
  .action((city) => {
    weatherService.execute(city);
  })
  .addHelpText(
    'after',
    `\nExamples:
    $ weather-cli fetch "Curitiba"
    $ weather-cli fetch "Rio de Janeiro"`,
  )
  .showSuggestionAfterError();

program.parse();
