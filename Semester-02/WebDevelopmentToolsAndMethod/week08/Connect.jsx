import React from 'react';

import './Connect.css';

const Connect=() => {
   return(	  
  <div id='connect'> 
	<ul className="socialIcons">
	  	<li><img src={require('./images/facebook.png')} alt='facebook'/></li>
	  	<li><img src={require('./images/twitter.png')} alt='twitter'/></li>
	  	<li><img src={require('./images/youtube.png')} alt='youtube'/></li>
  	</ul>
  </div> 
 )
};
export default Connect;

