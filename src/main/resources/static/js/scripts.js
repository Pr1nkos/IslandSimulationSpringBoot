let predatorTypeSelect;
let herbivoreTypeSelect;
let omnivoreTypeSelect;
let predatorTypes = [];
let herbivoreTypes = [];
let omnivoreTypes = [];
let isModalOpen = false;
let updateInterval = 5000; // значение по умолчанию

function fetchConfigAndData() {
    return Promise.all([
        fetch('/api/enums/predatorTypes').then(response => response.json()),
        fetch('/api/enums/herbivoreTypes').then(response => response.json()),
        fetch('/api/enums/omnivoreTypes').then(response => response.json())
    ]);
}

function updateIsland() {
    fetch(`/api/island`)
        .then(response => response.json())
        .then(data => {
            const islandElement = document.querySelector('.island');
            islandElement.innerHTML = ''; // очищаем содержимое острова перед обновлением

            data.forEach((row, rowIndex) => {
                const rowElement = document.createElement('div');
                rowElement.classList.add('row');

                row.forEach((cell, colIndex) => {
                    const cellElement = document.createElement('div');
                    cellElement.classList.add('cell');
                    cellElement.textContent = cell || '';
                    cellElement.dataset.row = rowIndex;
                    cellElement.dataset.col = colIndex;
                    rowElement.appendChild(cellElement);
                });

                islandElement.appendChild(rowElement);
            });
        })
        .catch(error => console.error('Error fetching island data:', error));
}

function addPredator() {
    const predatorType = predatorTypeSelect.value;
    console.log('Adding predator:', predatorType);
    fetch(`/api/animals/predator?predatorType=${predatorType}`, { method: 'POST' })
        .then(response => {
            if (!response.ok) {
                console.error('Failed to add predator');
            }
        })
        .catch(error => console.error('Error adding predator:', error));
}

function addHerbivore() {
    const herbivoreType = herbivoreTypeSelect.value;
    console.log('Adding herbivore:', herbivoreType);
    fetch(`/api/animals/herbivore?herbivoreType=${herbivoreType}`, { method: 'POST' })
        .then(response => {
            if (!response.ok) {
                console.error('Failed to add herbivore');
            }
        })
        .catch(error => console.error('Error adding herbivore:', error));
}

function addOmnivore() {
    const omnivoreType = omnivoreTypeSelect.value;
    console.log('Adding Omnivore:', omnivoreType);
    fetch(`/api/animals/omnivore?omnivoreType=${omnivoreType}`, { method: 'POST' })
        .then(response => {
            if (!response.ok) {
                console.error('Failed to add omnivore');
            }
        })
        .catch(error => console.error('Error adding omnivore:', error));
}

async function addRandomAnimal() {
    for (let i = 0; i < 5; i++) {
        const random = Math.random();

        if (random < 0.33) {
            const randomPredator = predatorTypes[Math.floor(Math.random() * predatorTypes.length)];
            console.log('Adding predator:', randomPredator);
            await fetch(`/api/animals/predator?predatorType=${randomPredator}`, { method: 'POST' })
                .then(response => {
                    if (!response.ok) {
                        console.error('Failed to add predator');
                    }
                })
                .catch(error => console.error('Error adding predator:', error));
        } else if (random >= 0.33 && random < 0.66) {
            const randomHerbivore = herbivoreTypes[Math.floor(Math.random() * herbivoreTypes.length)];
            console.log('Adding herbivore:', randomHerbivore);
            await fetch(`/api/animals/herbivore?herbivoreType=${randomHerbivore}`, { method: 'POST' })
                .then(response => {
                    if (!response.ok) {
                        console.error('Failed to add herbivore');
                    }
                })
                .catch(error => console.error('Error adding herbivore:', error));
        } else {
            const randomOmnivore = omnivoreTypes[Math.floor(Math.random() * omnivoreTypes.length)];
            console.log('Adding Omnivore:', randomOmnivore);
            await fetch(`/api/animals/omnivore?omnivoreType=${randomOmnivore}`, { method: 'POST' })
                .then(response => {
                    if (!response.ok) {
                        console.error('Failed to add omnivore');
                    }
                })
                .catch(error => console.error('Error adding omnivore:', error));
        }

        await new Promise(resolve => setTimeout(resolve, 500)); // добавляем задержку
    }

    updateIsland();
}

function showCellDetails(x, y) {
    fetch(`/api/island/cell?x=${x}&y=${y}`)
        .then(response => response.json())
        .then(data => {
            const modalContentText = document.getElementById('modal-content-text');
            if (modalContentText) {
                modalContentText.innerText = data.join(', ');
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

document.addEventListener('DOMContentLoaded', async function () {
    predatorTypeSelect = document.getElementById('predatorType');
    herbivoreTypeSelect = document.getElementById('herbivoreType');
    omnivoreTypeSelect = document.getElementById('omnivoreType');

    try {
        const [predatorData, herbivoreData, omnivoreData] = await fetchConfigAndData();

        predatorTypes = predatorData;
        console.log('Predator types:', predatorTypes);
        predatorTypes.forEach(type => {
            const option = document.createElement('option');
            option.value = type;
            option.textContent = type;
            predatorTypeSelect.appendChild(option);
        });

        herbivoreTypes = herbivoreData;
        console.log('Herbivore types:', herbivoreTypes);
        herbivoreTypes.forEach(type => {
            const option = document.createElement('option');
            option.value = type;
            option.textContent = type;
            herbivoreTypeSelect.appendChild(option);
        });

        omnivoreTypes = omnivoreData;
        console.log('Omnivore types:', omnivoreTypes);
        omnivoreTypes.forEach(type => {
            const option = document.createElement('option');
            option.value = type;
            option.textContent = type;
            omnivoreTypeSelect.appendChild(option);
        });
    } catch (error) {
        console.error('Error fetching initial data:', error);
    }

    predatorTypeSelect.addEventListener('change', function () {
        localStorage.setItem('selectedPredatorType', this.value);
    });

    herbivoreTypeSelect.addEventListener('change', function () {
        localStorage.setItem('selectedHerbivoreType', this.value);
    });

    omnivoreTypeSelect.addEventListener('change', function () {
        localStorage.setItem('selectedOmnivoreType', this.value);
    });

    document.addEventListener('click', function (event) {
        if (event.target.classList.contains('cell')) {
            const x = event.target.dataset.row;
            const y = event.target.dataset.col;
            showCellDetails(x, y);
        }
    });

    const addRandomAnimalButton = document.createElement('button');
    addRandomAnimalButton.textContent = 'Add Random Animal';
    addRandomAnimalButton.addEventListener('click', addRandomAnimal);
    document.body.appendChild(addRandomAnimalButton);

    setInterval(function () {
        if (!isModalOpen) {
            location.reload(); // перезагружаем страницу через определенный интервал времени
        }
    }, updateInterval);
});
