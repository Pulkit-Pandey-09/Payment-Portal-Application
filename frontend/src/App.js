import React from 'react'
import {BrowserRouter} from 'react-router-dom'
import Navigation from './navigation'
import {Home, UserLogin, Info, SuccessPay} from './screens'

const App = () => {
  return (
    <BrowserRouter>
      <Navigation/>    
    </BrowserRouter>

    //  <Routes>
    //     <Route path='/home' element={<Home />}></Route>
    //     <Route path='/login' element={<UserLogin />}></Route>
    //     <Route element={<PrivateRoutes />}>
    //       <Route path='/Info' element={<Info />}></Route>
    //       <Route path='/SuccessPay' element={<SuccessPay />}></Route>
    //     </Route>
    //   </Routes> 
  )
}

export default App;