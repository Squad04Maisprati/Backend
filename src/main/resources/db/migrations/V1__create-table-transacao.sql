CREATE TABLE transacao(
    id SERIAL PRIMARY KEY,
    valor FLOAT NOT NULL,
    data DATE NOT NULL ,
    descricao TEXT NOT NULL ,
    fixo BOOLEAN NOT NULL

)