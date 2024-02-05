import React from 'react';
import { Table } from 'antd';
import { columns } from "../constants"


const Fee = ({ res }) => {
    const { programmeName, tuitionFee, libraryFee, messFee, medicalFee, hostelFee, amount } = res
    const data = [
        {
            key: '1',
            name: "Programme Name",
            value: programmeName
        },
        {
            key: '2',
            name: "Tuition Fee",
            value: tuitionFee
        },
        {
            key: '3',
            name: "Library Fee",
            value: libraryFee
        },
        {
            key: '4',
            name: "Mess Fee",
            value: messFee
        },
        {
            key: '5',
            name: "Medical Fee",
            value: medicalFee
        },
        {
            key: '6',
            name: "Hostel Fee",
            value: hostelFee
        },
        {
            key: '7',
            name: "Total Amount",
            value: amount
        },
    ]
    
    return (
        <div style={{ marginTop: "50px", marginBottom: "50px", marginLeft: "400px", marginRight: "500px"}}>
       <Table columns={columns} dataSource={data} pagination={false} style={{boxShadow:"rgba(0, 0, 0, 0.24) 0px 3px 8px"}}></Table>
       
    
        </div>
    )
}


export default Fee;