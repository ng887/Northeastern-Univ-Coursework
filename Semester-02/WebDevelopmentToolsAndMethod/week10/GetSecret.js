/**
 * Created by khutaijashariff on 3/28/17.
 */

/* 
export function getSecret() {
    var wordList = ["HAPPY", "GRINS", "TREES","STRAP", "PARTS", "TRAPS","GUESS", "GUEST", "TIGER"];
    var randomNumber = Math.floor(Math.random() * wordList.length);
    return wordList[randomNumber];
    
}
*/

/* start modified by neha */
export const getSecret = (selectedOption) => {
	let wordList=[];
	switch(selectedOption) {
		case 'five':
			 wordList = ["HAPPY", "GRINS", "TREES","STRAP", "PARTS", "TRAPS","GUESS", "GUEST", "TIGER"];
			break;
		case 'six':
			 wordList = ["PUZZLE", "QUARTZ", "JUMBLE","JUGGLE"];
			break;
		default:
			 wordList = ["JUMP", "ZINC", "JOKE","TREE", "GRIN", "TRIP","TRAP"];
	}
    const randomNumber = Math.floor(Math.random() * wordList.length);
    const secretWord = wordList[randomNumber];

    var secret = new Promise((resolve, reject) => {
        resolve( secretWord );
    })
    return secret;
}
/* end modified by neha*/