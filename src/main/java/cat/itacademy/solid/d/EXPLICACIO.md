### Analisis

- Las operacion necesarias sobre las reservas son: guardar la reserva, encontrar por ID, ver todas las reservas y cancelar reservas.
- En el constructor de BookingService està especificado H2BookingRepository repository, eso significa que no aceptarà otro elemento que no sea una instancia de H2BookingRepository.
- porque en ninguna parte se incluye ese InMemoryBooking, habrà que especificar que repository usar antes de poder usar sus respectivos metodos.
- probablmente habrà que decidir el repositorio al arrancar la aplicaciòn, cuando pide que usar.

### Execuciòn 

- Creo una interfaz que pueda ser implementad por los repositories.
- Creo la interfaz repository y la implemento e los dos repositorios
- En el constructor de BookingService paso la interfaz Repository
- En BookingApp he cambiado la segunda opciòn para que pase el InMemoryBookingRepository al constructor como Repository
- En BookingConsole tambièn he cambiado el repository al interafaz Repository para que pueda acceptar cualquiera de los dos.

- Por lo de las horas de cancelacion, evidentemente usando LocalDateTime.now() el metodo pierde unos milisegundos que hacen que ya no son exactamente 24 horas. 
- Parece que usando el Clock, herramienta de Java que devuelve un tiempo exacto, se puede pasar un Clock.systemDefaultZone() que devuelve el tiempo exacto de tu OS.
- Asi he añadido el Clock a BookingService.
- Añadiendo un fixedClock en el Test y usando Clock el test pasa sin problemas.