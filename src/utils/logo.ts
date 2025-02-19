import chalk from 'chalk';
import figlet from 'figlet';

export const displayLogo = () => {
  return console.log(
    chalk.green.bold(
      figlet.textSync('\nWeatherish', {
        font: 'Big',
        width: 80,
      }),
    ),
    '\n',
  );
};
