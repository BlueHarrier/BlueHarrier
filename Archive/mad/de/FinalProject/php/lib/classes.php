<?php
require_once("./lib/databases.php");
require_once("./lib/structure.php");

class Parque{
	public $exists;
	public $nombre;
	public $ubicacion;
	public $fecha_apertura;
	public $fecha_cierre;
	public $descripcion;
	public $foto;
	public $atracciones;
	private $conn;

	public function __construct($id){
		$this->tomar_datos($id);
	}

	private function tomar_datos($id){
		$query =
			"SELECT `Nombre_Parque`, `Descripcion`, `Ubicacion`,
			`Fecha_Apertura`, `Fecha_Cierre`, `idFoto`
			FROM `Parque`
			WHERE `idParque` = ?;
		";

		$this->conn = create_connection();
		$statement = $this->conn->prepare($query);
		$statement->bind_param("i", $id);
		$statement->execute();
		$result = $statement->get_result();
		if ($result == null) $this->exists = false;
		else{
			if ($result->num_rows == 0) $this->exists = false;
			else $this->exists = true;
		}
		if (!$this->exists) return;

		$park = $result->fetch_assoc();
		$this->nombre = $park["Nombre_Parque"];
		$this->ubicacion = $park["Ubicacion"];
		$this->fecha_apertura = $park["Fecha_Apertura"];
		$this->fecha_cierre = $park["Fecha_Cierre"];
		$this->descripcion = $park["Descripcion"];
		$this->foto = $park["idFoto"];
		$this->tomar_atracciones_actuales($id);
	}

	private function tomar_atracciones_actuales($id){
		$query =
			"SELECT atr.`idAtraccion`, atr.`Nombre`
			FROM `Registro de Servicios` AS reg
			INNER JOIN `Parque` AS park ON reg.`idParque` = park.`idParque`
			INNER JOIN `Atraccion` AS atr ON reg.`idAtraccion` = atr.`idAtraccion`
			WHERE park.`idParque` = ? AND reg.`Fecha_Cierre` IS NULL;
		";
		$statement = $this->conn->prepare($query);
		$statement->bind_param("i", $id);
		$statement->execute();
		$result = $statement->get_result();

		$this->atracciones = [];
		while ($row = $result->fetch_assoc()){
			$this->atracciones[$row["idAtraccion"]] = $row["Nombre"];
		}
	}

	public function generar_pagina(){
		if (!$this->exists){
			print_error("Error: no se ha encontrado el parque solicitado.");
			return;
		}

		$aside = [
			"Ubicación" => $this->ubicacion,
			"Fecha de apertura" => $this->fecha_apertura
		];
		if ($this->fecha_cierre != null) $aside["Fecha de cierre"] = $this->fecha_cierre;

		$list = [];
		$ids = array_keys($this->atracciones);
		$i = 0;
		foreach ($ids as $id){
			$name = $this->atracciones[$id];
			$list[$i] = "<a href=\"?type=1&id=$id\">$name</a>";
			$i++;
		}

		print_article_aside($this->foto, $aside);
		print_article_body($this->descripcion);
		echo "<div>Atracciones disponibles: <ul>";
		print_list_content($list);
		echo "</ul></div>";
	}
}

class Atraccion{
	public $exists;
	public $nombre;
	public $fabricante;
	public $intensidad;
	public $valoracion;
	public $descripcion;
	public $foto;
	public $servicios;
	public $incidencias;
	private $conn;

	public function __construct($id){
		$this->tomar_datos($id);
	}

	private function tomar_datos($id){
		$query =
			"SELECT `Nombre`, `Descripcion`, fab.`Nombre_Fabricante` AS 'Fabricante',
			`Intensidad`, `Valoracion`, `idFoto`
			FROM `Atraccion` AS atr
			INNER JOIN `Fabricante` AS fab ON atr.`id_Fabricante` = fab.`id_Fabricante`
			WHERE `idAtraccion` = ?;
		";

		$this->conn = create_connection();
		$statement = $this->conn->prepare($query);
		$statement->bind_param("i", $id);
		$statement->execute();
		$result = $statement->get_result();
		$this->exists = true;
		if ($result == null) $this->exists = false;
		else{
			if ($result->num_rows == 0) $this->exists = false;
			else $this->exists = true;
		}
		if (!$this->exists) return;

		$attraction = $result->fetch_assoc();
		$this->nombre = $attraction["Nombre"];
		$this->fabricante = $attraction["Fabricante"];
		$this->intensidad = $attraction["Intensidad"];
		$this->valoracion = $attraction["Valoracion"];
		$this->descripcion = $attraction["Descripcion"];
		$this->foto = $attraction["idFoto"];
		$this->tomar_registro_de_servicios($id);
		$this->tomar_registro_de_incidencias($id);
	}

