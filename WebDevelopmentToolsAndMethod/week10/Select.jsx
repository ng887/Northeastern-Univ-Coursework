/* created by neha */

import React from 'react';

const Select=({
    selectedOption,
    handleOptionChange,
    handleFormSubmit
}) => {
    return(
          <div>
            <p> How many letter word do you want to guess? </p>
            <form onSubmit={handleFormSubmit}>                      
                <label>
                  <input type="radio" value="four" checked={selectedOption === 'four'} onChange={handleOptionChange} />
                  4
                </label>                     
             
                <label>
                  <input type="radio" value="five" checked={selectedOption === 'five'} onChange={handleOptionChange}/>
                  5
                </label>

                <label>
                  <input type="radio" value="six" checked={selectedOption === 'six'} onChange={handleOptionChange}/>
                  6
                </label>                     
                <button type="submit">Save</button>
            </form>
          </div>                          
  )};
export default Select;


 