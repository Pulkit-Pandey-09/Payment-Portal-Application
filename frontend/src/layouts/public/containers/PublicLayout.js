import React , {Component}from "react";
import PublicLayoutComponent from '../components'
import withRouter from "../../../utils/withRouterHOC";
import { publicRoutes } from "../../../navigation/routes";

class PublicLayouts extends Component{

  componentDidMount = () => {
    const {location, navigate} = this.props;
    const temp = publicRoutes.find((item) =>{
     return item.path === location.pathname
     }
    ) 
    if(!temp){
      navigate("/")
    }
  }
  render(){
    const {handleLogin} = this.props;
    return(
       <PublicLayoutComponent handleLogin={handleLogin}/>
    );
  }
}

export default withRouter(PublicLayouts);