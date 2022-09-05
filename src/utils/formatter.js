export class Formatter {
  constructor() {
    this.date = new Date();
  }

  getFormattedDate() {
    return this.date.toLocaleDateString('pt-BR');
  }

  getFormattedTime() {
    return this.date.toLocaleTimeString('pt-BR');
  }
}
