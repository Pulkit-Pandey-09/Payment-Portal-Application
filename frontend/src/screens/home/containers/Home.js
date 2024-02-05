import React, { Component } from "react";
import { HomeComponent } from "../components";
import withRouter from '../../../utils/withRouterHOC'
import { getAPI } from "../../../utils/api";

class Home extends Component {

  handleButtonClick = (buttonId) => {

    getAPI('/programme/' + buttonId, "")
    .then((response) => {
      let res = response.data;
      const {navigate} = this.props;
      navigate('/login', { state: {res}});
    })
    .catch((error) => {
      console.log(error)
    })
    //     .then(response => {
    //         let res = response.data;
    //         const {navigate} = this.props;
    //         navigate('/login', { state: {res}});
    //     })
    //     .catch(error => console.log(error));
  };

  render() {
    return <HomeComponent 
      handleButtonClick = {this.handleButtonClick}
    />;
  }
}

export default withRouter(Home);
