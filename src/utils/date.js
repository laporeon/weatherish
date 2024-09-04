export function formatDate(date, localTimeFormat) {
  return new Intl.DateTimeFormat(`${localTimeFormat}`, {
    month: '2-digit',
    day: '2-digit',
    hour: '2-digit',
    minute: '2-digit',
  }).format(date);
}
