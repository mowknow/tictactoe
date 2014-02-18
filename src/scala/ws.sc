package tictactoe2

object ws {
	val start = new Empty                     //> start  : tictactoe2.Empty = tictactoe2.Empty@7036b673
	println(start)                            //> tictactoe2.Empty@7036b673
	val board2 = start.play(Pos(1,1),'X').play(Pos(2,1),'0').play(Pos(1,2), 'X')
                                                  //> board2  : tictactoe2.NotEmpty = tictactoe2.NotEmpty@4d7cca20
	
	board2.occupied(Pos(1,1))                 //> res0: Boolean = true
	board2.gameOver(Pos(2,3), 'X')            //> (Row: 2 Col: 1,X,1)res1: Boolean = false
	
	board2.row(Pos(1,1),Pos(1,3))             //> res2: Boolean = true
	board2.diag1(Pos(1,1),Pos(2,2))           //> res3: Boolean = true
	board2.diag1(Pos(1,1),Pos(3,3))           //> res4: Boolean = true
	board2.diag1(Pos(2,2),Pos(3,3))           //> res5: Boolean = true
	board2.complete(Pos(1,3), 'X', 1, board2.col)
                                                  //> res6: Boolean = false
	

	
	
	
	board2.complete(Pos(1,3), 'X', 1, board2.row)
                                                  //> (Row: 1 Col: 2,X,1)(Row: 1 Col: 1,X,2)res7: Boolean = true
	
	
	val x = 1                                 //> x  : Int = 1
}