var wordGame = {
  generateWord: function() {
    var words = 'HAPPY GRINS TREES TIGER STRAP PARTS TRAPS GUESS GUEST'.split(' ');
    return words[Math.floor(Math.random() * words.length)];
  },
  /////////////////////////////////
  isRight: function(rawGuess, rawWord) {
    var result = { guess: rawGuess };
    
      
    if(!this.isValid(rawGuess) || !this.isValid(rawWord)) { 
      result.error = true;
      return result;
    }
    var guess = rawGuess.toUpperCase();
    var word = rawWord.toUpperCase();
    if(guess === word) {
      result.match = 'exact';
      result.count = guess.length;     
      return result;
    }
    result.count = this.compare(guess, word);
    return result;
  },

 /////////////////////////////////
  isValid: function(word) {
    if(!word) {
      return false;
    }
    if(!word.toUpperCase) {
      return false;
    }// Why using this?
    if(word.length !== 5) {
      return false;
    }
    return true;
  },
  /////////////////////////////////
  compare: function(first, second) {
    var count = 0;
    var letters = {};
    first.split('').forEach( (letter) => { letters[letter] = (letters[letter]+1) || 1; });
    second.split('').forEach( (letter) => { 
      if(letters[letter]) {
        count++;
        letters[letter]--;
      }
    });
    return count;
  }

};
module.exports = wordGame;
