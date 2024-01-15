import akka.actor.{Actor, ActorRef, ActorSystem, Props}

// Define mensajes
case class IniciarProceso()

// Actor principal que coordina el flujo de trabajo
class Coordinador extends Actor {
  // Crea actores secundarios
  val actorA: ActorRef = context.actorOf(Props[ActorA](), "actorA")
  val actorB: ActorRef = context.actorOf(Props[ActorB](), "actorB")

  def receive: Receive = {
    case IniciarProceso =>
      // Inicia el proceso enviando un mensaje al Actor A
      actorA ! IniciarProceso
  }
}

// Actor A que realiza una tarea y pasa el resultado al Actor B
class ActorA extends Actor {
  def receive: Receive = {
    case IniciarProceso =>
      // Simula una tarea y envía el resultado al Actor B
      val resultado = "Resultado de la tarea en ActorA"
      context.actorSelection("/user/actorB") ! resultado
  }
}

// Actor B que recibe el resultado del Actor A y realiza otra tarea
class ActorB extends Actor {
  def receive: Receive = {
    case resultado: String =>
      // Simula otra tarea utilizando el resultado del Actor A
      println(s"ActorB recibe: $resultado")
  }
}

object Main extends App {
  // Crea el sistema de actores
  val system: ActorSystem = ActorSystem("SistemaActores")

  // Crea el actor coordinador
  val coordinador: ActorRef = system.actorOf(Props[Coordinador](), "coordinador")

  // Inicia el proceso enviando un mensaje al coordinador
  coordinador ! IniciarProceso
}
