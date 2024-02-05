import React from "react";
import {Table, Typography} from 'antd';
import {columns} from "../constants"
const { Title } = Typography;
const ReceiptComponent = ({user, programme, payment}) => {
    
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
            name: "Payment ID",
            value: payment.paymentId
        },
        {
            key: '5',
            name: "Amount",
            value: payment.amount +  " " + "INR"
        }, 
        {
            key: '6',
            name: "Status",
            value: payment.status
        },
        {
            key: '7',
            name: "Payment Date",
            value: payment.paymentDate
        },
    ]
    return(
        <div>
         <Title level={2} style={{ marginLeft: "550px", marginTop: "100px", marginRight:"300px" }}>Payment Receipt</Title>
         <Title level={4} style={{ marginLeft: "500px", marginTop: "0px", marginRight:"300px" }}>Delhi Technological University, Delhi</Title>
                <div style={{ marginTop: "50px", marginBottom: "50px", marginLeft: "550px", marginRight: "650px" }}>
                    <Table columns={columns} dataSource={data} pagination={false} style={{boxShadow:"rgba(0, 0, 0, 0.24) 0px 3px 8px"}}></Table>
                </div>
        
        </div>
    );
}

export default ReceiptComponent;