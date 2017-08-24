import React from 'react';

import './Menu.css';

import MenuItems from './MenuItems';

const Menu = ({
  onClick,
  onMenuItemClick,
  open,
  listType
}) => {  
  return(
  <div id='menu'>
    <button id='menuIcon' className='dropdown' onClick={ () => onClick() }>☰</button>
    {open ? <MenuItems onClick={onMenuItemClick} listType={listType}/> : null}
   </div>   
  )
};
export default Menu;
