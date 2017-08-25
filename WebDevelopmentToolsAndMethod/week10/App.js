/**
 * Created by khutaijashariff on 3/28/17.
 */
import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';

import InputComponent from './InputComponent';
import ResultComponent from './ResultComponent';
import Select from './Select';

import {isRight} from './Helper';
import {getSecret} from './GetSecret';

class App extends Component {
/* start modified by neha */
    constructor(props) {
        super(props);
        this.state = this.getState();
        this.handleOptionChange=this.handleOptionChange.bind(this);
        this.handleFormSubmit=this.handleFormSubmit.bind(this); 
        this.handleRestartGame=this.handleRestartGame.bind(this);           
    }

/* start add by neha */
    getState(){
        return{
            msg: [],
            selectedOption:'',
            secret:'',
            toggleComponent:false,
            disable:false 
        }
    }
    
    handleRestartGame() {
        this.setState(this.getState());
    }

    handleOptionChange(changeEvent) {
        this.setState({
          selectedOption: changeEvent.target.value
        });
    }

    handleFormSubmit(formSubmitEvent) {
        formSubmitEvent.preventDefault();
        getSecret(this.state.selectedOption).then((secret) => {
            this.setState({
            secret:secret,
            toggleComponent:true
            });
        });
        //console.log('You have selected:', this.state.selectedOption);
    }
/* end add by neha */ 

    saveResult(entry) {
        let msg = '';
        if (entry.guess) {
            if (entry.error) {
                msg = "Invalid word.";
            } else if (!entry.error && entry.match) {
                msg = "You win."
            } else {
                msg = entry.guess + " : " + entry.count + " letters correct.";
            }
        }
        this.setState({
            msg: [...this.state.msg, msg],
            disable:msg ==='You win.'? true : false
        })
    }    

    render() {
        return (            
            <div className="App">
                <div className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h2>Welcome to React</h2>
                </div>
                
                <div style={this.state.toggleComponent ? {display: 'none'} : {}}>
                    <Select selectedOption={this.state.selectedOption} 
                            handleOptionChange={this.handleOptionChange} 
                            handleFormSubmit={this.handleFormSubmit} />
                </div>
                
                <div style={this.state.toggleComponent ? {} : { display: 'none' }}>
                    <p className="App-intro">
                        To get started, enter a {this.state.selectedOption} letter guess!
                    </p>
                    <InputComponent secret={this.state.secret} 
                                    selectedOption={this.state.selectedOption} 
                                    handleGetInput={isRight.bind(this)} 
                                    disabled={this.state.disable}/>
                    <ResultComponent msg={this.state.msg}/>
                </div>

                <div style={this.state.disable ? {} : { display: 'none' }}>
                    <input type="button" value="Restart" onClick={this.handleRestartGame}/>
                </div> 
            </div>
        );
    }
/* end modified by neha */
}

export default App;