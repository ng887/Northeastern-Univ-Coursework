import React, { Component } from 'react';
//import logo from './logo.svg';
import './App.css';

import ChoosePage from './ChoosePage';
import Intro from './Intro';
import Page from './Page';
import Success from './Success';
import { checkCondition } from './Validate';


class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            page: 'CheckContent',
            InputFields: [{ name: 'first', value: '' },
                { name: 'second', value: '' }
            ],
            validations: { missing: {}, invalid: {} }
        }
        this.onPageSelect = this.onPageSelect.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
        this.onInputChange = this.onInputChange.bind(this);
    }

    onPageSelect(e) {
        this.setState({
            page: e.target.value,
            InputFields: [{ name: 'first', value: '' },
                { name: 'second', value: '' }
            ],
            validations: { missing: {}, invalid: {} },


        })
    }


    onInputChange(i, value) {
        const InputFields = this.state.InputFields;  
        const validations =  { missing: {}, invalid: {} };     
        const name = InputFields[i].name;


        if (this.state.page === 'EnsureUppercase') {
            if (value.toUpperCase() === value) {
                InputFields[i].value = value;
            };
        } else if (this.state.page === 'CheckLength') {
            if (value.length !== 5) {
               
               validations.invalid[name] = true;
            }
            InputFields[i].value = value;
        } else {
            InputFields[i].value = value;
        }


        this.setState({
            InputFields,
            validations
        })

    }

    onSubmit(e) {
        e.preventDefault();

        const problems = checkCondition(this.state.page, this.state.InputFields);

        /*If fields don't validate reset the fields after submit else go to success page*/
        if (this.state.page === 'CheckContent') {
            if (this.checkValidation(problems, 'missing') || this.checkValidation(problems, 'invalid')) {
                return;
            }
        }
        if (this.state.page === 'EnsureUppercase') {
            if (this.checkValidation(problems, 'missing')) {
                return;
            }
        }
         if (this.state.page === 'CheckLength') {
            if (this.checkValidation(this.state.validations, 'invalid')) {
                return;
            }
        }
        this.setState({
            validations: { missing: {}, invalid: {} },
        });

        this.setState({
            page: 'Success',
        });

    }


    checkValidation(x, validation) {
        const problems = x;
        if (Object.keys(problems[validation]).length) {
            this.setState({
                validations: problems,
                InputFields: [{ name: 'first', value: '' },
                    { name: 'second', value: '' }
                ]
            });
            return true;
        }
    }


    render() {
        return (
            <div className="App">
              <ChoosePage onPageSelect={this.onPageSelect}/>
                <Page onSubmit={this.onSubmit} InputFields={this.state.InputFields} onInputChange={this.onInputChange} page={this.state.page}
                validations={this.state.validations}/>
               { this.state.page === 'Success' && <Success/> }
            </div>
        );
    }
}

export default App;
