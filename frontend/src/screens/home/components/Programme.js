import React from 'react';
import { CustomCard, PrimaryButton } from '../../../shared'

const Programme = ({name, Id, handleButtonClick, src}) => {
  return(
    <div>
      <CustomCard style={{width: 240, textAlign: 'center'}} src={src} content={
         <PrimaryButton type={"primary"}  onClick={()=>handleButtonClick(Id)} name={name}></PrimaryButton>
       }>
    </CustomCard>
    </div>
  )
}

export default Programme;
