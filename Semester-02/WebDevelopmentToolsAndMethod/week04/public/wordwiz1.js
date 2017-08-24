(function() { // Wrap in an IIFE so we don't worry about global namespace
    var secret;
    var guessCounts = 0;

    // get our secret word
    window.addEventListener('load', getSecret);

    // add behavior for when button is clicked
    var submitButton = document.getElementById('submit_guess');
    var input = document.getElementById('guess');
    var results = document.getElementById('results');
    submitButton.addEventListener('click', submitClick);

    function getSecret() {
        fetch('/secret')
            .then((response) => {
                return response.text();
            })
            .then((text) => {
                secret = text;
                submitButton.disabled = false;
            })
            .catch((e) => { alert(e); });
    }


    function submitClick(e) {
        e.preventDefault();
        var guess = input.value;
        addPending(guess);
        checkWord(guess);
        input.value = '';
    }

    function addPending(guess) {
        var newEntry = document.createElement('li');
        newEntry.className = guess;
        newEntry.appendChild(document.createTextNode(guess + ": Checking..."));
        results.appendChild(newEntry);
    }

    function checkWord(guess) {
        fetch(`/guess?guess=${guess}&secret=${secret}`)
            .then((response) => {
                return response.json();
            })
            .then((json) => { updateResults(json) })
            .catch((e) => { alert(e); });
    }

    function displayResults(guessCounts) {
        fetch(`/guessCount?guessCount=${guessCounts}`)
            .catch((e) => { alert(e); });
    }

    function updateResults(info) {
        var entry = Array.from(document.getElementsByClassName(info.guess)).slice(-1)[0];
        guessCounts = info.error ? guessCounts : guessCounts + 1;

        var message = info.error ? `Invalid word | Valid guess count: ${guessCounts}` : info.match ? `You win!` : `${info.count} letters correct | Valid guess count: ${guessCounts}`;

        entry.textContent = `${info.guess}: ${message}`;
        if (info.match) {
            submitButton.disabled = true;
            input.disabled = true;
            displayResults(guessCounts);
        }
    }

})();
