### Anàlisis

- El problema es que Ghost no puede recibir daño y siendo una subclase de Character se rompe porque tiene que tener un metodo que reciba daño.

### Solucion

- Lo unico que he tenido que hacer es remplazar el throw new con un String