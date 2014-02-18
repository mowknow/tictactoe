package tictactoe2

abstract class Board {
  def play(p: Pos, c: Char): NotEmpty = {
    new NotEmpty(p, c, this)
  }
  
  // true if a position is already occupied
  def occupied(p: Pos): Boolean
  
  // Functions to check that 2 positions are in the same column/row/diag
  val col = (p1: Pos, p2: Pos) => p1.c == p2.c  
  val row = (p1: Pos, p2: Pos) => p1.r == p2.r
  val diag1 = (p1: Pos, p2: Pos) => p1.r == p1.c && p2.r == p2.c
  val diag2 = (p1: Pos, p2: Pos) => p1.r == 4 - p1.c && p2.r == 4 - p2.c
  val checks = List(col, row, diag1, diag2)
  
  def gameOver(p: Pos, c: Char): Boolean = checks.exists(complete(p, c, 1, _))
  def complete(p: Pos, c: Char, count: Int, f: (Pos, Pos) => Boolean): Boolean
  
}

// Non empty board. Every move is represented by an immutable board object that references the previous board. 
class NotEmpty(val p: Pos, val c: Char, prev: Board) extends Board {
  
  def occupied(newP: Pos) = newP match {
    case x if (x == p) => true
    case _ => prev.occupied(newP)
  }

  def complete(px: Pos, c: Char, count: Int, f: (Pos, Pos) => Boolean) = count match {
    case _  if (f(px, p)) => prev.complete(px, c, count + 1, f)
    case _ =>  prev.complete(px, c, count, f)
  }
}

// Initial board, which is empty
class Empty extends Board {
  def occupied(newP: Pos) = false
  def complete(p: Pos, c: Char, count: Int, f: (Pos, Pos) => Boolean) = {count==3}
}   

