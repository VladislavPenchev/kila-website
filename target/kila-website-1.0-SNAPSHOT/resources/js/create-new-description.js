function x() {
    const addDescriptionLineBtn = document.getElementById('addDescriptionNewLine');
    const deleteDescriptionLineBtn = document.getElementById('deleteDescription');
    const descriptionContainer = document.querySelector('.section-create-video .description');
    const addTagBtn = document.getElementById('addTag');
    const deleteTagBtn = document.getElementById('deleteTag');
    const tagContainer = document.querySelector('.section-create-video .tag');
    const addSingerBtn = document.getElementById('addSinger');
    const deleteSingerBtn = document.getElementById('deleteSinger');
    const singerContainer = document.querySelector('.section-create-video .singer');

    addDescriptionLineBtn.addEventListener('click', addNewDesc);
    deleteDescriptionLineBtn.addEventListener('click', deleteNewDesc);
    addTagBtn.addEventListener('click', addNewTag);
    // deleteTagBtn.addEventListener('click', deleteNewTag);
    addSingerBtn.addEventListener('click', addNewSinger);
    // deleteSingerBtn.addEventListener('click', deleteSingerBtn);

    function addNewDesc() {
        const divWrapInputs = document.createElement('Div');
        divWrapInputs.setAttribute('id', 'divDescription-1')
        divWrapInputs.className = 'inputs';    
        descriptionContainer.appendChild(divWrapInputs);

        const newLine = document.createElement('Input');
        newLine.setAttribute('type', 'text');
        newLine.setAttribute('id', 'descriptionInput');
        newLine.setAttribute('name', 'description');

        const deleteBtn = document.createElement('Div');
        deleteBtn.setAttribute('id', 'deleteDescription-1');
        deleteBtn.className = 'button delete';
        deleteBtn.innerHTML = 'DELETE';
        deleteBtn.addEventListener('click', deleteNewDesc);

        divWrapInputs.appendChild(newLine);
        divWrapInputs.appendChild(deleteBtn);
    }

    function deleteNewDesc() {
        const buttonId = this.id;
        const idNumber = buttonId.split('-')[1];

        if(buttonId === 'deleteDescription') {
            return;
        }

        const divToDelete = document.getElementById(`divDescription-${idNumber}`)
                            .remove();
    }

    function addNewTag() {
        console.log('yyy');
        const newLine = document.createElement('Input');
        newLine.setAttribute('type', 'text');
        newLine.setAttribute('id', 'tagInput');
        newLine.setAttribute('name', 'tag');

        tagContainer.appendChild(newLine);
    }

    function addNewSinger() {
        console.log('zzz');
        const newLine = document.createElement('Input');
        newLine.setAttribute('type', 'text');
        newLine.setAttribute('id', 'singerInput');
        newLine.setAttribute('name', 'singer');

        singerContainer.appendChild(newLine);
    }

}

x();

