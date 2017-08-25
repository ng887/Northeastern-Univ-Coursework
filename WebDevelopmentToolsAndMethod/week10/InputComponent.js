/**
 * Created by khutaijashariff on 2/23/17.
 */
import React, {Component} from 'react';


class InputComponent extends Component {
    
    constructor(props) {
        super(props);
        this.state = {
            value: ''
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({value: event.target.value});
    }

    handleSubmit(event) {
        event.preventDefault();
        if (this.state.value !== '') {
            this.props.handleGetInput(this.state.value, this.props.secret,this.props.selectedOption); // modified by neha
        }
        this.setState({value: ''});
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label>                    
                    <input type="text" value={this.state.value} onChange={this.handleChange} disabled={this.props.disabled}/>
                </label>
                <input type="submit" value="Submit" disabled={this.props.disabled}/>
                <br />
            </form>
        );
    }
}

export default InputComponent;
