import React from 'react'
import './style.css'
import { Typography, Row, Col} from 'antd';
import Programme from './Programme';
import programme from '../constants';
const { Title} = Typography;

const HomeComponent = ({handleButtonClick}) => {
    return (
        <div>
            <section className='header'>
                <Title className='title'> Delhi Technological University</Title>
                <Title className='subtitle' level={3}> Payment Portal</Title>
            </section>

            <section className='content'> <>
                <Row>
                   {programme.map((item) => (
                        <Col span={8} key={item.Id}>
                        <Programme className='Programme' name={item.name} Id={item.Id} handleButtonClick={handleButtonClick} src={"https://upload.wikimedia.org/wikipedia/commons/d/d5/DelhiCollegeOfEngineering_BawanaCampus.jpg"}/>
                        </Col>
                    ))}
                </Row>
            </>
            </section>

            <section className='footer'>
                <Title level={3}> Choose your programme to pay your fees</Title>
            </section>
        </div>
    )
}
export default HomeComponent;