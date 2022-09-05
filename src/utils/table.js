import Table from 'cli-table';
import { tableHeaders } from './chalk.js';

let table = new Table({
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
    `${tableHeaders('Cidade')}`,
    `${tableHeaders('Data')}`,
    `${tableHeaders('Hora Local')}`,
    `${tableHeaders('Temperatura')}`,
    `${tableHeaders('Vento')}`,
    `${tableHeaders('Umidade do ar')}`,
  ],
});

export { table };
