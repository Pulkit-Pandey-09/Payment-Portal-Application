import React , {Component}from "react";
import PrivateLayoutComponent from '../components'
import withRouter from "../../../utils/withRouterHOC";
class PrivateLayouts extends Component{
  render(){
    const {handleLogout} = this.props;
    return(
       <PrivateLayoutComponent
        handleLogout={handleLogout}
       />
    );
  }
}

export default withRouter(PrivateLayouts);