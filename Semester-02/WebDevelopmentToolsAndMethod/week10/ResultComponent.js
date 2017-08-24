/**
 * Created by khutaijashariff on 2/23/17.
 */
import React, {Component} from 'react';

class ResultComponent extends Component {

    render() {
        const results = this.props.msg;
        let i = 0;
        const listItems = results.map((resultMsg) =>
            <li key={i++}>{resultMsg}</li>
        );

        return (
            <ul>{listItems}</ul>
        );
    }
    
}

export default ResultComponent;

