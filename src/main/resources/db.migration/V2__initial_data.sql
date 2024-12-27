--Cargas Configuracoes
INSERT INTO configuracoes (capacidade_total, horario_funcionamento_inicio, horario_funcionamento_fim, tempo_maximo_permissao)
VALUES (50, '08:00', '22:00', 3.0);

--Carga tabela tarifas
INSERT INTO tarifas (valor_hora, valor_minuto, multa_por_atraso)
VALUES (5.0, 0.10, 20.0);

--Carga tabela capacidade estacionamento
INSERT INTO capacidade_estacionamento (capacidade_atual, capacidade_maxima, ultima_atualizacao)
VALUES (0, 50, CURRENT_TIMESTAMP);

--Carga tabela veiculos
INSERT INTO configuracoes (capacidade_total, horario_funcionamento_inicio, horario_funcionamento_fim, tempo_maximo_permissao)
VALUES (50, '08:00', '22:00', 3.0);

--Carga tabela registro estacionamento
INSERT INTO registros_estacionamento (hora_entrada, hora_saida, valor_pago, multa_aplicada, veiculo_id)
VALUES
('2024-12-27 09:00:00', '2024-12-27 12:00:00', 15.0, NULL, 1),
('2024-12-27 14:00:00', NULL, NULL, NULL, 2),
('2024-12-27 15:00:00', '2024-12-27 16:30:00', 7.5, 20.0, 3);


--Carga registro logs
INSERT INTO logs_sistema (data_hora, acao, detalhes)
VALUES
(CURRENT_TIMESTAMP, 'Inserção de Veículo', 'Veículo com placa ABC1234 foi registrado no sistema.'),
(CURRENT_TIMESTAMP, 'Entrada Registrada', 'Entrada do veículo XYZ9876 às 14:00.'),
(CURRENT_TIMESTAMP, 'Saída Registrada', 'Saída do veículo DEF5678 às 16:30 com multa.');

--Carga relatorios financeiros
INSERT INTO relatorios_financeiros (data, total_receita, multas_recebidas, total_veiculos_atendidos)
VALUES
('2024-12-26', 200.0, 40.0, 30),
('2024-12-27', 50.0, 20.0, 3);
