# Spring Security JWT Örnek Projesi

Bu proje, Spring Security ve JWT (JSON Web Token) kullanarak güvenli bir REST API'nin nasıl oluşturulacağını gösteren örnek bir uygulamadır.

## 🛠 Kullanılan Teknolojiler
- Java 17+
- Spring Boot 3.x
- Spring Security
- JWT (JJWT Kütüphanesi)
- Lombok
- Maven

## 📌 Özellikler
- JWT tabanlı kimlik doğrulama
- Rol bazlı erişim kontrolü (ADMIN/USER)
- Güvenli endpoint yönetimi
- Özel kullanıcı kayıt sistemi

## 🚀 Kurulum
1. Docker'ı ayağa kaldırın.
2. Bağımlılıkları yükleyin:
```bash
mvn clean install
```

3. Uygulamayı çalıştırın:
```bash
mvn spring-boot:run
```

## 🔐 API Endpoint'leri

### 1. Kayıt Olma
```http
POST /auth/addNewUser
```
**Request Body:**
```json
{
    "name": "Mert",
    "username": "mertP",
    "password": "123",
    "authorities": ["ROLE_ADMIN"]
}
```

### 2. Token Alma (Login)
```http
POST /auth/generateToken
```
**Request Body:**
```json
{
    "username": "mertP",
    "password": "123"
}
```
**Response:**
```json
"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtZXJ0UCIsImlhdCI6MTcxMDAw..."
```

### 3. Korumalı Endpoint'ler
```http
GET /auth/user
```
**Gereksinimler:**
- Geçerli JWT Token (Bearer)

```http
GET /auth/admin
```
**Gereksinimler:**
- Geçerli JWT Token
- ADMIN rolü

## 🧪 Postman ile Test
1. **Token Alma:**
    - `POST /auth/generateToken` endpoint'ine kullanıcı bilgilerini gönderin
    - Gelen token'ı kopyalayın

2. **Yetkili İstekler:**
    - Authorization sekmesinde:
        - Type: **Bearer Token**
        - Token: Alınan JWT token'ı yapıştırın

   **Örnek Admin İsteği:**
   ```http
   GET http://localhost:8082/auth/admin
   ```

## 🚨 Sık Karşılaşılan Sorunlar
- **403 Forbidden:**
    - Token'ı doğru eklediğinizden emin olun
    - Kullanıcının gerekli role sahip olduğunu kontrol edin
- **401 Unauthorized:**
    - Token süresinin dolmadığını kontrol edin
    - Kullanıcı adı/şifrenin doğru olduğunu teyit edin
