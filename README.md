FOROHUB CHALLENGE

El objetivo del proyecto es crear la version corta para el funcionamiento de un Foro de tópicos. Se deben implementar los endpoints para una base de datos de tópicos.

Tecnologias usadas en el proyecto:
---IDE IntelliJ  ---
--- DSK 17 o posterior
--- Insomnia
--- MySQL Workbench


Se implementan:
a) Acceso/Login  ---
b) Borrado Definitivo (DELETE) ---
c) Buscar tópico por Id (GET)  ---
d) Actualizar Tópico (PUT)     ---
e) Listar Topicos     (GET)    ---
f) Registro de Tópicos (POST)  ---

Se implementó la parte de seguridad con el tipo de autenticación stateless, utilizando el email y contrasena para validar el acceso a la API.

Se utilzó Insomnia para las pruebas con endpoints.
Al ejecutar el programa, se comienza utilizando Acceso/Login y enviando la peticion [SEND], para poder actualizar nuestro Token o clave,
hay que copiarlo antes de probar el resto de los endpoints, utilizamos el jwTtoken, pegandolo en la cabecera de Auth con Bearer token.

![login](https://github.com/user-attachments/assets/0d19f83e-fef4-4686-922e-30ab539fafe3)

Para probar el resto de las funciones hay que pegar nuestro token en el encabezado como se muestra en la imagen.

![solicitud get con id](https://github.com/user-attachments/assets/da00cc37-1878-4040-b04d-d2b02c842dfa).

![solicitud GET](https://github.com/user-attachments/assets/34f6e7d6-b2b4-47d5-94d5-46a80f961cf7)

En las imagenes anteriores pudimos ver las solicitudes para GET con id y para listar los topicos.

Tambien se retorna un mensaje al usuario para evitar repetir titulos o mensajes dentro de los tópicos.

![evitar repetir titulo y mensaje](https://github.com/user-attachments/assets/cc9117c4-b350-4b45-bb2f-9384b6e3854a)

Cuando enviamos una solicitud para crear un nuevo post se retorna el tipo de respuesta 201 Created.

![post-201 created](https://github.com/user-attachments/assets/2b4e9532-d898-4986-9fe0-0dbf8d521b73)

Se muestra el tipo de respuesta 204 cuando se borra uno de los tópicos.

![delete-respuesta 204](https://github.com/user-attachments/assets/92a5027c-9061-4d5a-9ae6-55c7ea617b0a)

Se muestra un ejemplo para actualizar datos con PUT.
![put-respuesta 200](https://github.com/user-attachments/assets/f026b877-6789-45b1-a628-83dbfc9591cb)








