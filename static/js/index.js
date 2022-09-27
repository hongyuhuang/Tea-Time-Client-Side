// create the Vue controller
const app = Vue.createApp();

// import the navigation menu
import { navigationMenu } from './navigation-menu.js';

// register the navigation menu under the <navmenu> tag
app.component('navmenu', navigationMenu);

// import data store
import { dataStore } from './data-store.js';
app.use(dataStore);

// import authentication module
import { BasicAccessAuthentication } from './authentication.js';

// attach the controller to the <main> tag
app.mount("main");

