package Socitie_general

/**
  * Created by AShrivastava on 2/17/2020.
  */
trait Aadhar {

  case class aadhar(sa:String,aua:Int)
  def readaadhar:Seq[aadhar]

}
