# Proyecto Contable

Este proyecto es una aplicación de contabilidad desarrollada en Java utilizando Spring Boot y Gradle.

## Requisitos

- Java 11 o superior
- Gradle 6.0 o superior
- Base de datos compatible con JPA (por ejemplo, MySQL, PostgreSQL)

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/Leobor91/contable.git


## Estructura del Proyecto

- `src/main/java/com/contable/contable/domain/model`: Contiene las entidades JPA.
- `src/main/java/com/contable/contable/domain/repository`: Contiene las interfaces de los repositorios.
- `src/main/java/com/contable/contable/domain/service`: Contiene las implementaciones de los servicios.
- `src/main/java/com/contable/contable/application/dto`: Contiene los DTOs utilizados en la aplicación.
## Entidades

### `FinancialSummaryEntity`
Representa un resumen financiero con los siguientes campos:

- `id`: Identificador único.
- `month`: Mes del resumen.
- `totalEntries`: Total de entradas.
- `totalExits`: Total de salidas.
- `lastModified`: Fecha de última modificación.
- `year`: Año del resumen.

### `TransactionEntity`
Representa una transacción con los siguientes campos:

- `id`: Identificador único.
- `date`: Fecha de la transacción.
- `category`: Categoría de la transacción.
- `description`: Descripción de la transacción.
- `amount`: Monto de la transacción.
- `month`: Mes de la transacción.
- `type`: Tipo de transacción (entrada o salida).

### `AccountingCategoryEntity`
Representa una categoría contable con los siguientes campos:

- `id`: Identificador único.
- `name`: Nombre de la categoría.
- `description`: Descripción de la categoría.
- `type`: Tipo de categoría.
- `icon`: Ícono de la categoría.
- `color`: Color de la categoría.