window.onload = function () {
    const minusButton = document.getElementById('minus');
    const plusButton = document.getElementById('plus');
    const inputField = document.getElementById('input');
    const numInputs = document.querySelectorAll('input[type=number]');

    numInputs.forEach(function (input) {
        input.addEventListener('change', function (e) {
            if (e.target.value === '') {
                e.target.value = 0;
            }
        });
    });

    // Listen for input event on numInput.
    inputField.onkeydown = function (e) {
        if (!((e.keyCode > 95 && e.keyCode < 106)
                || (e.keyCode > 47 && e.keyCode < 58)
                || e.keyCode === 8)) {
            return false;
        }
    };

    minusButton.addEventListener('click', event => {
        event.preventDefault();
        const currentValue = Number(inputField.value) || 0;
        if (currentValue !== 0) {
            inputField.value = currentValue - 1;
        }
    });

    plusButton.addEventListener('click', event => {
        event.preventDefault();
        const currentValue = Number(inputField.value) || 0;
        inputField.value = currentValue + 1;
    });
};