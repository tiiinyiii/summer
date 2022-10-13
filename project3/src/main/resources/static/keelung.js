function btn(zone){
    $(".card-group").empty();
    $.ajax({
        url: 'SightAPI',
        type: 'get',
        success: function(sight){
            for(i = 0;i<41;i++){
                if(sight[i].zone==zone){
                    $('.card-group').append(
                        '<div class="col-sm-4">' +
                        '<div class="card border-dark mb-3" style="width: 25rem;">' +
                        '<div class="card-body">' +
                        '<div class="card-header">'  + '<h4> ' + '<strong>' + sight[i].sightName + '</strong>' + '</h4>' + '</div>' + '<br>' +
                        '<p class="card-text" style="color:blue;">' + sight[i].zone + '</p>' +
                        '<p class="card-text" style="color:blue;">' + sight[i].category + '</p>' +
                        '<a href="https://www.google.com/maps/search/?api=1&query=' + sight[i].address + '" class="btn btn-link" target="_blank" style="color:blue;">' + sight[i].address+'</a>' + '<br>' +
                        '<button class="btn btn-outline-secondary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample' + i + '" aria-expanded="false" aria-controls="collapseExample">' +
                        "詳細資訊" +
                        '</button>' +
                        '</div>' +
                        '<div class="collapse" id="collapseExample' + i + '">' +
                        '<img src= "' + sight[i].photoURL + '" class="card-img-top" >' +
                        '<div class="card card-body">' + sight[i].des + '</div>' +
                        '</div>' +
                        '</div>' +
                        '</div>'
                    )
                }

            }
        },
        error: function(){
            alert("QQ");
        }
    })
}

/*
fetch('http://127.0.0.1:8080/SightAPI?zone=中山',{mode:"cors"})
    .then((response) => {

        return response.json();
    })
    .then( (response) => {
        console.log(response);
    })
    .catch((error) => {
        //console.log(`Error: ${error}`);
    })

*/
