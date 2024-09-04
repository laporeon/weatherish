export function convertWindSpeed(units, speed, speedUnit) {
  if (units === 'imperial') {
    return `${speed.toFixed(0)} ${speedUnit}`;
  }

  return `${(speed * 3.6).toFixed(0)} ${speedUnit}`;
}
