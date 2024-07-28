# Payment-Portal-Application
This project focusses on payment portal application for the university. This application provides a convenience for the registered students in the university to pay their college fees. The prime features of this application includes : 
1. User Authentication
2. Easy payment
3. Transaction Management
4. User friendly interface

 # Time Line followed to build this project
 1. User Stories
First, I tried to capture the requirements the user would want to have from the application. I worked on describing the feature, or you can say the requirements from the perspective of the end user.
Now, students would be enrolled in various programs, like mtech and btech. So, students would want to select their respective programs to see the fee structure and what is the amount that he or she needs to pay.
Further, the user would want to log in to pay his fees.
After logging in, what is the obvious requirement? User pays his fees. Now, I thought of implementing a third party API for payment portals (like stripe, razorpay).
What else? So After making the payment, user would want to preview his receipt or invoice of the payment
Then, the user just wants to log out.

Adding to this, I also worked on writing a use case, the detailed description of how users would be interacting with the system.

2. Wireframes
Then I made a wireframe for my  application. The structure of the application would look like. I used the balsamiq software to do so.

3. APIs
Now, I am done with user stories. How would I implement these features? So here comes the picture of the API. Application programming Interface. API acts as interface between two software components so that they can communicate and interact with each other according to the to some rules and requirements (which we call them as API contracts). So, I made API contracts for my application
What was my thought process in making the API. I'll explain to you with an example of user stories.

User would like to select his programme to see his fee structure. So, do I need an API for this? Can I just hardcode the values of fees in my frontend component? This was my initial thought. But, after some thinking and reading few blogs. I thought what if in future I decide to change my fee structure. Then I would have to deploy my application again. We don't want that. 
So, it would be good. I fetch the fee structure of the programme via an API. that from my backend. 
So, in order to create an API, things that we keep in mind are what would be the resource and maybe subresource, what would be my request body and what would be the response body. 
So, I went back to my use stories.
So my user stories was - Users want to select respective programmes to get the fee structure and amount.
So from here I could see that a program (a noun) is a resource. Now which programme. So I need to specify which program the user wants. So, I gained the knowledge of path variables.
Now, furthermore. What is the method that I have to use? I am just fetching  my  fee data. I am not updating and creating and instance in DB. So it definitely would be Get Request.
Similarly, I made my other API.
The login api. I am authenticating the user. A post request in which a student is sending his credentials to authenticate himself. I also gave special attention to frame api names so that all the api are self explanatory.
APIs - get programme, post login, post info, post payment, get receipt.

4. DB Schemas
Now comes the turn for designing my schemas
I need to have a database to store my record. I used a mysql database. What data do I want to store? What are the resources my APIs have? Resources were primarily programme. User information. Payment information. So these are entities that I need. Then, I defined the attributes these entities would be requiring. For example, a user entity would basically have a username, rollNumber, password. Yeah that’s it. I formed relationship with my entities using foreign keys and primary keys keeping in mind mapping cardinality, whether the entities are mapped one-to-one, one-to-many and so on. Before u actually create a relational model from entity relation diagram u need to perform a check. I followed the basic normal forms (1NF, 2NF). Like no attribute should be composite. For example, I destructured  the user name into first name and last name.

In the end, I exploited the knowledge spring boot and react to develop frontend and backend for my application.
1. JDBC, JPA, HIBERNATE
2. Authentication and Authorization
3. JWT token to authenticate the user
4. React.
