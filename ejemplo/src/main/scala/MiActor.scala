import akka.actor.{Actor, ActorSystem, Props}

object Main extends App {
  // Crea un sistema de actores
  val system = ActorSystem("EjemploSystem")

  // Define un actor simple
  class MiActor extends Actor {
    def receive: Receive = {
      case mensaje: String => println(s"Recibido: $mensaje")
    }
  }

  // Crea una instancia del actor
  val miActor = system.actorOf(Props[MiActor](), "miActor")

  // Envia un mensaje al actor
  miActor ! "Hola, Akka!"

  // Detiene el sistema de actores
  system.terminate()
}
