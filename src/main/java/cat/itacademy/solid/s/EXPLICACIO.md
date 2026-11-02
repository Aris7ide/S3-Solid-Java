### ANALISIS DE InvoiceService

La clase InvoiceService se està encargando de dos cosas diferentes, por un lado
està formateando la clase Invoice en un texto que se pueda guardar en un file de texto, 
y por el otro lado està guardando ese texto en una carpeta manejando exceptions.

Como dice el principio S de SOLID, SRP (single responsibility principle), cada clase deberia tener una sola responsabilidad,
y por esa razòn aqui se pueden separar responsabilidades para que sea mas accesible y mas facil de modificar y leer. 

Me imagino que el hecho de que la clase sea publica no significa que todos sus metodos y construcciones internas deban serlo.
Y al mismo tiempo no justifica el SRP, en este caso en un metodo publico se agrupan logicas de mundos diferentes, aunque estèn en
el mismo metodo publico.

### Refactoricacion 

- He pillado toda la parte de construccion del text con StringBuilder y con Refactor -> Extract Method he creado un metodo llamado getText().
- Copiado ese codigo de StringBuilder y pasado a una nueva clase TextFormatter que se encarga de eso.
- 
