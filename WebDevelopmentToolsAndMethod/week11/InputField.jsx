import React from 'react';

const Submit = ({
    InputFields,
    onInputChange
   
}) => {

     
    return (
    <div>        
            </br>
			{InputFields.map((field,index) => 
                <div key={index}>
                    {field.toUpperCase()}:<input key={index} name={field.name} value={field.value} onChange={(e) => onInputChange({field.value}, e.target.value)}></input>
                    <br/>                    
                </div>
            )}         
	
	</div>
    )
}

export default Submit;