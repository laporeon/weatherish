import Table from 'cli-table';

import { tableHeaders } from './chalk.js';

export const table = new Table({
  chars: {
    top: '═',
    'top-mid': '╤',
    'top-left': '╔',
    'top-right': '╗',
    bottom: '═',
    'bottom-mid': '╧',
    'bottom-left': '╚',
    'bottom-right': '╝',
    left: '║',
    'left-mid': '╟',
    mid: '─',
    'mid-mid': '┼',
    right: '║',
    'right-mid': '╢',
    middle: '│',
  },
  head: [
    `${tableHeaders('City')}`,
    `${tableHeaders('Local Time')}`,
    `${tableHeaders('Temperature')}`,
    `${tableHeaders('Feels Like')}`,
    `${tableHeaders('Max Temperature')}`,
    `${tableHeaders('Wind')}`,
    `${tableHeaders('Humidity')}`,
  ],
});
