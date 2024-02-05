import React from "react";
import {publicRoutes} from '../../../navigation/routes'
import { Route, Routes } from "react-router-dom";
import { Home } from "../../../screens";

const PublicLayoutComponent = ({handleLogin}) => {
  return(
      <Routes> 
        {publicRoutes.map((item, index) => 
          item.path === "/login" ? 
          (<Route key={index} path={item.path} element={<item.component handleLogin={handleLogin}/>} /> ) :
          (<Route key={index} path={item.path} element={<item.component/>}/>)
          )}
          <Route path={"/*"}  element={<Home/>}/>
      </Routes>
  )
}

export default PublicLayoutComponent;