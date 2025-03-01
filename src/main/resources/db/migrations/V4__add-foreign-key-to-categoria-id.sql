ALTER TABLE transacao ADD CONSTRAINT fk_transacao_categoria
    FOREIGN KEY (categoria_id) REFERENCES categoria(id);