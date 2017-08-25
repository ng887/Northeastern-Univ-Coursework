(function() {

    var gameBoard = document.getElementById('board');
    var playerGameBoard = [
        [" ", " ", " "],
        [" ", " ", " "],
        [" ", " ", " "]
    ];
    window.addEventListener('load', getGameGrid);
    var playerMoveBox;
    var gameStatus;
   // var winner;

    //var restartButton = document.getElementById('restart');
    // restartButton.addEventListener('click', restartClick);

    function getGameGrid() {
        fetch('/newGame')
            .then((response) => {
                return response.text();
            })
            .then((text) => {
                gameBoard.style.visibility = 'visible';
            })
            .catch((e) => { alert(e); });
    }

  /*  function restartClick(e) {
        e.preventDefault();
        getGameGrid();
    }*/

    for (var i = 0; i < 3; i++) {
        let row = i
        for (var j = 0; j < 3; j++) {
            let col = j;
            document.getElementById('box' + row + col).addEventListener('click', function() { playerTurnDisplay(row, col); });
        }
    }

    function playerTurnDisplay(x, y) {
        console.log("Game Status = " + gameStatus);
        if (gameStatus != 'Won') {
            document.getElementById('box' + x + y).style.color = "white";
            document.getElementById('box' + x + y).style.backgroundColor = "plum";
            document.getElementById('box' + x + y).innerHTML = "X";
            playerGameBoard[x][y] = "X";
            console.log(playerGameBoard);
            getPlayerTurn();
        } else {
            document.getElementById('message').innerHTML = "GAME IS OVER !!!"
        }


    }

    function getPlayerTurn() {
        fetch('/takeTurn', {
                method: 'POST',
                body: JSON.stringify({ board: playerGameBoard, currentPlayer: "O" }),
                headers: new Headers({ 'Content-Type': 'application/json' })
            })
            .then((response) => {
                return response.json();
            })
            .then((json) => { updateCompMove(json) })
            .catch((e) => { alert(e); });
    }

    function updateCompMove(info) {
        console.log(info.progress);

        for (var p = 0; p < 3; p++) {
            for (var q = 0; q < 3; q++) {
                if ((info.board[p][q]) == "O") {
                    document.getElementById('box' + p + q).style.color = "white";
                    document.getElementById('box' + p + q).style.backgroundColor = "indigo";
                    document.getElementById('box' + p + q).innerHTML = "O";
                    playerGameBoard[p][q] = "O";
                    document.getElementById('message').innerHTML = "GAME IN PROGRESS";
                }
            }
        }

        if (info.progress == 'Won') {
            document.getElementById('message').innerHTML = "'" + info.currentPlayer + "'" + " WON THE GAME";
            gameStatus = 'Won';
            winner = info.currentPlayer;
            sendResults(winner);
        } else if (info.progress == 'Draw') {
            document.getElementById('message').innerHTML = "GAME DRAW";
            gameStatus = 'Won';
            winner = 'Match Draw';
            sendResults(winner);
        }


    }

    function sendResults(winner) {
        fetch(`/gameResults?gameResults=${winner}`)
            .catch((e) => { alert(e); });
    }


})();
