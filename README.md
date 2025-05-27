# GildedRose en Java
En este archivo se explican los cambios realizados en el proyecto GildedRose

## Malas prácticas detectadas

Durante el análisis del código original se identificaron las siguientes malas prácticas:

- **Código spaghetti y anidamientos excesivos**  
  Demasiados if anidados, lo cual reduce la legibilidad y vuelve difícil seguir la lógica.

- **No implementa DRY (Don't Repeat Yourself)**  
  Se repiten las mismas condiciones y operaciones varias veces, como if (items[i].quality < 50) o if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")).

- **Falta de modularidad**  
  Toda la lógica está contenida en un único método largo (updateQuality), sin métodos auxiliares.

- **No implementa SRP (Single Responsibility Principle)**  
  updateQuality tiene la responsabilidad de manejar todos los tipos de items y sus comportamientos en un solo bloque de código.

- **No implementa OCP (Open/Closed Principle)**  
  Carece de comportamiento propio. Sería más adecuado que cada tipo de ítem implemente su propia lógica de actualización, aplicando polimorfismo.

- **Mala legibilidad**  
Uso de nombres de string hardcodeados y sin abstraer reglas de negocio.

- **Falta de cohesión y acoplamiento fuerte**  
updateQuality depende directamente de nombres de items para decidir su comportamiento.

## Mejoras implementadas en el código

- Se dividió la lógica en métodos privados
    - updateAgedBrie, updateBackstagePass, updateRegularItem
    - increaseQuality, decreaseQuality
    - isSulfuras, isBackstagePass, isAgedBrie

- Se eliminó la anidación excesiva.

- Se mejoró la legibilidad usando nombres de método descriptivos.

- Se respetó DRY evitando repetir las condiciones if (item.quality < 50) o if (item.quality > 0) y encapsulándolas en increaseQuality y decreaseQuality.

- Se mejoró la modularidad separando en pequeños métodos reutilizables.

- Se facilitó la extensión del código al separar el comportamiento de los distintos tipos de item.

- El código es más mantenible y sencillo de entender.


## Commits registrados

1. Creé una carpeta para el proyecto GildedRose
2. Se extrajo el metodo isAgedBrie() para evitar la repetir código
3. Se extrajo el metodo isBackstagePass() para evitar la repetir código
4. Se extrajo el metodo isSulfuras() para evitar la repetir código
5. Se extrajo el metodo increaseQualityIfPossible() para incrementar la calidad en varias partes del código
6. Se cambiaron las restas de variables por -- y se corrigio una linea que forzaba una operacion matematica a siempre dar 0, haciendola 0 siempre
7. Se agregó un foreach y se actualizaron los métodos para funcionar con dicho cambio
8. Se extrae la lógica de la actualización de cada item específico

## Propuesta de mejora extra (3% extra) — Strategy Pattern
El siguiente paso sería desacoplar completamente la lógica de cada tipo de item usando Strategy Pattern.
Esto implicaría crear una interfaz **UpdateStrategy** y una clase concreta para cada tipo de item: **AgedBrieStrategy**, **BackstagePassStrategy**, **RegularItemStrategy**, etc.

Así en vez de **if** o **switch** de nombres, cada item tendría asociada una estrategia para actualizarse.
