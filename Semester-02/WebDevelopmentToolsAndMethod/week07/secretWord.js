export function newWord() {
    return randomWord();
}

const words = 'HAPPY GRINS TREES TIGER STRAP PARTS TRAPS GUESS GUEST'.split(' ');

function randomWord() {
    const index = Math.floor(Math.random() * words.length);
    return words[index];
}
