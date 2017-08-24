"use strict";
var TTT = {
    WIN: "Won",
    DRAW: "Draw",
    IN_PROGRESS: "In Progress",
    PLAYER_1: "X",
    PLAYER_2: "O",
    EMPTY: " ",
    newGame: function() {
        return { board: [this.emptyRow(), this.emptyRow(), this.emptyRow()], currentPlayer: this.PLAYER_1, progress: this.IN_PROGRESS }
    },
    emptyRow: function() {
        return [this.EMPTY, this.EMPTY, this.EMPTY]
    },
    copyGame: function(r) {
        var o = Object.assign({}, r);
        return o.board = r.board.slice(), o.board.forEach(function(r, t) { o.board[t] = r.slice() }), o
    },
    takeTurn: function(r) {
        r = this.copyGame(r);
        var o = this.checkForEnd(r);
        return r = this.applyEndResults(r, o), o ? r : (r = this.computerTurn(r), o = this.checkForEnd(r), r.currentPlayer = this.otherPlayer(r.currentPlayer), this.applyEndResults(r, o))
    },
    applyEndResults: function(r, o) {
        return o && (o === this.DRAW ? r.progress = this.DRAW : (r.progress = this.WIN, r.currentPlayer = o)), r
    },
    otherPlayer: function(r) {
        return ("" + this.PLAYER_1 + this.PLAYER_2).replace(r, "")
    },
    computerTurn: function(r) {
        for (var o = 0; o < 3; o++)
            for (var t = 0; t < 3; t++)
                if (r.board[o][t] === this.EMPTY) return r.board[o][t] = r.currentPlayer, r
    },
    checkForEnd: function(r) {
        var o = this.checkForVerticalWin(r) || this.checkForHorizontalWin(r) || this.checkForDiagonalWin(r);
        return o = o || this.checkForDraw(r)
    },
    checkForDraw: function(r) {
        for (var o = 0; o < 3; o++)
            for (var t = 0; t < 3; t++)
                if (r.board[o][t] === this.EMPTY) return;
        return this.DRAW
    },
    checkForVerticalWin: function(r) {
        var o = this.compareCells(r.board[0][0], r.board[1][0], r.board[2][0]) || this.compareCells(r.board[0][1], r.board[1][1], r.board[2][1]) || this.compareCells(r.board[0][2], r.board[1][2], r.board[2][2]);
        if (o) return o
    },
    checkForHorizontalWin: function(r) {
        var o = this.compareCells(r.board[0][0], r.board[0][1], r.board[0][2]) || this.compareCells(r.board[1][0], r.board[1][1], r.board[1][2]) || this.compareCells(r.board[2][0], r.board[2][1], r.board[2][2]);
        if (o) return o
    },
    checkForDiagonalWin: function(r) {
        var o = this.compareCells(r.board[0][0], r.board[1][1], r.board[2][2]) || this.compareCells(r.board[0][2], r.board[1][1], r.board[2][0]);
        if (o) return o
    },
    compareCells: function(r, o, t) {
        if (r !== this.EMPTY && r === o && o === t) return r
    }
};
module.exports = TTT;
