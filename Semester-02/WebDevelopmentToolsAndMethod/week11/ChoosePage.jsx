
import React from 'react';

const ChoosePage=({
	onPageSelect
}) =>{
return (
<div>
	<select onChange={onPageSelect}>
	  <option value="CheckContent">Check Content</option>
	  <option value="EnsureUppercase">Ensure Uppercase</option>
	   <option value="CheckLength">Check Length</option>
	    <option value="CheckContact">Check Contact -- Pending</option> 
	</select> 
</div>
)};
export default ChoosePage