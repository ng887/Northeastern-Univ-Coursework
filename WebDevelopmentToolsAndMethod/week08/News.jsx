import React  from 'react';

import './News.css';

const News = ({
	hideImg,
	title
	}) => {
 	return(
 		<div id='news'>
 			<h1>{title}</h1>
 			<img className={hideImg ? 'hidden' : ''} src="http://lorempixel.com/400/200/cats/4/" alt="News" />
 		 </div> 		
 	);
 };
 export default News;