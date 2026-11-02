### Analisis

En la clase InstrumentPlayer existe un metodo que pasa un String diferente para cada instrumento.
El problema es que para seguir el principio OCP deberiamos ser capaces de añadir instrumentos y funciones sin modficar directamente todo el codigo.
Tambièn diria que falta la clase Main que està en la misma clase de InstrumentPlayer.

### Refactoring

- he separado el Main
- He creado una interfaz Instrument y un objeto Guitar que implementa Interface
- Asi con un @Override le he dicho que cada vez que Instrument Player llame una Guitar tiene que hace un System Out con un String proprio
- De esa misma manera puedo añadir todos los instrumentos que quiero sin cambiar codigo