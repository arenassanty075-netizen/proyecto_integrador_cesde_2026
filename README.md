# proyecto_integrador_cesde_2026 (Backend)

## Descripción
API y lógica de negocio del proyecto integrador — Nuevas Tecnologías de Programación, CESDE 2026.
Desarrollado en Java con Maven, siguiendo arquitectura hexagonal (puertos y adaptadores).

## Integrantes del equipo
- Diana Marcela Arenas
- Santiago Arenas
- arenassanty075

## Estrategia de ramas (GitFlow)
- `main`: rama de producción, contiene versiones estables y listas para entrega.
- `develop`: rama de integración, donde se juntan todas las funcionalidades en desarrollo.
- `feature/nombre-funcionalidad`: ramas para cada nueva funcionalidad, creadas a partir de `develop` y fusionadas de vuelta a `develop`.
- `release/x.x.x`: rama de preparación de una nueva versión, creada a partir de `develop`, usada para ajustes finales antes de pasar a `main`.
- `hotfix/nombre-fix`: rama para corregir errores urgentes en producción, creada a partir de `main` y fusionada tanto a `main` como a `develop`.

## Arquitectura
El proyecto sigue una arquitectura hexagonal, organizada en:
- **Modelos**: entidades del dominio.
- **Repositorios**: puertos de acceso a datos.
- **Servicios**: lógica de negocio.
- **Controladores**: capa de entrada (API REST) — en desarrollo.

## Base de datos
- Motor: MySQL
- Configuración de conexión definida en el archivo de propiedades del proyecto (`application.yml` / `application.properties`).

## Convención de commits
Usamos Conventional Commits:
- `feat:` nueva funcionalidad
- `fix:` corrección de errores
- `docs:` cambios en documentación
- `style:` cambios de formato (sin afectar lógica)
- `refactor:` refactorización de código
- `construccion:` cambios de configuración/infraestructura del proyecto

Ejemplo: `feat: agregar conexión a base de datos MySQL`

## Pull Requests
- Todo cambio hacia `develop` debe hacerse mediante un Pull Request.
- Cada PR debe tener al menos 1 revisión aprobada antes del merge.
- El título del PR debe describir claramente el cambio realizado.

## Reglas de merge
- Se usará **squash and merge** para mantener un historial limpio.
- No se permite hacer merge directo a `main` sin pasar antes por `develop` (excepto hotfixes).
