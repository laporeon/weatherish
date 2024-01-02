import ora from 'ora';

export const spinner = ora({
  prefixText: '\n',
  text: `Fetching Weather...`,
  spinner: 'dots',
  color: 'green',
});
