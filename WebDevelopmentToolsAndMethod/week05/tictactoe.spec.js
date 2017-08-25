/*Pending*/
var TTT = require('./tictactoe');

describe('tictactoe', () => {

   
   
      beforeEach(function () {
    TTT.WIN= "Won",
    TTT.DRAW= "Draw",
    TTT.IN_PROGRESS= "In Progress",
    TTT.PLAYER_1= "X",
    TTT.PLAYER_2= "O",
    TTT.EMPTY= " "
  });
       describe('newGame', () => {
        it('returns a new game board', () => {
            expect(TTT.newGame().currentPlayer).toBe( "X");
            expect(TTT.newGame().progress).toBe( "In Progress");
            expect(TTT.newGame().board).toEqual([[" "," "," "],[" "," "," "],[" "," "," "]]);
        });
    });

          describe('emptyRow', () => {
        it('returns a empty game board', () => {
            expect(TTT.emptyRow()).toEqual([" "," "," "]);
        });
    });


});
