import React from "react";
import { Route, Routes } from "react-router-dom";
import { privateRoutes } from "../../../navigation/routes";
import { Payment } from "../../../screens";
const PrivateLayoutComponent = ({ handleLogout }) => {
  return (
      <Routes>
            {privateRoutes.map((item, index) => (
              <Route key={index} path={item.path} element={<item.component handleLogout={handleLogout} />}/>
            ))}
            <Route path={"/*"}  element={<Payment handleLogout={handleLogout}/>}/>
      </Routes>
  );
};
export default PrivateLayoutComponent;
