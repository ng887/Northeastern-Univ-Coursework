import React from 'react';

import './Content.css';

import News from './News.jsx'; 
import Events from './Events.jsx'; 
import Connect from './Connect.jsx';

 const Content = ({
 	hideNewsImg,
 	menuItemValue,
 	menuItemId 		
 }) => {
 	return(
 		<div id='content'> 		
	 		<News title={menuItemValue} hideImg={hideNewsImg}/>
	 				
	 		<h1>EVENTS</h1>
	 		<Events parentId={menuItemId}/>
	 		
	 		<h1>CONNECT</h1>
	 		<Connect/> 	  	
 	  	</div>
 	);
 };
 export default Content;



