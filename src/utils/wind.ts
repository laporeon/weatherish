export const convertWindSpeed = (
  units: string,
  speed: number,
  speedUnit: string,
) => {
  if (units === 'imperial') {
    return `${speed.toFixed(0)} ${speedUnit}`;
  }

  return `${(speed * 3.6).toFixed(0)} ${speedUnit}`;
};
