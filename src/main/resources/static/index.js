let progressBar = document.getElementById('progress-bar')

let dropPrompt = document.getElementById('drop-prompt')

let dropArea = document.getElementById('drop-area')

let buttonSendFiles = document.getElementById('button-send-files')
buttonDisable(buttonSendFiles)

let fileSender = document.getElementById('fileElem')

let form = document.getElementById('form')

let fileToBeSend = null

buttonSendFiles.onclick = () => {
  if (buttonSendFiles.className != 'disabled' && fileToBeSend != null) {
    form.submit() 
  }
}

;['dragenter', 'dragover', 'dragleave', 'drop'].forEach(eventName => {
    dropArea.addEventListener(eventName, preventDefaults, false)
  })
  function preventDefaults (e) {
    e.preventDefault()
    e.stopPropagation()
    ;['dragenter', 'dragover'].forEach(eventName => {
      dropArea.addEventListener(eventName, highlight, false)
    })
  
    ;['dragleave', 'drop'].forEach(eventName => {
      dropArea.addEventListener(eventName, unhighlight, false)
    })
  
  }

  ;['dragenter', 'dragover'].forEach(eventName => {
    dropArea.addEventListener(eventName, highlight, false)
  })

  ;['dragleave', 'drop'].forEach(eventName => {
    dropArea.addEventListener(eventName, unhighlight, false)
  })

  function highlight(e) {
    dropArea.classList.add('highlight')
  }

  function unhighlight(e) {
    dropArea.classList.remove('highlight')
  }

dropArea.addEventListener('drop', handleDrop, false)

function handleDrop(e) {
  let dt = e.dataTransfer
  let files = dt.files

  if (checkFileFormat(files[0], '.csv')) {
    if (files.length > 1) {
      dropPrompt.innerHTML = 'Ошибка. Загрузите только один файл'
      buttonDisable(buttonSendFiles)
      initializeProgress()
    }
    else {
      dropPrompt.innerHTML = 'Файл ' + files[0].name + ' загружен успешно'
      progressDone()
      buttonEnable(buttonSendFiles)
      fileToBeSend = files[0]
      fileSender.files = dt.files;
    }
  }
}

function uploadFile(file) {
  let url = 'upload'
  let formData = new FormData()
  formData.append('file', file)
  fetch(url, {
    method: 'POST',
    body: formData
  })
  .then(progressDone)
}

function initializeProgress() {
  progressBar.value = 0
}

function progressDone() {
  progressBar.value = 100
}

function buttonDisable(button) {
  button.className = 'disabled'
}

function buttonEnable(button) {
  button.className = 'button'
}

function checkFileFormat(file, format) {
  fileName = file.name
  if ((fileName.slice(fileName.length - 4) == format)) {
    return true
  }
  else {
    dropPrompt.innerHTML = 'Ошибка. Загружен файл неправильного формата. Загрузите файл с расширением .csv'
    return false
  }
}



// /*Dropdown Menu*/
// $('.dropdown').click(function () {
//   $(this).attr('tabindex', 1).focus();
//   $(this).toggleClass('active');
//   $(this).find('.dropdown-menu').slideToggle(300);
// });
// $('.dropdown').focusout(function () {
//   $(this).removeClass('active');
//   $(this).find('.dropdown-menu').slideUp(300);
// });
// $('.dropdown .dropdown-menu li').click(function () {
//   $(this).parents('.dropdown').find('span').text($(this).text());
//   $(this).parents('.dropdown').find('input').attr('value', $(this).attr('id'));
// });
// /*End Dropdown Menu*/


// $('.dropdown-menu li').click(function () {
// var input = '<strong>' + $(this).parents('.dropdown').find('input').val() + '</strong>',
// msg = '<span class="msg">Hidden input value: ';
// $('.msg').html(msg + input + '</span>');
// }); 