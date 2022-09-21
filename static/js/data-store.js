export const dataStore = Vuex.createStore({

    state() {
        // signed in customer
        customer: null;

        // the shopping cart items
        items: null;

        // selected product
        selectedProduct: null;
    },

    mutations: {

        // user signs in
        signIn(state, customer) {
            state.customer = customer;
            state.items = new Array();
        },
        
        // user selects a product
        selectProduct(state, product) {
            state.selectedProduct = product;
        },  
        
        // add item to cart
        addItem(state, item) {
            state.items.push(item);
        }
    },

    // add session storage persistence
    plugins: [window.createPersistedState({storage: window.sessionStorage})]

});