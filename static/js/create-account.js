var customersApi = "/api/register";

const app = Vue.createApp({

    data() {
        return {
            // models map (comma separated key/value pairs)
            customer : new Object()
        };
    },

    mounted() {
        // semicolon separated statements

    },

    methods: {
        // comma separated function declarations
           createAccount() {
            //const customer = {id: this.id, username: this.username, firstName: this.firstName, surname: this.surname, emailAddress: this.emailAddress, shippingAddress: this.shippingAddress,password: this.password};

            axios.post(customersApi, this.customer)
                    .then(() => {
                        window.location = 'sign-in.html';
                    })
                    .catch(error => {
                        alert(error.response.data.message);
                    });
        }
    },

    // other modules
    mixins: []

});

// other component imports go here
// import the navigation menu
import { navigationMenu } from './navigation-menu.js';

// register the navigation menu under the <navmenu> tag
app.component('navmenu', navigationMenu);

// import data store
import { dataStore } from './data-store.js';
app.use(dataStore);


// mount the page - this needs to be the last line in the file
app.mount("main");