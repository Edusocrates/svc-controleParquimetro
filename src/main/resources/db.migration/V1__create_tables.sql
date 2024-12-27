CREATE TABLE configuracoes (
    id SERIAL PRIMARY KEY,
    capacidade_total INT NOT NULL,
    horario_funcionamento_inicio VARCHAR(5) NOT NULL,
    horario_funcionamento_fim VARCHAR(5) NOT NULL,
    tempo_maximo_permissao DOUBLE PRECISION NOT NULL
);

CREATE TABLE tarifas (
    id SERIAL PRIMARY KEY,
    valor_hora DOUBLE PRECISION NOT NULL,
    valor_minuto DOUBLE PRECISION NOT NULL,
    multa_por_atraso DOUBLE PRECISION NOT NULL
);

CREATE TABLE capacidade_estacionamento (
    id SERIAL PRIMARY KEY,
    capacidade_atual INT NOT NULL,
    capacidade_maxima INT NOT NULL,
    ultima_atualizacao TIMESTAMP NOT NULL
);

CREATE TABLE veiculos (
    id SERIAL PRIMARY KEY,
    placa VARCHAR(10) UNIQUE NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    cor VARCHAR(50) NOT NULL
);

CREATE TABLE registros_estacionamento (
    id SERIAL PRIMARY KEY,
    hora_entrada TIMESTAMP NOT NULL,
    hora_saida TIMESTAMP,
    valor_pago DOUBLE PRECISION,
    multa_aplicada DOUBLE PRECISION,
    veiculo_id INT NOT NULL REFERENCES veiculos (id) ON DELETE CASCADE
);

CREATE TABLE logs_sistema (
    id SERIAL PRIMARY KEY,
    data_hora TIMESTAMP NOT NULL,
    acao VARCHAR(255) NOT NULL,
    detalhes TEXT
);

CREATE TABLE relatorios_financeiros (
    id SERIAL PRIMARY KEY,
    data DATE NOT NULL,
    total_receita DOUBLE PRECISION NOT NULL,
    multas_recebidas DOUBLE PRECISION NOT NULL,
    total_veiculos_atendidos INT NOT NULL
);
