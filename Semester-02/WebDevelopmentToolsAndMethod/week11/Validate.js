export function checkCondition(page, inputs) {
    const result = { missing: {}, invalid: {} };

    for (let i = 0; i < inputs.length; i++) {
        const name = inputs[i].name;

        if (page === 'CheckContent') {           
            if (inputs[i].value === '') {
                console.log(inputs[i].value);
                result.missing[name] = true;
            }

            if (inputs[i].value.toLowerCase() !== inputs[i].value) {
                result.invalid[name] = true;
            }
        } else if (page === 'EnsureUppercase') {
            if (inputs[i].value === '') {
                console.log(inputs[i].value);
                result.missing[name] = true;
            }

        } else if (page === 'CheckLength') {
            if (inputs[i].value.length !== 5) {
                console.log(inputs[i].value);
                result.invalid[name] = true;
            }

        }
    }
    console.log(result);
    return result;
}
