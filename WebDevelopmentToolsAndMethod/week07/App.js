import React, { Component } from 'react';

import './App.css';

import { newWord }  from './secretWord.js'
import { isValidLength, matchedLetters }  from './wordGame.js'

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            guess: '',
            secret: '',
            messages: []            
        }

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);        
    }

    componentDidMount() {
        const secret = newWord()
        //console.log('secret word:' + secret);
        
        this.setState({
            secret: secret
        })     
    }

    handleChange(event) {
        this.setState({
            guess: event.target.value.toUpperCase()                      
        })
    }


    handleSubmit(event) {
        event.preventDefault();
                
        let isValidWord = isValidLength(this.state.guess,this.state.secret);
        let count = matchedLetters(this.state.guess,this.state.secret);
              
        let msg = isValidWord ? 
                (this.state.guess === this.state.secret? 'You Win!' :  this.state.guess +': ' + count + ' letters correct'):
                (this.state.guess + ': Invalid Word. Please enter 5 letter word.');
       
        this.setState({
            guess: '',
            messages: [...this.state.messages, msg]
         })
    }
 


    render() {
        const disableGuess = this.state.messages[this.state.messages.length-1] === 'You Win!' ? true : false
                
        let guessInput = null ;
       
        if(disableGuess){
             guessInput=< input name='guess'
                    value={ this.state.guess }
                    disabled='true'
                    onChange={ this.handleChange }
                /> 
        }else{
            guessInput=< input name="guess"
                    value={ this.state.guess }
                    onChange={ this.handleChange }
                /> 
             }

        return (            

            < div className='App-header' >
            < form id='guess_form' >
             
            {guessInput}
                
             { < input type='submit'
                value='Guess'
                disabled={ !this.state.guess}
                onClick={this.handleSubmit}
                /> 
             } 
              

            < /form >  
                < ul >{this.state.messages.map(function(message,index)
                        {
                            return < li key={index} >{message}< /li >;
                        })
                    }
                < /ul >

            < /div >
        );
    }

}

export default App;
