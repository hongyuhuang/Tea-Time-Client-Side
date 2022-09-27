var customer = ({username}) => `/api/customers/${username}`;

const app = Vue.createApp({

    data() {
        return {
            // models map (comma separated key/value pairs)
            customer: new Object()
        };
    },

    mounted() {
        // semicolon separated statements

        // alert('Mounted method called');

    },

    methods: {
        // comma separated function declarations
        signIn(){
            this.createToken(this.customer.username, this.customer.password);
            axios.get(customer({'username': this.customer.username}))
                    .then(response => {
                        this.customer = response.data;
                        dataStore.commit("signIn", this.customer);
                        window.location = 'index.html';
                    })
                    .catch(error => {
                        alert(error.response.data.message);
                    });
        }
    },

    // other modules
    mixins: [BasicAccessAuthentication]

});

// other component imports go here
// import the navigation menu
import { navigationMenu } from './navigation-menu.js';

// register the navigation menu under the <navmenu> tag
app.component('navmenu', navigationMenu);

// import data store
import { dataStore } from './data-store.js';
app.use(dataStore);

// import authentication module
import { BasicAccessAuthentication } from './authentication.js';

// mount the page - this needs to be the last line in the file
app.mount("main");