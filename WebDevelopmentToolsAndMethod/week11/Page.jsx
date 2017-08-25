import React from 'react';

const Page = ({
    InputFields,
    onSubmit,
    onInputChange,
    page,
    validations
}) => {


    const missingMsg = 'is required';
    const invalidMsg = 'is invalid';
    const tempDiv = []

    for (let i = 0; i < InputFields.length; i++) {
        let fname = InputFields[i].name;
        let value = InputFields[i].value;
    
        let missingCondition = validations.missing[`${fname}`] && `${fname} ${missingMsg}`
        let invalidValidation = validations.invalid[`${fname}`] && `${fname} ${invalidMsg}`
        let finalCondition;
        
        if (page === 'CheckContent') {
            finalCondition = (
                <div>
                    <span>{missingCondition} </span>
                    <span> {invalidValidation}</span>
                </div>
            )
        }

        if (page === 'EnsureUppercase') {
            finalCondition = (
                <div>
                    <span>{missingCondition} </span>

                </div>
            )
        }

        if (page === 'CheckLength') {
            finalCondition = (
                <div>
                    <span>{invalidValidation} </span>
                    
                </div>
            )
        }

        tempDiv.push(
            <div key={i}>              
               <div>{fname.toUpperCase()}:&nbsp;
                   
                       <input key={i} 
                                name={fname} 
                                value={value}  
                                onChange={(e) => onInputChange(i, e.target.value)}>
                        </input>
                   
                </div>
               {finalCondition}
            </div>

        )
    }

    return (
    <div>
        <form>
            {tempDiv}
            <br/>
            <button onClick={onSubmit}> Click Me </button>
        </form>
    </div>
    )
}

export default Page
