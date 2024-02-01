
const {from, of, zip} = require("rxjs");
const {delay, concatMap} = require("rxjs/operators");


const frutas = ["Pera", "Manzana", "Sandia", "Naranja"];
const verduras = ["Lechuga", "Brocoli", "Pepino", "Coliflor", "Zanahoria"];


console.log("Voy a comprar futas.");

// Obs 1 => Emitira una fruta cada segundo 
const frutasObs = from(frutas).pipe(
    concatMap(item => of(item).pipe(delay(1000)))
);

// Obs 2
const verdurasObs = from(verduras);

// Obs 3 - Combinacion de los 3 
const frutasYVerduras = zip(frutasObs, verdurasObs);

const disposable = frutasYVerduras.subscribe(frutaYVerdura => {
    console.log(`Me llego una ${frutaYVerdura}`)
})

setTimeout(()=>{
    console.log("Terminando Suscripcion");
    disposable.unsubscribe();
}, 5000)