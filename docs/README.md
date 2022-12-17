<h1 align="center"> ⛅ Weather CLI</h1>

<p align="center">
  <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-sobre-o-projeto">Sobre o projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-como-executar">Como executar</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-licença">Licença</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
</p>


<br>

## ✨ Tecnologias

Esse projeto foi desenvolvido usando as seguintes techs:

[Node.js](https://nodejs.org/en/) | [Chalk](https://github.com/chalk/chalk) | [Commander](https://www.npmjs.com/package/commander) | [Figlet](https://www.npmjs.com/package/figlet) | [OpenWeather API](https://openweathermap.org/api)

<br>


## 💻 Sobre o projeto

Este é um projeto pessoal feito para aprender um pouco sobre o funcionamento de CLI's. É uma CLI simples que retorna dados sobre o clima de uma cidade, sendo eles: horário local e temperatura atual, temperatura máxima, umidade do ar e velocidade do vento.

![project](https://user-images.githubusercontent.com/34722707/208252090-11f7890a-4b58-434c-b090-b6b2fad2d776.png)

<br>

## 🚀 Como executar

### **Pré-requisitos:**

Antes de começar, por favor, verifique que você atende aos seguintes requisitos:

- Você possui [Node.js](https://nodejs.org/en/) instalado em sua máquina, na versão 16.x.x ou mais atual.

Após isso, você pode seguir os passos abaixo:

- Clone o projeto e acesse a pasta:

```bash 
$ git clone https://github.com/laporeon/weather-cli && cd weather-cli
```
- Instale as dependências
```bash
$ npm i
```
- Agora, ainda dentro da pasta do projeto, use o comando abaixo para instalar a CLI de forma global na sua máquina:
```bash
$ npm install -g .
```
Isso vai permitir que você use os comandos sem precisar estar dentro da pasta do projeto.


### **Uso:**

Este projeto aceita duas unidades de medida: metric and imperial. Essa opção não é obrigatória, porém, se você não passar nenhuma delas, a unidade de medida padrão será `metric` e o horário e formato da data local serão mostrados em `pt_BR`. Se você escolher passar `imperial` como unidade de medida, todos os dados sobre o clima serão mostrados em `Fahrenheit` e o formato de data e hora será mostrado em `en_US`.

***Examploss***:

- Padrão:

```bash
$ weather-cli fetch "Curitiba" # os dados serão mostrados em Celsius e a data/hora em Português Brasileiro
```
![default](https://user-images.githubusercontent.com/34722707/208251993-97d30b9f-332d-4c34-8093-8f52ff8a3509.png)

- Passando a unidade `imperial` como opção:

```bash
$ weather-cli fetch "London" --units imperial # os dados serão mostrados em Fahrenheit e a data/hora em Inglês.
```
![imperial](https://user-images.githubusercontent.com/34722707/208251994-fc7cf988-d21c-4ffd-8cc6-6ed558d8491a.png)

<br>

## 📝 Licença

Esse projeto está sob a licença MIT. Veja o arquivo [LICENSE](../LICENSE.md) para mais detalhes.

[⬆ Volte para o topo](#--weather-cli)

