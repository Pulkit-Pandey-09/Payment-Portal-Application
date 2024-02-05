import React from 'react';
import { Button, Form, Input } from 'antd';


const Login = ({onFinish, onFinishFailed}) => {
        return (
            <div style={{marginLeft:"400px"}}>
                <h5 style={{marginLeft:"200px"}}> Please login to fill your fees</h5>
                <Form
                    name="basic"
                    labelCol={{ span: 8, }}
                    wrapperCol={{ span: 16, }}
                    style={{ maxWidth: 450, }}
                    initialValues={{ remember: true, }}
                    onFinish={onFinish}
                    onFinishFailed={onFinishFailed}
                    autoComplete="off"
                >
                    <Form.Item label="Roll Number" name="rollNumber" rules={[{ required: true, message: 'Please input your roll numer!' }]}>
                        <Input value="rollNumber"/>
                    </Form.Item>
        
                    <Form.Item label="Password" name="password" rules={[{ required: true, message: 'Please input your password!' }]}>
                        <Input.Password  value="password"/>
                    </Form.Item>
    
                    <div style={{marginLeft:"170px"}}>
                    <Form.Item wrapperCol={{ offset: 8, span: 16, }}>
                            <Button type="primary" ghost htmlType="submit"> Login </Button>
                     </Form.Item>
                    </div>
                </Form>
            </div>
        );
}
export default Login;