	private function tomar_registro_de_servicios($id){
		$query =
			"SELECT park.`idParque`, park.`Nombre_Parque`,
			reg.`Fecha_Apertura`, reg.`Fecha_Cierre`
			FROM `Registro de Servicios` AS reg
			INNER JOIN `Atraccion` AS atr ON reg.`idAtraccion` = atr.`idAtraccion`
			INNER JOIN `Parque` AS park ON reg.`idParque` = park.`idParque`
			WHERE atr.`idAtraccion` = ?
			ORDER BY reg.`Fecha_Apertura`;
		";
		$statement = $this->conn->prepare($query);
		$statement->bind_param("i", $id);
		$statement->execute();
		$result = $statement->get_result();

		$i = 0;
		$this->servicios = [];
		while ($row = $result->fetch_assoc()){
			$this->servicios[$i] = [
				"id" => $row["idParque"],
				"parque" => $row["Nombre_Parque"],
				"apertura" => date_parse($row["Fecha_Apertura"])
			];
			if ($row["Fecha_Cierre"]) $this->servicios[$i]["cierre"] = date_parse($row["Fecha_Cierre"]);
			$i++;
		}
	}

	private function tomar_registro_de_incidencias($id){
		$query =
			"SELECT reg.`Fecha_Incidencia`, reg.`Descripcion_Incidencia`
			FROM `Atraccion` AS atr
			INNER JOIN `Registro de incidencias` AS reg ON atr.`idAtraccion` = reg.`idAtraccion`
			WHERE atr.`idAtraccion` = ?
			ORDER BY reg.`Fecha_Incidencia`;
		";
		$this->conn = create_connection();
		$statement = $this->conn->prepare($query);
		$statement->bind_param("i", $id);
		$statement->execute();
		$result = $statement->get_result();

		$i = 0;
		$this->incidencias = [];
		while ($row = $result->fetch_assoc()){
			$this->incidencias[$i] = [
				"incidencia" => date_parse($row["Fecha_Incidencia"]),
				"descripcion" => $row["Descripcion_Incidencia"]
			];
			$i++;
		}
	}

	public function generar_pagina(){
		if (!$this->exists){
			print_error("Error: no se ha encontrado la atracción solicitada.");
			return;
		}

		$aside = [
			"Fabricante" => $this->fabricante,
			"Intensidad" => $this->intensidad."/10",
			"Valoración" => $this->valoracion."/5"
		];

		$services = [];
		$i = 0;
		foreach ($this->servicios as $service){
			$services[$i] = [
				"<a href=\"?type=0&id=".$service["id"]."\">".$service["parque"]."</a>",
				$service["apertura"]["day"]."/".$service["apertura"]["month"]."/".$service["apertura"]["year"],
				array_key_exists("cierre", $service) ? $service["cierre"]["day"]."/".$service["cierre"]["month"]."/".$service["cierre"]["year"] : "Actualidad"
			];
			$i++;
		}

		$incidences = [];
		$i = 0;
		foreach ($this->incidencias as $incidence){
			$incidences[$i] = [
				$incidence["incidencia"]["day"]."/".$incidence["incidencia"]["month"]."/".$incidence["incidencia"]["year"],
				file_get_contents("./articles/".$incidence["descripcion"].".txt")
			];
			$i++;
		}

		print_article_aside($this->foto, $aside);
		print_article_body($this->descripcion);
		echo "
		<table>
			<thead>
				<tr>
					<td colspan=\"3\">Servicios de la atracción</td>
				</tr>
				<tr>
					<td>Parque</td>
					<td>Fecha de apertura</td>
					<td>Fecha de cierre</td>
				</tr>
			</thead>
			<tbody>";
		print_table_content($services);
		echo "</tbdoy></table>";
		echo "
		<table>
			<thead>
				<tr>
					<td colspan=\"2\">Incidentes de la atracción</td>
				</tr>
				<tr>
					<td>Fecha</td>
					<td>Descripción</td>
				</tr>
			</thead>
			<tbody>";
		print_table_content($incidences);
		echo "</tbdoy></table>";
	}
}
?>