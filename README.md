# Conversor de Moedas

Este projeto é um **Conversor de Moedas** em Java, usando Spring Boot, que consome taxas de câmbio em tempo real da ExchangeRate-API e oferece uma interface de console interativa.

---

## 📋 Requisitos

* Java 11 ou superior
* Maven 3.x
* Conta na [ExchangeRate-API](https://www.exchangerate-api.com) para obter uma API Key gratuita
* Internet para chamadas à API

---

## 🚀 Uso

Ao executar, você verá no console um menu com as **6 moedas** disponíveis:

```
--- Conversor de Moedas ---
1) ARS
2) BOB
3) BRL
4) CLP
5) COP
6) USD
7) Sair
Escolha a moeda de origem:
```

Digite o número correspondente, depois digite o valor a converter. Exemplo:

```
Escolha a moeda de origem: 6
Escolha a moeda de destino: 3
Valor a converter: 100
100.00 USD = 530.12 BRL
```

Para **sair**, escolha a opção `7`.

---
