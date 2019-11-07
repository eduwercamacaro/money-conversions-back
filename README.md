# money-conversions-back
API Rest for Money Conversions App

## Dependencias (Ubuntu)
- [Git](https://git-scm.com/) v2.+
- [Make](https://www.gnu.org/software/make/) v4.+
- [OpenJDK](https://openjdk.java.net/) v1.8.+
- [Docker](https://www.docker.com/) v18.09.+
##### Instalar git:
```
$ sudo apt install git
```
##### Instalar make:
```
$ sudo apt install make
```
##### Instalar Docker:
```
$ curl -fsSL https://get.docker.com -o get-docker.sh
$ sh get-docker.sh
```
o [Aquí](https://docs.docker.com/install/linux/docker-ce/ubuntu/)

## Comandos ([Make](https://www.gnu.org/software/make/))

##### Ejecutar servicio de base de datos:
```
$ make run-db
```
##### Ejecutar pruebas unitarias:
```
$ make test
```
##### Ejecutar aplicación (http://localhost:8080/rest):
```
$ make run
```