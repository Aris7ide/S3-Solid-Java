### Anàlisis

- El problema es que Ghost no puede recibir daño y siendo una subclase de Character se rompe porque tiene que tener un metodo que reciba daño.

### Solucion

- Lo unico que he tenido que hacer es remplazar el throw new con un String
- En realidad, pensando otra vez en el principio de substituciòn he preferido añadir una interfaz TakeDamage para que Ghost pueda remplazar Character sin excepciones.
- le he añadido una interfaz para los personajes como el ghost que solo puede recibir daños por magias.