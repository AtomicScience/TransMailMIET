let progressBar = document.getElementById('progress-bar')

let dropPrompt = document.getElementById('drop-prompt')

let dropArea = document.getElementById('drop-area')

let buttonSendFiles = document.getElementById('button-send-files')
buttonDisable(buttonSendFiles)


;['dragenter', 'dragover', 'dragleave', 'drop'].forEach(eventName => {
    dropArea.addEventListener(eventName, preventDefaults, false)
  })
  function preventDefaults (e) {
    e.preventDefault()
    e.stopPropagation()
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
      buttonEnable(buttonSendFiles)
      handleFiles(files[0])
    }
  }
}

function handleFiles(file) {
  initializeProgress()
  uploadFile(file)
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