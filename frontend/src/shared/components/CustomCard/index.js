import React from 'react'
import { Card,Space } from 'antd';


const CustomCard = ({style, src, content}) => { return (
    <Card hoverable style={style}  cover={<img alt="" src={src} />}>
     <Space wrap>
        {content}
     </Space>
    </Card>
)
}
export {CustomCard}

