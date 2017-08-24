import React, { Component } from 'react';


import Header from './Header';
import Intro from './Intro';
import Content from './Content';
import Footer from './Footer';



class App extends Component {
    constructor(props) {
        super(props);
        this.state={
            openMenu: false,
            hideNewsImg: false,
            menuItemValue: 'NEWS',
            menuItemId: 'item-00',
            listType: ''
        };
        this.onMenuButtonClick = this.handleDropDownMenu.bind(this);
        this.onMenuItemClick = this.handleMenuItemSelect.bind(this);
    }

    handleDropDownMenu() {
        this.setState({
            openMenu: !this.state.openMenu
        })
    }

    handleMenuItemSelect(title, nameId) {        
        if (nameId === 'item-00') {
            this.setState({
                hideNewsImg: false,
                menuItemValue: 'NEWS',
                menuItemId: 'item-00',
                listType: ''
            })
        } else {
            this.setState({
                hideNewsImg: true,
                menuItemValue: title,
                menuItemId: nameId,
                listType: 'selected'

            })
        }
    }

    render() {      
        return (
            <div className='App-header'>
              <Header onMenuButtonClick={ this.onMenuButtonClick } onMenuItemClick={ this.onMenuItemClick } openMenu={ this.state.openMenu } listType={ this.state.listType } /> 
              <Intro/>
              <Content menuItemValue={ this.state.menuItemValue } hideNewsImg={ this.state.hideNewsImg } menuItemId={ this.state.menuItemId } /> 
              <Footer/>
            </div>
        );
    }
}
export default App;
