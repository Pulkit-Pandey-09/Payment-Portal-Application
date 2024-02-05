import React, { Component } from "react";
import PaymentComponent from "../components"
import withRouter from '../../../utils/withRouterHOC'
import { postAPI } from "../../../utils/api";

class Payment extends Component {
    constructor(props) {
        super(props)
        this.state = {
            user: {},
            payment: {},
            programme: {},
        }
    }

    componentDidMount = () => {
        debugger
        const rollNumber = localStorage.getItem("rollNumber")
        postAPI("/student/info", {
            "rollNumber": rollNumber
        })
            .then((response) => {
                const { user, programme, payment } = response.data;
                this.setState({ user: user, programme: programme, payment: payment })
            })
            .catch((error) => {
                console.log(error);
            })
    }

    handleButtonClick1 = () => {
        const { user, programme } = this.state;
        postAPI("/student/payment", {
            "firstName": user.firstName,
            "lastName": user.lastName,
            "rollNumber": user.rollNumber,
            "amount": parseInt(programme.amount),
        })
            .then((response) => {
                let res = response.data;
                const { navigate } = this.props;
                navigate('/portal', { state: res });
            })
            .then((error) => {
                console.log(error);
            })
    };


    handleButtonClick2 = () => {
        const { payment } = this.state;
        const { paymentId } = payment;
        window.open('/receipt/'+ paymentId, '_blank');
    }

    render() {
        const { user, programme, payment } = this.state
        const {handleLogout} = this.props
        return (
            <PaymentComponent
                handleButtonClick1={this.handleButtonClick1}
                handleLogout={handleLogout}
                handleButtonClick2={this.handleButtonClick2}
                payment={payment}
                programme={programme}
                user={user}
            />
        );
    }
}

export default withRouter(Payment);