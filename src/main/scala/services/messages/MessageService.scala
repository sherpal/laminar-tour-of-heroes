package services.messages

import com.raquo.airstream.signal.Var

object MessageService {

  val messages: Var[List[Message]] = Var(Nil)

  def addMessage(message: Message): Unit = {
    messages.set(message +: messages.now())
  }

  def clear(): Unit = {
    messages.set(Nil)
  }

}
