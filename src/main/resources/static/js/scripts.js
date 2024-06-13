let predatorTypeSelect;
let herbivoreTypeSelect;
let predatorTypes = [];
let herbivoreTypes = [];
let isModalOpen = false; // Глобальная переменная для отслеживания состояния модального окна


function updateIsland() {
    fetch(`/api/island`)
        .then(response => response.json())
        .then(data => {
            // Очищаем карту перед обновлением
            document.querySelector('.island').innerHTML = '';

            // Проходимся по строкам и столбцам острова
            data.forEach((row, rowIndex) => {
                let rowElement = document.createElement('div');
                rowElement.classList.add('row');

                row.forEach((cell, colIndex) => {
                    let cellElement = document.createElement('div');
                    cellElement.classList.add('cell');

                    // Преобразуем массив в строку с разделением
                    cellElement.textContent = cell.join(', ');

                    cellElement.dataset.row = rowIndex;
                    cellElement.dataset.col = colIndex;
                    rowElement.appendChild(cellElement);
                });

                document.querySelector('.island').appendChild(rowElement);
            });
        })
        .catch(error => console.error('Error fetching island data:', error));
    setTimeout(function() {
        if (!isModalOpen) {
            location.reload();
        }
    }, 5000);
}


function addPredator() {
    const predatorType = predatorTypeSelect.value;
    fetch(`/api/animals/predator?predatorType=${predatorType}`, { method: 'POST' })
        .then(response => {
            if (response.ok) {
                updateIsland();
                location.reload();
            } else {
                console.error('Failed to add predator');
            }
        })
        .catch(error => console.error('Error adding predator:', error));
}


function addHerbivore() {
    const herbivoreType = herbivoreTypeSelect.value;
    fetch(`/api/animals/herbivore?herbivoreType=${herbivoreType}`, { method: 'POST' })
        .then(response => {
            if (response.ok) {
                updateIsland();
                location.reload();
            } else {
                console.error('Failed to add herbivore');
            }
        })
        .catch(error => console.error('Error adding herbivore:', error));
}


function addRandomAnimal() {
    const isPredator = Math.random() < 0.5; // 50% шанс выбрать хищника или травоядного

    if (isPredator) {
        const randomPredator = predatorTypes[Math.floor(Math.random() * predatorTypes.length)];
        fetch(`/api/animals/predator?predatorType=${randomPredator}`, { method: 'POST' })
            .then(response => {
                if (response.ok) {
                    if (!isModalOpen) {
                        location.reload();
                    }
                } else {
                    console.error('Failed to add predator');
                }
            })
            .catch(error => console.error('Error adding predator:', error));
    } else {
        const randomHerbivore = herbivoreTypes[Math.floor(Math.random() * herbivoreTypes.length)];
        fetch(`/api/animals/herbivore?herbivoreType=${randomHerbivore}`, { method: 'POST' })
            .then(response => {
                if (response.ok) {
                    if (!isModalOpen) {
                        location.reload();
                    }
                } else {
                    console.error('Failed to add herbivore');
                }
            })
            .catch(error => console.error('Error adding herbivore:', error));
    }
}


function showCellDetails(x, y) {
    fetch(`/api/island/cell?x=${x}&y=${y}`)
        .then(response => response.json())
        .then(data => {
            let modalContentText = document.getElementById('modal-content-text');
            if (modalContentText) {
                modalContentText.innerText = `${data.join(', ')}`;
                document.getElementById('modal').style.display = 'block';
                isModalOpen = true; // Устанавливаем флаг открытия модального окна
            } else {
                console.error('Element with id modal-content-text not found.');
            }
        })
        .catch(error => console.error('Error fetching cell details:', error));
}


function closeModal() {
    document.getElementById('modal').style.display = 'none';
    isModalOpen = false; // Сбрасываем флаг открытия модального окна
}

document.addEventListener('DOMContentLoaded', function () {

    let selectedPredatorType = localStorage.getItem('selectedPredatorType');
    let selectedHerbivoreType = localStorage.getItem('selectedHerbivoreType');


    predatorTypeSelect = document.getElementById('predatorType');
    herbivoreTypeSelect = document.getElementById('herbivoreType');

    if (selectedPredatorType) {
        predatorTypeSelect.value = selectedPredatorType;
    }
    predatorTypeSelect.addEventListener('change', function() {
        selectedPredatorType = this.value;
        localStorage.setItem('selectedPredatorType', selectedPredatorType);
    });

    if (selectedHerbivoreType) {
        herbivoreTypeSelect.value = selectedHerbivoreType;
    }
    herbivoreTypeSelect.addEventListener('change', function() {
        selectedHerbivoreType = this.value;
        localStorage.setItem('selectedHerbivoreType', selectedHerbivoreType);
    });


    document.addEventListener('click', function(event) {
        if (event.target.classList.contains('cell')) {
            const x = event.target.dataset.row;
            const y = event.target.dataset.col;
            showCellDetails(x, y);
        }
    });


    fetch(`/api/enums/predatorTypes`)
        .then(response => response.json())
        .then(data => {
            predatorTypes = data;
            predatorTypes.forEach(type => {
                let option = document.createElement('option');
                option.value = type;
                option.textContent = type;
                predatorTypeSelect.appendChild(option);
            });
        })
        .catch(error => console.error('Error fetching predator types:', error));

    fetch(`/api/enums/herbivoreTypes`)
        .then(response => response.json())
        .then(data => {
            herbivoreTypes = data; // Сохраняем типы травоядных
            herbivoreTypes.forEach(type => {
                let option = document.createElement('option');
                option.value = type;
                option.textContent = type;
                herbivoreTypeSelect.appendChild(option);
            });
        })
        .catch(error => console.error('Error fetching herbivore types:', error));


    setInterval(addRandomAnimal, 5000);
    updateIsland();
});
