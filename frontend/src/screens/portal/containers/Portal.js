import React , {Component} from "react";
import PortalComponent from "../components";
import withRouter from "../../../utils/withRouterHOC";
import { getAPI} from "../../../utils/api";
class Portal extends Component{

    handleButtonClick = () => {
        const {location} = this.props;
        const {paymentId} = location.state;

        getAPI("/student/payment/" + paymentId, "")
        .then((response) => {
            window.open('/receipt/'+ paymentId, '_blank');
        })
        .catch((error) => {
            console.log(error)
        })
    };

    render(){
        const {location, handleLogout} = this.props;
        const {paymentId,status} = location.state;
            return (
                <PortalComponent
                    handleButtonClick={this.handleButtonClick}
                    handleLogout={handleLogout}
                    paymentId={paymentId}
                    status={status}
                />
            );
    }
}

export default withRouter(Portal);