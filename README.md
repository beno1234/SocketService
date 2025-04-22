# 🧠 Java Terminal Chat Server

Este é um projeto simples de **servidor de chat em Java** utilizando `Socket`, `Thread`, e `PrintWriter`. Ele permite que múltiplos clientes se conectem simultaneamente e troquem mensagens entre si via terminal.

---

## 🚀 Funcionalidades

- Suporte a múltiplos clientes conectados simultaneamente
- Mensagens transmitidas em tempo real para todos os usuários conectados
- Registro de entrada e saída de usuários no terminal do servidor
- Controle de conexões com `Thread` para cada cliente
- Transmissão segura com `synchronized` em estruturas compartilhadas

---

## 📁 Estrutura do Projeto

```
seu-projeto/
├── src/
│   ├── Main.java            # Classe principal que inicia o servidor
│   └── ClientHandler.java   # Thread que gerencia cada cliente conectado
├── bin/                     # (Gerado na compilação) Arquivos .class
└── rodar.bat                # (Opcional) Script para compilar e rodar
```

---

## 🛠️ Como rodar

### Pré-requisitos

- Java JDK instalado (Java 11 ou superior recomendado)
- Terminal (Prompt de Comando, PowerShell ou terminal do VS Code)

### Passo a passo

1. Compile os arquivos Java:

```bash
javac -d bin src/*.java
```

2. Inicie o servidor:

```bash
java -cp bin src.Main
```

3. (Opcional) Use o script `.bat`:

Crie um arquivo `rodar.bat` com:

```bat
@echo off
javac -d bin src\*.java
java -cp bin src.Main
pause
```

---

## 💬 Como funciona

- O servidor escuta a porta `8089` e aceita múltiplas conexões.
- Cada conexão é tratada em uma nova thread pela classe `ClientHandler`.
- Mensagens enviadas por um cliente são transmitidas para todos os outros conectados.
- Quando um usuário digita `"sair"`, ele é desconectado e notificado aos demais.

---

## 🧬 Exemplo de execução

Servidor:

```
Servidor rodando na porta 8089
João conectou-se ao servidor
Maria conectou-se ao servidor
João desconectou-se
```

Cliente (via telnet, netcat ou cliente Java próprio):

```
João entrou no chat
Maria: Olá, João!
João: Oi, Maria!
```

---

## 📌 Observações

- Este projeto não inclui um cliente pronto, mas você pode usar ferramentas como:
  - `telnet localhost 8089`
  - `nc localhost 8089` (no Linux/macOS)
  - ou criar um cliente Java personalizado
- O projeto foi feito para fins didáticos, mas pode ser expandido facilmente para incluir autenticação, interface gráfica e mais.

---

## 📄 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---

## ✍️ Autor

Feito por [Seu Nome Aqui] 💻  
Conecte-se no [LinkedIn](https://www.linkedin.com) ou veja mais no [GitHub](https://github.com/seunome).
