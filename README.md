## Reddit-Clone: Project Two

## Technologies Used
1. HTML/CSS/JavaScript
2. Java
3. PostgreSQL
4. Springboot
5. BootStrap

## The Approach 

We initially debated about using the front-end from project 1 or creating a new front-end. We came to the conclusion that using a new front-end would allow us to practice our HTML/CSS/JavaScript skills. We then sketched an ERD diagram to begin visualizing the joining of our tables. The beginning of our files started by choosing the dependencies from spring.io and creating a maven project. We first created the models for  User, Post and Comments followed by the repositories, services and  controllers for each. We populated our tables through Postman and made sure our tables joined correctly before moving on. We then included spring security to generate tokens for our users. Junit testing was also implemented to simulate the behaviors of our methods in the controller and service package. 

## Unsolved problems & Major hurdles

Our hurdles included:

1. Difficulties joining tables in the beginning
2. User's post and comments were nested within each other making it difficult to appear on the front-end
3. After a user would make a post it would appear as "undefined".
4. The 'My Profile' button only shows the user's email and not the address and mobile. 

Most of our unsolved problems are in the front-end because we didn't get to link the back-end to the front-end completely. Therefore functionalities such as deleting posts and viewing/creating comments don't work.

## User Stories
1. As a Reddit user, I want to make posts about different topics so that I can share my thoughts.
2. As a Reddit user, I need to to be able to log in and keep my posts under my account so I can share my ideas.	
3. As a Reddit user, I would like to comment on other users posts to give feed back.	
4. As a Reddit user, I would like to delete a post if I change my mind. 


## Sketches

![Many to](https://user-images.githubusercontent.com/28772023/66508313-de7d5980-ea9e-11e9-9058-d22aa00eeac0.JPG)
![user Post](https://user-images.githubusercontent.com/28772023/66508518-4cc21c00-ea9f-11e9-9d8b-278bd00dba50.JPG)
![vien a user profile](https://user-images.githubusercontent.com/28772023/66508633-7d09ba80-ea9f-11e9-8106-57e612acfd60.jpg)
