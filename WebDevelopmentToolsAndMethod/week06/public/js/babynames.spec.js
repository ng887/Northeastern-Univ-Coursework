var BN = require('./babynames');

describe('BabyNames', () => {
    it('exists', () => {
        expect(Object.keys(BN).length).not.toBe(0);
    });

    describe('getServiceUri', () => {
        it('gives me a gender specific uri if user enters gender', () => {
            var criteria = {};
            criteria.gender = 'M';
            var uri = BN.getServiceUri(criteria);
            expect(uri).toBe('/gender/M/names');
        });


        it('gives me name specific uri if user does not enters gender', () => {
            var criteria = {};
            criteria.name = 'Robert';
            var uri = BN.getServiceUri(criteria);
            expect(uri).toBe('/names/Robert');
        });

        it('gives me a gender and name specific uri if user enters gender and name', () => {
            var criteria = {};
            criteria.name = 'Monica';
            criteria.gender = 'F';
            var uri = BN.getServiceUri(criteria);
            expect(uri).toBe('/gender/F/names/Monica');
        });

        it('gives me names  uri if user does not enter anything', () => {
            var criteria = {};

            var uri = BN.getServiceUri(criteria);
            expect(uri).toBe('/names');
        });
    });

});
