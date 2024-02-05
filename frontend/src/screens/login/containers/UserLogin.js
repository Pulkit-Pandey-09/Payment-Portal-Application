import React, {Component}from 'react';
import {Fee, Login}from '../components'
import withRouter from '../../../utils/withRouterHOC'
import { postAPI } from '../../../utils/api';
import { message,Typography } from 'antd';
import { initialRes } from '../constants';
const { Title } = Typography;

class UserLogin extends Component{
    
    onFinish = ({rollNumber, password}) => {
        postAPI("/student/login", {"rollNumber": rollNumber,"password": password})
        .then((response) => {
            const {token} = response.data.accessToken;
            const {handleLogin} = this.props;
            handleLogin(token, rollNumber)
        })
        .catch((error) => {
            message.error("Invalid Credentials");
        })

    };

    
    render(){
    
        return (
        <div>
            <Title level={3} style={{ marginLeft: "600px", marginTop: "25px", marginRight:"300px" }}>Fee Structure</Title>
            <Fee res = {  ((this.props.location).state || ({})).res || initialRes}/>
            <Login 
                onFinish={this.onFinish} 
                onFinishFailed={this.onFinishFailed}
            />
        </div>
        );
    }
}

export default withRouter(UserLogin);