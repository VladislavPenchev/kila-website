function addNewImage() {
    const addUploadBtn = document.getElementById('addUploadButton');
    const uplImgCon = document.querySelector('.container.upl-img');

    addUploadBtn.addEventListener('click', addUploadBtnFn);

    function addUploadBtnFn() {
        const divWrapper = document.createElement('div');
        divWrapper.classList.add("inputs");
        divWrapper.classList.add('inp-img');

        const uplBtnLabel = document.createElement('label');
        uplBtnLabel.classList.add('button');
        uplBtnLabel.classList.add('add-new-line');
        uplBtnLabel.setAttribute('id', 'uploadImage');
        uplBtnLabel.innerHTML += 'Upload';

        const uplInput = document.createElement('input');
        uplInput.setAttribute('type', 'file');
        uplInput.setAttribute('name', 'imageFile');
        uplInput.onchange = onChangeInput;

        function onChangeInput(e) {
            if (e.target.files && e.target.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    const divWrap = document.createElement('div');
                    divWrap.setAttribute('id', 'divDescription')
                    divWrap.classList.add('inputs');

                    const img = document.createElement('img');
                    img.setAttribute('src', e.target.result);
                    img.classList.add('add-img');

                    const divDel = document.createElement('div');
                    divDel.classList.add('button');
                    divDel.classList.add('delete');
                    divDel.innerHTML += 'DELETE';

                    divWrap.appendChild(img);
                    divWrap.appendChild(divDel);
                    divWrapper.appendChild(divWrap);

                    (function (index) {

                        divDel.addEventListener('click', function () {
                            divWrapper.remove();
                        });
                    })(divWrapper)
                };

                uplBtnLabel.classList.add('after-upload');
                
                reader.readAsDataURL(e.target.files[0]);
            }
        };

        uplBtnLabel.appendChild(uplInput);
        divWrapper.appendChild(uplBtnLabel);
        uplImgCon.appendChild(divWrapper);
    }

}

addNewImage();
