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

> En aquest apartat mostrem captures de pantalla, passos d'execució i proves funcionals que demostren el funcionament de la webApp.

- ✅ Proves:

Aquest són els nostres endpoints de la apiREST:

![image](https://github.com/user-attachments/assets/0242085b-1968-4b4b-b92a-1a2a7faa750a)

Com veiem tenim definits 3 controladors, producte, categoria i subcategoria. Si executem el getAll de producte podem veure com estan estructurades les dades:

![image](https://github.com/user-attachments/assets/22223b69-0702-43dd-b75e-8087ac43e8ec)

```
  {
    "name": "Coca-Cola",
    "description": "Llauna 33cl",
    "company": "Coca-Cola Company",
    "price": 1.2,
    "units": 100,
    "subcategoria": {
      "name": "Refrescos",
      "status": "Activa",
      "categoria": {
        "name": "Begudes",
        "status": "Activa"
      }
    }
  }
```

Per provar els endpoints hem fet webControllers que utilitzen els endpoints de la api per mostrar i gestionar les dades:

![image](https://github.com/user-attachments/assets/b58ca810-94ba-4141-b641-eb9a433a7b75)

Cada un d'aquest botons crida el endpoint getAll de la secció triada. El exemple triat és Productes:

![image](https://github.com/user-attachments/assets/861bf944-698f-4075-9c7e-9f47aafad472)

Com podem veure la url triada pel web controller és: http://localhost:8080/producte

També podem veure diferents botons que accionen diferents endpoints de la api:

1. Nou Producte - Post
2. Cerca Producte - GetByName

Si els accionem podem veure com la url canvia en el cas del Post: http://localhost:8080/producte/formulari

![image](https://github.com/user-attachments/assets/174d3d7d-5fa9-426a-8685-63ca6123a350)

Ara accionem guardar i tindriem que visualitzar-ho al /producte el producte afegit:



---

## ℹ️ Notes addicionals

- La BBDD s'ha de crear manualment i inicialitzar amb scripts `insert.sql`  
- MapStruct s'ha usat per mapejar entre entitats i DTOs de forma eficient  

---

## 🎓 Autors

Eric, Alex and Pau
