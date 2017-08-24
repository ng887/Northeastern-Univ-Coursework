import React  from 'react';

import './Events.css';

import Event from './Event';

import { getEvents } from './EventsList.js';

const Events=({
	parentId
})	=> {
	const selectedEvents = getEvents(parentId);
	const events = [];	
	for(let i=0 ; i<selectedEvents.length ; i++){	
		events.push (
			<Event 
				date={selectedEvents[i].date}
				time={selectedEvents[i].time}
				text={selectedEvents[i].title}> 
			</Event>
		);		
	}	
	return(
 		<div id='events'>
	 		<ul>
	 			{events.map((event,index) => <li key={index}>{event}</li> )}
	 		</ul>
    	</div>
 	);
 };
 export default Events;