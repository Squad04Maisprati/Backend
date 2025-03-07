ALTER TABLE transacao ADD CONSTRAINT fk_transacao_usuario
    FOREIGN KEY (usuario_id) REFERENCES usuario(id);
    ON DELETE CASCADE;