CREATE TABLE usuario(
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL ,
    senha VARCHAR(255) NOT NULL ,
    cpf CHAR(11) UNIQUE NOT NULL,
    numCelular VARCHAR(15)
    roles TEXT NOT NULL

)



