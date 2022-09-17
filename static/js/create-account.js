const app = Vue.createApp({

    data() {
        return {
            // models map (comma separated key/value pairs)

        };
    },

    mounted() {
        // semicolon separated statements

        // alert('Mounted method called');

    },

    methods: {
        // comma separated function declarations

    },

    // other modules
    mixins: []

});

// other component imports go here
// import the navigation menu
import { navigationMenu } from './navigation-menu.js';

// register the navigation menu under the <navmenu> tag
app.component('navmenu', navigationMenu);


// mount the page - this needs to be the last line in the file
app.mount("main");