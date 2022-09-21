"use strict";

// JavaScript equivalents of the Sale and SaleItem domain classes. 
// These will be used to generate JSON that is compatible with the Java versions.
class SaleItem {
    constructor(product, quantityPurchased) {
        this.product = product;
        this.quantityPurchased = quantityPurchased;
        this.salePrice = product.listPrice;
    }
}

class Sale {
    constructor(customer, items) {
        this.customer = customer;
        this.items = items;
    }
}

const app = Vue.createApp({

    data() {
        return {
            // models (comma separated key/value pairs)
            quantity: 1
        };
    },

    computed: Vuex.mapState({
        product: 'selectedProduct',
        items: 'items',
        customer: 'customer'
    }),

    mounted() {
        // semicolon separated statements


    },

    methods: {
        // comma separated function declarations
        addProductToCart() {
            dataStore.commit("addItem", new SaleItem(this.product, this.quantity));
            window.location = "view-products.html";
        },
        increment() {
            this.quantity++;
        },
        decrement() {
            if (this.quantity !== 1) {
                this.quantity--;
            }
        },
        isNumber: function (evt) {
            evt = (evt) ? evt : window.event;
            var charCode = (evt.which) ? evt.which : evt.keyCode;
            if ((charCode > 31 && (charCode < 48 || charCode > 57)) && charCode !== 46) {
                evt.preventDefault();
                ;
            } else {
                return true;
            }
        },
        isEmpty: function(evt) {
             if (evt.target.value === '') {
                evt.target.value = 1;
            }
        }
    }
});

/* other component imports go here */
// import the navigation menu
import { navigationMenu } from './navigation-menu.js';

// register the navigation menu under the <navmenu> tag
app.component('navmenu', navigationMenu);

// import data store
import { dataStore } from './data-store.js';
app.use(dataStore);

// mount the page - this needs to be the last line in the file
app.mount("main");