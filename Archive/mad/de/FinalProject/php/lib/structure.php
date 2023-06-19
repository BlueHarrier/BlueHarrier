<?php
function print_error($error){
	echo "
	<div class=\"error\">
		$error
	</div>
	";
}

function print_article_aside($pic_name, $content){
	$pic_path = "/images/db/$pic_name.png";
	$keys = array_keys($content);
	echo "
	<aside class=\"informacion\">
		<div><img src=\"$pic_path\"/></div>
	";
	foreach ($keys as $key){
		$val = $content[$key];
		echo"
			<div>
				<b>$key: </b>$val
			</div>
		";
	}
	echo "</aside>";
}

function print_article_body($art_name){
	$art_path = "./articles/$art_name.txt";
	$article = file_get_contents($art_path);
	echo "
	<article class=\"cuerpo\">
		$article
	</article>
	";
}

function print_list_content($content){
	foreach ($content as $item){
		echo "<li>$item</li>";
	}
}

function print_table_content($content){
	foreach ($content as $row){
		echo "<tr>";
		foreach ($row as $column){
			echo "<td>$column</td>";
		}
		echo "</tr>";
	}
}
?>