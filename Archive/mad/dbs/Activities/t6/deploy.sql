USE 23_db_Daniel_nominas;

#-- Tipos aplicables
CREATE TABLE IF NOT EXISTS tipos_aplicables(
    tipo_base_id    INT(11)         NOT NULL    AUTO_INCREMENT,
    nombre          VARCHAR(20)     NOT NULL,
    porcentaje      REAL            NOT NULL,
    PRIMARY KEY (tipo_base_id)
);

#-- Trabajadores
CREATE TABLE IF NOT EXISTS trabajadores(
    trabajador_id   INT(11)         NOT NULL    AUTO_INCREMENT,
    nif             VARCHAR(9)      NOT NULL,
    nombre          VARCHAR(20)     NOT NULL,
    ape1            VARCHAR(20)     NOT NULL,
    ape2            VARCHAR(20)     NOT NULL,
    nss             BIGINT(12)      NOT NULL,
    PRIMARY KEY (trabajador_id)
);

#-- Empresa
CREATE TABLE IF NOT EXISTS empresas(
    empresa_id  INT(11)         NOT NULL    AUTO_INCREMENT,
    cif         VARCHAR(9)      NOT NULL,
    nombre      VARCHAR(50)     NOT NULL,
    dir         VARCHAR(50)     NOT NULL,
    cp          INT(5)          NOT NULL,
    prov        VARCHAR(20)     NOT NULL,
    ccc         BIGINT(11)      NOT NULL,
    PRIMARY KEY (empresa_id)
);

#-- Características del contrato
CREATE TABLE IF NOT EXISTS categorias(
    categoria_id        INT(11)         NOT NULL    AUTO_INCREMENT,
    nombre_categoria    VARCHAR(50)     NOT NULL,
    PRIMARY KEY (categoria_id)
);

CREATE TABLE IF NOT EXISTS cotizaciones(
    cotizacion_id          INT(11)         NOT NULL    AUTO_INCREMENT,
    grupo_de_cotizacion    VARCHAR(20)     NOT NULL,
    PRIMARY KEY (cotizacion_id)
);

CREATE TABLE IF NOT EXISTS tipos_de_contrato(
    tipo_de_contrato_id INT(11)         NOT NULL    AUTO_INCREMENT,
    nombre              VARCHAR(50)     NOT NULL,
    PRIMARY KEY (tipo_de_contrato_id)
);

CREATE TABLE IF NOT EXISTS contratos(
    contrato_id         INT(11)         NOT NULL    AUTO_INCREMENT,
    fecha_alta          DATE            NOT NULL,
    fecha_baja          DATE            NULL,
    tipo_de_contrato_id INT(11)         NOT NULL,
    trabajador_id       INT(11)         NOT NULL,
    empresa_id          INT(11)         NOT NULL,
    cat_id              INT(11)         NOT NULL,
    cot_id              INT(11)         NOT NULL,
    PRIMARY KEY (contrato_id)
);

ALTER TABLE contratos
    ADD CONSTRAINT fk_contratos_tipos_de_contrato_id
        FOREIGN KEY (tipo_de_contrato_id) REFERENCES tipos_de_contrato (tipo_de_contrato_id),
    
    ADD CONSTRAINT fk_contratos_trabajador_id
        FOREIGN KEY (trabajador_id) REFERENCES trabajadores (trabajador_id),

    ADD CONSTRAINT fk_contratos_empresa_id
        FOREIGN KEY (empresa_id) REFERENCES empresas (empresa_id),

    ADD CONSTRAINT fk_contratos_cat_id
        FOREIGN KEY (cat_id) REFERENCES categorias (categoria_id),
    
    ADD CONSTRAINT fk_contratos_cot_id
        FOREIGN KEY (cot_id) REFERENCES cotizaciones (cotizacion_id);

#-- Conceptos y bases de cotización
CREATE TABLE IF NOT EXISTS tipos_de_conceptos(
    tipo_de_concepto_id INT(11)         NOT NULL    AUTO_INCREMENT,
    nombre              VARCHAR(20)     NOT NULL,
    tipo                INT(11)         NOT NULL,
    PRIMARY KEY (tipo_de_concepto_id)
);

CREATE TABLE IF NOT EXISTS conceptos_de_salario(
    concepto_id         INT(11)         NOT NULL    AUTO_INCREMENT,
    contrato_id         INT(11)         NOT NULL,
    tipo_de_concepto_id INT(11)         NOT NULL,
    cantidad            INT(11)         NOT NULL,
    PRIMARY KEY (concepto_id)
);

ALTER TABLE conceptos_de_salario
    ADD CONSTRAINT fk_conceptos_de_salario_tipos_de_concepto_id
        FOREIGN KEY (tipo_de_concepto_id) REFERENCES tipos_de_conceptos (tipo_de_concepto_id),
    
    ADD CONSTRAINT fk_conceptos_de_salario_contrato_id
        FOREIGN KEY (contrato_id) REFERENCES contratos (contrato_id);

CREATE TABLE IF NOT EXISTS bases_de_cotizacion(
    base_cot_id     INT(11)         NOT NULL    AUTO_INCREMENT,
    contrato_id     INT(11)         NOT NULL,
    cantidad        INT(11)         NOT NULL,
    PRIMARY KEY (base_cot_id)
);

ALTER TABLE bases_de_cotizacion
    ADD CONSTRAINT fk_bases_de_cotizacion_bases_contrato_id
        FOREIGN KEY (contrato_id) REFERENCES contratos (contrato_id);

#-- Deducciones y tipos
CREATE TABLE IF NOT EXISTS tipos_de_deducciones(
    tipo_deduccion_id   INT(11)     NOT NULL    AUTO_INCREMENT,
    nombre              VARCHAR(20) NOT NULL,
    receptor            VARCHAR(20) NOT NULL,
    PRIMARY KEY (tipo_deduccion_id)
);

CREATE TABLE IF NOT EXISTS deducciones(
    deduccion_id        INT(11)     NOT NULL    AUTO_INCREMENT,
    tipo_deduccion_id   INT(11)     NOT NULL,
    anho                INT(11)     NOT NULL,
    mes                 INT(11)     NOT NULL,
    trabajador_id       INT(11)     NOT NULL,
    contrato_id         INT(11)     NOT NULL,
    cantidad            INT(11)     NOT NULL,
    PRIMARY KEY (deduccion_id)
);

ALTER TABLE deducciones
    ADD CONSTRAINT fk_deducciones_tipos_deduccion_id
        FOREIGN KEY (tipo_deduccion_id) REFERENCES tipos_de_deducciones (tipo_deduccion_id),

    ADD CONSTRAINT fk_deducciones_trabajador_id
        FOREIGN KEY (trabajador_id) REFERENCES trabajadores (trabajador_id),
    
    ADD CONSTRAINT fk_deducciones_contrato_id
        FOREIGN KEY (contrato_id) REFERENCES contratos (contrato_id);