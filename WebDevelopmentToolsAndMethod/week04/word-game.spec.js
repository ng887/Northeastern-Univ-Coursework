var wordGame = require('./word-game');

describe('word-game', () => {
  describe('generateWord', () => {
    it('returns a word from the list', () => {
      var words = 'HAPPY GRINS TREES TIGER STRAP PARTS TRAPS GUESS GUEST'.split(' ');
      var word = wordGame.generateWord();
      expect(words).toContain(word);
    });
  });

  describe('isValid', () => {
    it('rejects non-words', () => {
      expect(wordGame.isValid()).toBeFalsy();
      expect(wordGame.isValid(2)).toBeFalsy();
      expect(wordGame.isValid([])).toBeFalsy();
      expect(wordGame.isValid({})).toBeFalsy();
    });
    it('accepts 5 letter words', () => {
      expect(wordGame.isValid('AAAAA')).toBeTruthy();      
      expect(wordGame.isValid('aaaaa')).toBeTruthy();
    });
    it('rejects words of non-5 length', () => {
      expect(wordGame.isValid('AAAA')).toBeFalsy();      
      expect(wordGame.isValid('aaaa')).toBeFalsy();
      expect(wordGame.isValid('AAAAAA')).toBeFalsy();      
      expect(wordGame.isValid('aaaaaa')).toBeFalsy();
    });
  });

  describe('compare', () => {
    it('counts matching letters', () => {
      expect(wordGame.compare('ASDFG', 'GFDSA')).toBe(5);
      expect(wordGame.compare('ASDFG', 'BSDFG')).toBe(4);
      expect(wordGame.compare('ASDFG', 'BBDFG')).toBe(3);
      expect(wordGame.compare('ASDFG', 'BBBFG')).toBe(2);
      expect(wordGame.compare('ASDFG', 'BBBBG')).toBe(1);
      expect(wordGame.compare('ASDFG', 'BBBBB')).toBe(0);
    });
    it('handles repeat characters', () => {
      expect(wordGame.compare('AAAAA', 'ASDFG')).toBe(1);
      expect(wordGame.compare('ASDFG', 'AAAAA')).toBe(1);
    });
  });

  describe('isRight', () => {
    it('reports on exact matches', () => {
      expect(wordGame.isRight('ASDFG', 'ASDFG').match).toBe('exact');
    });
    it('cares not about case', () => {
      expect(wordGame.isRight('ASDFG', 'asdfg').match).toBe('exact');
      expect(wordGame.isRight('asdfg', 'ASDFG').match).toBe('exact');
    });
    it('tells me about errors', () => {
      expect(wordGame.isRight('ASDFG').error).toBe(true);
      expect(wordGame.isRight(0, 'ASDFG').error).toBe(true)
      expect(wordGame.isRight('ASDFG', 0).error).toBe(true);
      expect(wordGame.isRight('ASDFG', 'HJKLL').error).toBeFalsy();
    });
    it('counts matches', () => {
      expect(wordGame.isRight('ASDFG', 'GFDSA').count).toBe(5);
      expect(wordGame.isRight('ASDFG', 'BBBBG').count).toBe(1);
      expect(wordGame.isRight('ASDFG', 'BBBBB').count).toBe(0);
    });
    it('handles repeat characters', () => {
      expect(wordGame.isRight('AAAAA', 'ASDFG').count).toBe(1);
      expect(wordGame.isRight('ASDFG', 'AAAAA').count).toBe(1);
    });
    it('returns the guess', () => {
      expect(wordGame.isRight('AAAAA', 'BBBBB').guess).toBe('AAAAA');
      expect(wordGame.isRight('BBBBB', 'AAAAA').guess).toBe('BBBBB');
      expect(wordGame.isRight('FOO').guess).toBe('FOO');
      expect(wordGame.isRight(0).guess).toBe(0);
      expect(wordGame.isRight().guess).toBe(undefined);
    });


  });
});
