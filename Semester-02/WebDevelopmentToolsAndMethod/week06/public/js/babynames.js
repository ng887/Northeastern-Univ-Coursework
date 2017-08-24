(function() {
    var BN = {
        onLoad: function() {
            document.getElementById("add-details").addEventListener('click', this.sendData.bind(this));
            document.getElementById('search-run').addEventListener('click', this.runSearch.bind(this));
        },

        sendData: function() {
            var userDetails = this.getUserDetails();
            return fetch('/name', {
                method: 'POST',
                headers: new Headers({
                    'Content-Type': 'application/json'
                }),
                body: JSON.stringify(userDetails),
            })

            .catch((error) => {
                alert('failed to load', e);
            });
        },

        getUserDetails: function() {
            var userDetails = {};
            userDetails.name = document.getElementById("add-name").value;
            userDetails.gender = document.getElementById("add-gender").value;
            userDetails.year = document.getElementById("add-year").value;
            return userDetails;
        },

        runSearch: function() {
            console.log("1" + this.criteria);
            var criteria = this.getSearchCriteria();
            this.search(criteria);
            console.log("1" + this.criteria);
        },

        getSearchCriteria: function() {
            console.log("2" + criteria);
            var criteria = {};
            criteria.name = document.getElementById('search-name').value;
            criteria.gender = document.getElementById('search-gender').value;
            console.log("2" + criteria);
            return criteria;
        },

        search: function(criteria) {
            console.log("3" + criteria);
            if (criteria.name) {
                this.callSearch(criteria).then(this.updateDetailResults.bind(this));
            } else {
                this.callSearch(criteria).then(this.updateNameList.bind(this));
            }
        },

        updateDetailResults: function(details) {
            var list = document.getElementById('results-list');
            var counter = 0;
            for (var key in details) {
                if (details.hasOwnProperty(key))
                    var item = document.createElement('li');
                item.textContent = key.charAt(0).toUpperCase() + key.substring(1) + ": " + details[key];
                list.appendChild(item);
                counter++;
            }
            /*Remove previous search items */
            while (list.children.length > counter) {
                list.removeChild(list.firstChild);
            }
        },

        updateNameList: function(nameContainer) {
            var list = document.getElementById('results-list');
            nameContainer.names.forEach((name) => {
                var item = document.createElement('li');
                item.textContent = name;
                list.appendChild(item);
            });
        },

        callSearch: function(criteria) {
            //var nameList = { names: [ 'Ken', 'Yang', 'Nedu' ] };
            /*var nameList = { gender: 'F', count: 5, firstYear: 1220, recentYear: 2015 }
            return new Promise((resolve, reject) => { resolve(nameList); });*/
            var uri = getServiceUri(criteria);
            return fetch(uri)
                .then((response) => response.json())
                .catch((e) => { alert(e); });
        },

        getServiceUri: function(criteria) {
            var uri;
            if (criteria.gender) {
                uri = `/gender/${criteria.gender}/names`;
            } else {
                uri = `/names`;
            }
            if (criteria.name) {
                uri = uri + `/${criteria.name}`;
            }
            return uri;
        }
    };

    if (typeof module !== 'undefined') {
        module.exports = BN;
    } else {
        window.addEventListener('load', BN.onLoad.bind(BN));
        window.BN = BN;
    }
})()
