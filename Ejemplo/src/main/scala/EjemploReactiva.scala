import io.reactivex.Observable
import io.reactivex.*


object EjemploReactiva {
  @main
  def ejemplo(): Unit = {

    // Oobservable
    val cantidad: Observable[Int] = Observable.just(3, 4, 1, 3, 5, 1)
    val frutas: Observable[String] = Observable.just("Pera", "Sandia", "Papaya", "Uva", "Fresa", "Kiwi")

    // Oobservable combinado
    val observablesCombinados: Observable[String] =
      cantidad
        .zipWith(frutas, (cant, fruta) =>
          s"RECIBI: $cant ${if (cant > 1) fruta + "s" else fruta}")

    // Suscribirse al observable combinado
    val suscripcion = observablesCombinados
      .subscribe {
        x => println(s"Resultado: $x")
    }

    // Esperar un momento
    Thread.sleep(1000)

    // Darse de baja de la suscripción
    suscripcion.dispose()
    println("\nPedido completo")
  }
}
