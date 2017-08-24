export function isValidLength(rawGuess, rawWord) {

    if (!isValid(rawGuess) || !isValid(rawWord)) {
        return false;
    } else {
        return true;
    }

}

function isValid(word) {
    if (!word) {
        return false;
    }
    if (!word.toUpperCase) {
        return false;
    }
    if (word.length !== 5) {
        return false;
    }
    return true;
}

export function matchedLetters(rawGuess, rawWord) {

    let guess = rawGuess.toUpperCase();
    let word = rawWord.toUpperCase();
    let count;
    count = compare(guess, word);
    return count;
}

function compare(first, second) {
    let count = 0;
    let letters = {};
    first.split('').forEach((letter) => { letters[letter] = (letters[letter] + 1) || 1; });
    second.split('').forEach((letter) => {
        if (letters[letter]) {
            count++;
            letters[letter]--;
        }
    });
    return count;
}
