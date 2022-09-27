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

var salesApi = '/api/sales';
var total = 0;

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
            if (this.quantity < this.product.quantityInStock)
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
        isEmpty: function (evt) {
            if (evt.target.value === '' || evt.target.value.charAt(0) === '0') {
                this.quantity = 1;
            }
            if (evt.target.value > this.product.quantityInStock) {
                this.quantity = this.product.quantityInStock;
            }
        },
        checkOut() {
            let sale = new Sale(this.customer, this.items);
            console.log();
            axios.post(salesApi, sale)
                    .then(() => {
                        dataStore.commit("clearItems");
                        window.location = 'order-confirmation.html';
                    })
                    .catch(error => {
                        alert(error.response.data.message);
                    });
        },
        getItemTotal(item) {
            var itemTotal = item.salePrice * item.quantityPurchased;
            total += itemTotal;
            return itemTotal;
        },
        getTotal() {
            return total;
        },
        getImgUrl() {
            return this.product.filePath;
        },
        getItemUrl(item) {
            return item.product.filePath;
        }
    },

    // other modules
    mixins: [NumberFormatter]
});

/* other component imports go here */
// import the navigation menu
import { navigationMenu } from './navigation-menu.js';

// register the navigation menu under the <navmenu> tag
app.component('navmenu', navigationMenu);

// import data store
import { dataStore } from './data-store.js';
app.use(dataStore);

//import number formatter
import { NumberFormatter } from './number-formatter.js';

// mount the page - this needs to be the last line in the file
app.mount("main");