package tictactoe2

case class Pos(r: Int, c: Int){
  override def toString : String = {"Row: " + r + " Col: " + c}
}