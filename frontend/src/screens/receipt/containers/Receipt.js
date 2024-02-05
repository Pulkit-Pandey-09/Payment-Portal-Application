import React, {Component} from "react";
import withRouter from "../../../utils/withRouterHOC";
import ReceiptComponent from "../components";
import {getAPI} from "../../../utils/api";
class Receipt extends Component {

    constructor(props){
        super(props)
        this.state = {
            user : {},
            programme : {},
            payment: {}
        }
    }

    componentDidMount = () => {
        const {location} = this.props
        const path = location.pathname;  // /receipt/1
        const paymentId = path.charAt(9);
        getAPI("/student/payment/" + paymentId, "")
            .then((response) => {
                const { user, programme, payment } = response.data;
                this.setState({ user: user, programme: programme, payment: payment })
            })
            .catch((error) => {
                console.log(error)
            })
    }

    render(){
        debugger
        const { user, programme, payment } = this.state
        return(
            <ReceiptComponent 
                user={user}
                programme={programme}
                payment={payment}
            />
        );
    }
}

export default withRouter(Receipt);