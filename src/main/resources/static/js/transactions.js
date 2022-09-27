$(document).ready(function() {
    getTransactions();
    $("#movementsTable").DataTable({
        language: {
            url: "//cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json"
        }
    })
})

async function getTransactions() {
    const rawResponse = await fetch('/movements/transaction', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        }
    });
    const movimientos = await rawResponse.json();

    let listadoMovimientos = '';

    for(let movimiento of movimientos){
        let btnEliminar = '<a class="btn-danger btn-sm sm-2" href="#" onclick="deleteUsuario('+movimiento.id_transaction+')">Eliminar</a>'
        let movimientoHtml = '<tr><td>'+movimiento.concept+'</td><td>'+movimiento.enterprise.name+'</td><td>'+movimiento.employee.nombreEmpleado+'</td><td>'+movimiento.mount+'</td><td>'+btnEliminar+'</td></tr>'
        listadoMovimientos += movimientoHtml;
    }
    document.querySelector('#movementsTable tbody').outerHTML = listadoMovimientos;
}

function deleteUsuario(id_transaction) {
    fetch('/movements/transaction/'+id_transaction, {
        'method': 'DELETE'
    }).then(()=>{
        console.log('removed');
    }).catch(err => {
        console.log(err);
    })
}