var express = require('express');
var app = express();
var port = 3000;
var bodyParser = require('body-parser');

var TTT = require('./tictactoe.js');

app.use(express.static('public'));
app.use(function(req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    next();
});

app.use(bodyParser.json());
app.get('/newGame', (req, res) => { res.send(JSON.stringify(TTT.newGame())); });

app.post('/takeTurn', (req, res) => { 
  res.send(JSON.stringify(TTT.takeTurn(req.body)));
});

app.get('/gameResults', (req, res) => { res.send('OK'); console.log('The Winner is ' + req.query.gameResults) });

app.listen(port, () => { console.log(`server listening on port ${port}`);});
