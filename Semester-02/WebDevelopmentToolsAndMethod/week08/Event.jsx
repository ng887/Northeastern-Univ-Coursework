import React  from 'react';

import './Event.css';

const Event = ({
	date,
	time,
	text
}) => {
 	return(
 		<div id='event'>
	 		{date} <br/>
	 		{time} <br/>
	 		{text}
 		</div>
 	);
 };
 export default Event;