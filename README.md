# 🔗 URL Shortener API

Uma API simples de encurtamento de URLs desenvolvida em **Java** usando **Spring Boot** e **MongoDB**.  
Ela permite criar links encurtados, redirecionar para a URL original e gerenciar a expiração dos links.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3+**
- **Spring Data MongoDB**
- **Maven**

---

## ⚙️ Funcionalidades

- Encurtar URLs longas para identificadores únicos.
- Definir data de expiração do link (TTL - Time To Live).
- Redirecionamento automático ao acessar o link encurtado.
- Persistência de dados em **MongoDB**.
- Endpoint para consultar informações da URL encurtada.

---

## 📌 Endpoints

### Criar uma URL encurtada
```http
POST /url-shorten
Content-Type: application/json

{
  "url": "https://www.google.com",
}

GET /{id}
