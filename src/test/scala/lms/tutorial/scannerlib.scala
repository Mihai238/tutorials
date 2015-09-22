package scala.lms.tutorial

import java.io.FileReader
import java.io.BufferedReader
import org.scala_lang.virtualized.SourceContext
import org.scala_lang.virtualized.virtualize

import scala.virtualization.lms.common.{EqualExpOpt, Equal}

//@virtualize //macro FIXME do we need this to be virtualized?
class Scanner(filename: String) {
  val br = new BufferedReader(new FileReader(filename))
  private[this] var pending: String = br.readLine()
  def next(delim: Char): String = {
    if (delim == '\n' ) {
      val field = pending
      pending = br.readLine()
      field
    } else {
      val i = pending.indexOf(delim)
      val field = pending.substring(0,i)
      pending = pending.substring(i+1)
      field
    }
  }
  def hasNext = pending ne null
  def close = br.close
}
