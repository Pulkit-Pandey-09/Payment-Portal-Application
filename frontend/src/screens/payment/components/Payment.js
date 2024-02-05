import React from "react";
import { Button, Space, Table ,Typography} from 'antd';
import { columns } from "../constants"
const { Title } = Typography;
const PaymentComponent = ({ handleButtonClick1, handleLogout, handleButtonClick2, payment, programme, user }) => {
    const data = [
        {
            key: '1',
            name: "Name",
            value: user.firstName + " " + user.lastName
        },
        {
            key: '2',
            name: "Roll Number",
            value: user.rollNumber
        },
        {
            key: '3',
            name: "Programme",
            value: programme.programmeName
        },
        {
            key: '4',
            name: "Amount to be paid",
            value: programme.amount + " " + "INR"
        },
        {
            key: '5',
            name: "Payment Status",
            value: payment.paymentStatus
        },

    ]
    return (
    <div>
            <Title level={2} style={{ marginLeft: "590px", marginTop: "100px", marginRight:"300px" }}>Payment Details</Title>
        <div className="portal" style={{ marginLeft: "200px", marginTop: "100px", marginRight:"300px" }}>

            <div style={{ marginTop: "20px", marginBottom: "50px", marginLeft: "250px", marginRight: "200px" }}>
                <Table columns={columns} dataSource={data} pagination={false} style={{boxShadow:"rgba(0, 0, 0, 0.24) 0px 3px 8px"}}></Table>
            </div>
        </div>
        <div className="myBtn" style={{marginLeft:"500px"}}>
            <Space size={15}>
            {(payment.paymentStatus === "Payment Received.") ?
                (<div style={{ marginTop: "20px", marginLeft: "115px" }}>
                    <Button type="primary" ghost htmlType="submit" onClick={() => handleButtonClick2()}> Print </Button>
                </div>) :
                (<div style={{ marginTop: "20px", marginLeft: "85px" }}>
                    <Button type="primary" ghost htmlType="submit" onClick={() => handleButtonClick1()}> Proceed to pay </Button>
                </div>)}

            <div style={{ marginTop: "20px", marginLeft: "0px" }}>
                <Button type="primary" ghost danger htmlType="submit" onClick={()=>handleLogout()}> Logout </Button>
            </div>
            </Space>
        </div>
    </div>
    );
    // }
}

export default PaymentComponent;