//leaves spaces blank
const clearAll= () => {
    let nombre = document.getElementById("inputName");
    nombre.value = "";

    let inicio = document.getElementById("inputDateBegining");
    inicio.value = "";
    let fin = document.getElementById("inputDateEnd");
    fin.value = "";

    let descripcion = document.getElementById("inputDescription");
    descripcion.value ="";
    let available = document.getElementById("available");
    available.outerHTML = '<input class="form-check-input" type="checkbox" value="" id="available">';

    if(document.getElementById("btnCambios") != null){
        let boton = document.getElementById("btnCambios");
        boton.outerHTML = '<button type="button" class="btn btn-primary mt-1" id="btnOferta">Subir oferta</button>';
        $('#btnOferta').click(() => createOfferAndDisplay());
    } else {
        $('#btnCambios').click(() => updateOffers(id));
    }
    
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////
// deletes an offer, gets the new list of offers and displays it
const deleteOfferAndUpdate = async (id) => {
    let request = await fetch("/api/v1/offers/" + id, {
        method: 'DELETE',
    });

    if(request.ok) {
        console.log("oferta eliminada");
        getOffersAndDisplay();        
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////
// creates an offer, gets the new list of offers and displays it
const createOfferAndDisplay = async () => {

    let dates = await getDates();
    begin = dates.begining;
    end = dates.end;

    let txt_body = '{ "offerName": "'
        + $('#inputName').val()
        + '", "dateBegining": "'
        + begin
        + '", "dateEnd": "'
        + end
        + '", "offerDescription": "'
        + $('#inputDescription').val()
        + '", "offerAvailable": "'
        + $('#available').val()
        + '"}';

    let request = await fetch("/api/v1/offers", {
        body: txt_body,
        method: 'POST',
        body: txt_body,
        headers: {
            "Content-Type": "application/json", // Indico que mis datos van a estar en JSON
        },
        dataType: "json",
    });

    if(request.ok) {
        console.log("oferta creada");
        clearAll();
        getOffersAndDisplay();
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////
const getDates = async () => {
    let a = $('#inputDateBegining').val();
    let b = $('#inputDateEnd').val();

    let begining = a.substr(-4,4) + '-' + a.substr (3,2) + '-' + a.substr(0,2);
    let end = b.substr(-4,4) + '-' + b.substr (3,2) + '-' + b.substr(0,2);

    return {begining, end}
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////
const getAvailable = async () => {
    let available = document.getElementById("available");
    let txtAvailable;
        
    if (available.outerHTML = '<input class="form-check-input" type="checkbox" value="" id="available">') {
        txtAvailable == "No disponible";
    } else {
        txtAvailable == "Disponible"
    }

    return txtAvailable;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////
// gets the new list of offers and displays it
const getOffersAndDisplay = async () => {
    let request = await fetch("/api/v1/offers", {
        method: 'GET',
    });

    if(request.ok) {
        let res = await request.json();

        let text = '<ul class="list-group">';
        res.forEach(obj => {
            text += '<li class="list-group-item">'
            +  obj.offerName + ', de ' + obj.dateBegining + ' a ' + obj.dateEnd
            + '<div class="btn-group" role="group" aria-label="button group" style="float:right"> <button type="submit" class="btn btn-secondary"'
            + ' id="' + obj.id
            + 'edit_btn">Editar</button> <button type="submit" class="btn btn-danger"'
            + ' id="' + obj.id
            + 'delete_btn">Eliminar</button></div> </li>';
        });
        text += '</ul>';
        $('#offerList').html(text);

        res.forEach(obj => {
            $('#' + obj.id + 'delete_btn').click(() => deleteOfferAndUpdate(obj.id));
        });

        res.forEach(obj => {
            $('#' + obj.id + 'edit_btn').click(() => editOffer(obj.id));
        });
    }

    //let val = $('#inputDateBegining').val();
    //console.log(val);
}

/////////////////////////////////////////////////////////////////////////////////

$('#btnOferta').click(() => createOfferAndDisplay());
getOffersAndDisplay();




// Si das a editar una oferta y, sin guardar editas otra, se actualizan las dos
