import { Button, Space } from "antd";
import React from 'react'


const PrimaryButton = ({onClick, name, type}) => {  
    return (
        <Space className="site-button-ghost-wrapper" wrap>
          <Button type={type} ghost onClick={onClick}>{name} </Button>
        </Space>
    )
}


export {PrimaryButton}