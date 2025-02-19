export const formatTemperature = (
  temperature: number,
  tempUnit: string,
): string => {
  return `${Math.round(temperature)}${tempUnit}`;
};
