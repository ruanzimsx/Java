-- =============================================================================
-- Criar o banco de dados e rodar o script de criação de tabela dentro
-- Banco com conexão configurada no projeto é o "jdbc" na porta "5432"
-- =============================================================================


CREATE TABLE "conta" (
	"codigo" SERIAL NOT NULL,
	"nome" varchar,
	"saldo" numeric(10,2),
	"limite" numeric(10,2),
  PRIMARY KEY("codigo")
);



CREATE TABLE "cliente" (
	"codigo" SERIAL NOT NULL,
	"nome" varchar,
	"salario" numeric(10,2),
  PRIMARY KEY("codigo")
);

