# ☕ Proyecto Gestion de expedientes (Java JAX-WS con Payara y MSSQL)

Este proyecto implementa un **servicio web JAX-WS** desarrollado en **Java SE 8**, utilizando el **servidor Payara 4.1.1.161** y una conexión a base de datos **Microsoft SQL Server** mediante el **JDBC Driver 8.4.1**.

---

## 🚀 Requisitos Previos

Antes de levantar el proyecto, asegúrate de tener instalado:

- **JDK 8** → [Descargar JDK 8](https://drive.google.com/drive/folders/1_peK8YuGVreEfd8CUKFcarbcKse_4rFH)
- **Apache NetBeans (versión 12 o superior)** → [Descargar NetBeans](https://installers.friendsofapachenetbeans.org/)
- **Payara Server 4.1.1.161** → Descargar dentro de apache netbeans al configurar el servidor
- **Microsoft JDBC Driver 8.4.1 para SQL Server** → [Descargar JDBC 8.4.1](https://drive.google.com/drive/folders/1-EvKMfMNFSHu1Oa0JfB-HQ5cnc-qhXIu)

---

## ⚙️ Configuración del Entorno

### 1️⃣ Importar el Proyecto

1. Abre **Apache NetBeans**.  
2. Ve a **File → Open Project**.  
3. Selecciona la carpeta del proyecto y haz clic en **Open**.

---

### 2️⃣ Agregar Payara Server

1. En NetBeans, ve a **Services → Servers**.  
2. Haz clic derecho y selecciona **Add Server**.  
3. Elige **Payara Server** y selecciona la versión **4.1.1.161**.  
4. Acepta el checkbox que aparece y instala la version.

---

### 3️⃣ Agregar el Driver JDBC

1. Descarga el archivo `mssql-jdbc-8.4.1.jre8.jar` desde alguno de los enlaces anteriores.  
2. En NetBeans, ve a **Tools → Libraries → New Library**.  
3. Nombra la librería como `MSSQL_JDBC_8.4.1`.  
4. Haz clic en **Add JAR/Folder** y selecciona el archivo `.jar` descargado.  
5. Guarda y **añade la librería al classpath del proyecto**:
   - Click derecho en tu proyecto → **Properties → Libraries → Add Library → MSSQL_JDBC_8.4.1**.

---

### 4️⃣ Configurar la Conexión a la Base de Datos

Edita el archivo de configuración o el código donde se crea la conexión JDBC que esta dentro de la carpeta 
src -> java -> Modelo -> csConexion.java, en ese archivo se configura la conexion a la base de datos, para eso se debe de tener configurada la conexion a la base de datos
