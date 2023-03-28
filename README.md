# Tea Time

The objective of the project was to create a client-side rendered web based online shopping application that allows registered customers to purchase products. This web application is an iteration of the https://github.com/hongyuhuang/Tea-Time-Server-Side.

The website is a multi page application and the user must create an account and sign in in order for them to view products and add them to the cart. The page uses Vue.js to load only part of the navigation menu depending if there is a customer in the session store or not. The back end is mostly done through Jooby which is a mini framework in Java. There is also basic HTTP authentication built into the applicaiton and some client side validation.

The web application can be run by running `Server.java`.

<img width="1440" alt="Screen Shot 2022-09-28 at 8 35 39 PM" src="https://user-images.githubusercontent.com/31984374/192717433-ca9e11f7-fa73-45be-b096-05c3ce178338.png">

<img width="1440" alt="Screen Shot 2022-09-28 at 8 36 21 PM" src="https://user-images.githubusercontent.com/31984374/192717561-9a3efc7f-36c6-45de-9e9b-6755e30b1ba4.png">

<img width="1440" alt="Screen Shot 2022-09-28 at 8 38 01 PM" src="https://user-images.githubusercontent.com/31984374/192717993-40df587b-3c7b-4523-a5b9-5b579a732ec4.png">

Some improvments that can be made is server side validation using OVal and the ability for a user to edit the cart.
