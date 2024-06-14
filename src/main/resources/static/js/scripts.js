let predatorTypeSelect;
let herbivoreTypeSelect;
let predatorTypes = [];
let herbivoreTypes = [];
let isModalOpen = false;
let updateInterval;

function fetchConfigAndData() {
    return Promise.all([
        fetch('/api/update-config').then(response => response.json()),
        fetch('/api/enums/predatorTypes').then(response => response.json()),
        fetch('/api/enums/herbivoreTypes').then(response => response.json())
    ]);
}

function updateIsland() {
    fetch(`/api/island`)
        .then(response => response.json())
        .then(data => {
            document.querySelector('.island').innerHTML = '';

            data.forEach((row, rowIndex) => {
                let rowElement = document.createElement('div');
                rowElement.classList.add('row');

                row.forEach((cell, colIndex) => {
                    let cellElement = document.createElement('div');
                    cellElement.classList.add('cell');
                    cellElement.textContent = cell.join(', ');

                    cellElement.dataset.row = rowIndex;
                    cellElement.dataset.col = colIndex;
                    rowElement.appendChild(cellElement);
                });

                document.querySelector('.island').appendChild(rowElement);
            });
        })
        .catch(error => console.error('Error fetching island data:', error));
}

function addPredator() {
    const predatorType = predatorTypeSelect.value;
    fetch(`/api/animals/predator?predatorType=${predatorType}`, { method: 'POST' })
        .then(response => {
            if (response.ok) {
                updateIsland();
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
            } else {
                console.error('Failed to add herbivore');
            }
        })
        .catch(error => console.error('Error adding herbivore:', error));
}

function addRandomAnimal() {
    const isPredator = Math.random() < 0.5;

    if (isPredator) {
        const randomPredator = predatorTypes[Math.floor(Math.random() * predatorTypes.length)];
        console.log('Adding predator:', randomPredator); // Выводим тип хищника в консоль
        fetch(`/api/animals/predator?predatorType=${randomPredator}`, { method: 'POST' })
            .then(response => {
                if (response.ok) {
                    updateIsland();
                } else {
                    console.error('Failed to add predator');
                }
            })
            .catch(error => console.error('Error adding predator:', error));
    } else {
        const randomHerbivore = herbivoreTypes[Math.floor(Math.random() * herbivoreTypes.length)];
        console.log('Adding herbivore:', randomHerbivore); // Выводим тип травоядного в консоль
        fetch(`/api/animals/herbivore?herbivoreType=${randomHerbivore}`, { method: 'POST' })
            .then(response => {
                if (response.ok) {
                    updateIsland();
                } else {
                    console.error('Failed to add herbivore');
                }
            })
            .catch(error => console.error('Error adding herbivore:', error));
    }
    updateIsland();
    location.reload();
}

function showCellDetails(x, y) {
    fetch(`/api/island/cell?x=${x}&y=${y}`)
        .then(response => response.json())
        .then(data => {
            let modalContentText = document.getElementById('modal-content-text');
            if (modalContentText) {
                modalContentText.innerText = `${data.join(', ')}`;
                document.getElementById('modal').style.display = 'block';
                isModalOpen = true;
            } else {
                console.error('Element with id modal-content-text not found.');
            }
        })
        .catch(error => console.error('Error fetching cell details:', error));
}

function closeModal() {
    document.getElementById('modal').style.display = 'none';
    isModalOpen = false;
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

    fetchConfigAndData()
        .then(([config, predatorData, herbivoreData]) => {
            // Обработка конфигурации
            if (config.interval) {
                updateInterval = config.interval;
                console.log(updateInterval);

                setInterval(function() {
                    if (!isModalOpen) {
                        location.reload();
                    }
                }, updateInterval);
                updateIsland();
                console.log(updateIsland);
            }

            // Обработка данных хищников
            predatorTypes = predatorData;
            console.log('Predator types:', predatorTypes); // Выводим типы хищников в консоль
            predatorTypes.forEach(type => {
                let option = document.createElement('option');
                option.value = type;
                option.textContent = type;
                predatorTypeSelect.appendChild(option);
            });

            // Обработка данных травоядных
            herbivoreTypes = herbivoreData;
            console.log('Herbivore types:', herbivoreTypes); // Выводим типы травоядных в консоль
            herbivoreTypes.forEach(type => {
                let option = document.createElement('option');
                option.value = type;
                option.textContent = type;
                herbivoreTypeSelect.appendChild(option);
            });
        })
        .catch(error => console.error('Error fetching initial data:', error));

    // Добавляем кнопку для добавления случайного животного
    const addRandomAnimalButton = document.createElement('button');
    addRandomAnimalButton.textContent = 'Add Random Animal';
    addRandomAnimalButton.addEventListener('click', addRandomAnimal);
    document.body.appendChild(addRandomAnimalButton);
    setInterval(location.reload, updateInterval)
});
