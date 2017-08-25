import React from 'react';

import './MenuItems.css'; 
import { getMenutems }  from './MenuItemsList.js'

const MenuItems=({
  onClick,
  listType
}) => {
  const menuItems = getMenutems();
  if  (listType === 'selected') {
    menuItems.push({nameId:'item-00', title:'Home'})
  }  
  return(	    
	<ul className="dropdown-menu">
    {menuItems.map((menuItem) => <li key={menuItem.nameId} onClick={ () => onClick(menuItem.title,menuItem.nameId) }>{menuItem.title}</li> )}
  </ul>    
  )
};
export default MenuItems;

