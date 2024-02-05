import React, {Component} from "react";
import {PublicLayouts, PrivateLayouts} from '../layouts'
import withRouter from "../utils/withRouterHOC";
import {message } from 'antd';
class Navigation extends Component{

    constructor(props){
        super(props);
        this.state = {
            token : localStorage.getItem('token'),
            reRender : false
        };
    }

    login = (acessToken, rollNumber) => {
        this.setState({token:acessToken})
        localStorage.clear();
        localStorage.setItem('token', acessToken);
        localStorage.setItem('rollNumber', rollNumber);
        const {navigate} = this.props;
        navigate('/payment');
        message.success("Log in Successful");
    }

    logout = () => {
        const { navigate } = this.props;
        localStorage.clear();
        this.setState({token:""})
        navigate('/home');
    };

    componentDidMount = () => {
        const token = localStorage.getItem("token")
        const {navigate, location} = this.props
        const {pathname} = location
        const s = pathname.substr(1,6)   // /receipt/id , /portal
        if(token && s !== 'receip' && s !== 'portal'){
            navigate("/payment")
        }
    }

    render(){
        const {token} = this.state;
        return(
            token ? 
            <PrivateLayouts handleLogout={this.logout}/> : 
            <PublicLayouts handleLogin={this.login}/>
        )
    }
}

export default withRouter(Navigation);


/*
Scenario 1 - sending login to public layouts

Navigation act as my entry point. Here I am rendering PublicLayouts and PrivateLayouts depending on the token 
present in my browser's local storage. 

If token is not present, I am going to render PublicLayouts. All the public routes are being routed in PublicLayout
component. But what about private routes? They did not rendered and hence did not get routed. How will i access my private routes? 
To route my private routes, I passed my login Function to PublicLayout as a attribute which is being send to my login component
as props(See PublicLayout component). My login component comes under PublicRoutes, so I can access it. The login component receives the reference
of login function of my navigation component. So when user enters his/her credentials, the login function of naviagtion 
component gets executed. The login function updates my state of navigation component (token is generated and stored in local storage).

So, now according to components lifecyle knowledge, when state of component is updated. The render fucntion is called again. Since, we have
a token in our local storage now, our privateLayout is rendered which routes our privateRoutes and makes these routes accessible to us.

Scenario 2 - sending logout to private layouts


*/