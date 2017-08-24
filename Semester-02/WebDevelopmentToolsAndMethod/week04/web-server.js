var express = require('express');
var app = express();

var wordGame = require('./word-game');

app.get('/secret', (req, res) => { res.send(wordGame.generateWord()); });
app.get('/guess', (req, res) => { res.send(JSON.stringify(wordGame.isRight(req.query.guess, req.query.secret))); });
app.get('/guessCount', (req, res) => { res.send('OK'); console.log('guessCount is ' + req.query.guessCount) });


app.use(express.static('public'));
app.listen(8000, () => {
    console.log('express now listening on port 8000');
});
