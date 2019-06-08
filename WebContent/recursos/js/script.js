$(document).ready(function() {
	listar();
});
function listar() {
	$
			.get(
					"mc",
					{
						opc : 1
					},
					function(data) {
						var x = JSON.parse(data);
						$('#tablita tbody').empty();
						var i;
						for (var i = 0; i < x.length; i++) {
							$("#tablita")
									.append(
											"<tr><td>"
													+ (i + 1)
													+ "</td>"
													+ "<td>"
													+ x[i].nombre
													+ "</td>"
													+ "<td>"
													+ x[i].titulo
													+ "</td>"
													+ "<td>"
													+ x[i].descripcion
													+ "</td>"
													+ "<td>"
													+ "<a href='#' style='color:green' onclick='modificar("
													+ x[i].idmensaje
													+ ")'>"
													+ "<i class='far fa-edit'></i>"
													+ "</a>"
													+ "</td"
													+ "<td>"
													+ "<a href='#' style='color:red' onclick='eliminar("
													+ x[i].idmensaje
													+ ")'>"
													+ "<i class='far fa-trash-alt'></i>"
													+ "</a>" + "</td" + "</tr>")
						}
					});
	$.get("mc", {
		opc : 4
	}, function(data) {
		var u = JSON.parse(data);
		var i;
		for (var i = 0; i < u.length; i++) {
			$("#user").append(
					"<option value='" + u[i].idusuario + "'>" + u[i].nombre
							+ "</option")
		}
	});
}
function eliminar(id) {
	bootbox.confirm({
		message : "Deseas eliminar este registro de mensaje..?",
		buttons : {
			confirm : {
				label : 'Yes',
				className : 'btn-success'
			},
			cancel : {
				label : 'No',
				className : 'btn-danger'
			}
		},
		callback : function(result) {
			if (result) {
				$.get("mc", {
					opc : 2,
					id : id
				}, function(data) {
					if (data == 1) {
						bootbox.alert("Mensaje eliminado correctamente.....!")
						listar();
					} else {
						bootbox.alert("No se elimino el mensaje.....!")
					}
				});
			} else {
				bootbox.alert("Se cancelo la solicitud.....!")
			}
		}
	});
}

function modificar(id) {
	$.get("mc", {
		opc : 3,
		id : id
	}, function(data) {
		alert(data);
	});
	$("#modificarModal").modal('show')
}
function update() {
	var titu2 = $("#titulo2").val();
	var descr2 = $("#descripcion2").val();
	alert(titu2+"/"+descr2);
	bootbox.confirm({
		message : "Deseas modificar este registro de mensaje..?",
		buttons : {
			confirm : {
				label : 'Yes',
				className : 'btn-success'
			},
			cancel : {
				label : 'No',
				className : 'btn-danger'
			}
		},
		callback : function(result) {
			if (result) {
				$.get("mc", {
					id : id,
					titu2:titu2,
					descr2:descr2,
					opc : 6
				}, function(data) {
					if (data == 1) {
						$("#modificarModal").modal('hide');
						bootbox.alert("Se modifico el mensaje correctamente.....!")
						listar();
					} else {
						bootbox.alert("No se modifico el mensaje.....!")
						$("#modificarModal").modal('hide');
					}
				});
			} else {
				bootbox.alert("Se cancelo la solicitud.....!")
			}
		}
	});
}
function registrar() {
	var user = $("#user").val();
	var titu = $("#titulo").val();
	var descr = $("#descripcion").val();
	// alert(user + "/" + titu + "/" + descr);
	$.post("mc", {
		user : user,
		titu : titu,
		descr : descr,
		opc : 5,
	}).done(function(data) {
		if (data == 1) {
			$("#id").val(0);
			bootbox.alert("Se registro correctamente.....!")
			listar();
			limpiar();
		} else {
			bootbox.alert("No se pudo registrar.....!")
			limpiar();
		}
	});
}

function limpiar() {
	$("#titulo").val("");
	$("#descripcion").val("");
	$("#id").focus();
}