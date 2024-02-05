import React from "react";
import { Button, Table, Typography, Space} from 'antd';
import {columns} from "../constants"
const { Title } = Typography;
const PortalComponent = ({handleButtonClick,handleLogout, paymentId, status}) => {
    // const {paymentId, status} = res
    const data = [
        {
            key: '1',
            name: "Payment Status",
            value: status
        },
        {
            key: '2',
            name: "Payment ID",
            value: paymentId
        },
    ]
    return (
        <div>
            <Title level={2} style={{ marginLeft: "590px", marginTop: "100px", marginRight:"300px" }}>Thank you!!</Title>
            <div style={{ marginTop: "100px", marginBottom: "50px", marginLeft: "500px", marginRight: "600px" }}>
                <Table columns={columns} dataSource={data} pagination={false} style={{boxShadow:"rgba(0, 0, 0, 0.24) 0px 3px 8px"}}></Table>
            </div>

            <div>
            <Space size={15}>
            <div style={{marginTop:"20px", marginLeft:"570px"}}>
                <Button type="primary" ghost htmlType="submit" onClick={() => handleButtonClick()}> Print receipt </Button>
            </div>

                <div style={{marginTop:"20px"}}>
                <Button type="primary" ghost danger htmlType="submit"onClick={()=>handleLogout()}> Logout </Button> 
                </div>
            </Space>
            </div>
        </div>
    );
}

export default PortalComponent;