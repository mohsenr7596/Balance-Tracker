# Wallet Microservice

![Wallet Microservice](https://github.com/mohsenr7596/balance-tracker/assets/24752632/dee3797b-003f-4e5e-be4c-3ff1a7b3c9bc)

A simple Spring Boot microservice for managing user wallet balances and transaction logs. Utilizes MySQL and Docker.

## API Endpoints

### Get Balance
- **URL**: `/api/wallet/get-balance`
- **Method**: `GET`
- **Params**: `user_id` (int)
- **Response**: `{"balance": 4000}`

### Add Money
- **URL**: `/api/wallet/add-money`
- **Method**: `POST`
- **Params**: `user_id` (int), `amount` (int)
- **Response**: `{"reference_id": 12312312312}`

## Setup

### Prerequisites
- Java 21
- Docker & Docker Compose

### Running
```bash
git clone https://github.com/yourusername/wallet-microservice.git
cd wallet-microservice
docker-compose up --build
