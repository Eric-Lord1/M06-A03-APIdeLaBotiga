# Botiga amb API

L'aplicació simula una botiga on es poden gestionar productes, categories i subcategories, usant una API.

---

## 📦 Tecnologies utilitzades

- Java
- Spring Boot    
- MariaDB  
- HTML + CSS

---

## 🛠️ Estructura del projecte

L'estructura segueix el patró clàssic de Spring Boot:

- `controllers.api` – Controladors REST  
- `controllers.web` – Controladors per a les vistes  
- `models` – Entitats JPA  
- `services` – Lògica de negoci  
- `repos` – Interfícies JPA  
- `mapper` – Mapper DTO  
- `templates/` – Fitxers HTML  
- `static/css/` – Estils CSS  

---

## 🔗 Rutes principals (frontend)

- `/` – Pàgina d'inici  
- `/producte` – Llistar productes  
- `/producte/search` – Cercar per nom  
- `/producte/formulari` – Afegir producte  
- `/categoria` – Llistar categories
- `/categoria/formulari` – Afegir categories  
- `/subcategoria` – Llistar subcategories
- `/subcategoria/formulari` – Afegir subcategories
---

## ✅ Proves d'execució

> En aquest apartat s'han d'incloure captures de pantalla, passos d'execució i proves funcionals que demostren el funcionament del projecte.

- ✅ Prova: Accedir a la ruta `/producte` i verificar que es mostren els productes

---

## ℹ️ Notes addicionals

- La BBDD s'ha de crear manualment i inicialitzar amb scripts `insert.sql`  
- MapStruct s'ha usat per mapejar entre entitats i DTOs de forma eficient  

---

## 🎓 Autors

Eric, Alex and Pau
