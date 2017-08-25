import React  from 'react';

import './Header.css';

import Menu from './Menu';

const Header = ({
	onMenuButtonClick,
	onMenuItemClick,
	openMenu,
	listType
}) => {
	return(
 	<header id='header'>
 		<div id='nav'>
 			<Menu onClick={onMenuButtonClick} onMenuItemClick={onMenuItemClick} open={openMenu} listType={listType}> </Menu>
    	</div>
    	<div id='title'>
    		Northeastern University
    	</div>
    </header>
 	);
 };
 export default Header;