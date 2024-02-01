
const {from, of} = require("rxjs");
const {delay, concatMap, map} = require("rxjs/operators");

const frutas = ["Pera", "Manzana", "Sandia", "Naranja"];

//Nuestro observable => Emitira una fruta cada segundo 
const frutasObs = from(frutas).pipe(
    concatMap(item => of(item).pipe(delay(1000)))
);

console.log("Voy a comprar futas.");

frutasObs.suscribe((fruta) => {
    console.log(`Me llego una ${fruta}`)
});

console.log("Ya realize el pedido.");