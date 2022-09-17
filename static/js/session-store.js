export const sessionStore = Vuex.createStore({

    state () {
        selectedStudent: null;
    },

    mutations: {

        selectStudent(state, customer) {
            state.selectedCustomer = customer;
        }

    },

    plugins: [window.createPersistedState({storage: window.sessionStorage})]

}); 