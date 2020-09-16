function addDiscrography() {
    const addDiscographyLineBtn = document.getElementById('addNewDiscography');
    const discographyContainer = document.querySelector('.section-create-video .description');

    addDiscographyLineBtn.addEventListener('click', addNewDisco);

    function addNewDisco() {
        const divWrapInputs = document.createElement('div');
        divWrapInputs.className = 'inputs';    
        discographyContainer.appendChild(divWrapInputs);

        const newLineInput = document.createElement('input');
        newLineInput.setAttribute('type', 'text');
        newLineInput.setAttribute('name', 'song');

        const deleteBtn = document.createElement('div');
        deleteBtn.className = 'button delete';
        deleteBtn.innerHTML = 'DELETE';

        (function () {
            deleteBtn.addEventListener('click', function () {
                divWrapInputs.remove();
            });
        })(divWrapInputs);

        divWrapInputs.appendChild(newLineInput);
        divWrapInputs.appendChild(deleteBtn);

    }
}

addDiscrography();

