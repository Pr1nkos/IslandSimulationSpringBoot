import { AnimalService } from './animalService.js';
import { Island } from './island.js';
import { Modal } from './modal.js';

document.addEventListener('DOMContentLoaded', async function () {
    const predatorTypeSelect = document.getElementById('predatorType');
    const herbivoreTypeSelect = document.getElementById('herbivoreType');
    const omnivoreTypeSelect = document.getElementById('omnivoreType');
    const addPredatorButton = document.getElementById('addPredatorButton');
    const addHerbivoreButton = document.getElementById('addHerbivoreButton');
    const addOmnivoreButton = document.getElementById('addOmnivoreButton');
    const addRandomAnimalButton = document.getElementById('addRandomAnimalButton');

    const animalService = new AnimalService();
    const island = new Island('.island');
    const modal = new Modal('#modal', '#modal-content-text');

    try {
        await animalService.fetchAllTypes();

        animalService.predatorTypes.forEach(type => {
            const option = document.createElement('option');
            option.value = type;
            option.textContent = type;
            predatorTypeSelect.appendChild(option);
        });

        animalService.herbivoreTypes.forEach(type => {
            const option = document.createElement('option');
            option.value = type;
            option.textContent = type;
            herbivoreTypeSelect.appendChild(option);
        });

        animalService.omnivoreTypes.forEach(type => {
            const option = document.createElement('option');
            option.value = type;
            option.textContent = type;
            omnivoreTypeSelect.appendChild(option);
        });

    } catch (error) {
        console.error('Error initializing application:', error);
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
            modal.showCellDetails(x, y);
        }
    });

    addPredatorButton.addEventListener('click', async () => {
        await animalService.addPredator(predatorTypeSelect.value);
        await island.update();
    });

    addHerbivoreButton.addEventListener('click', async () => {
        await animalService.addHerbivore(herbivoreTypeSelect.value);
        await island.update();
    });

    addOmnivoreButton.addEventListener('click', async () => {
        await animalService.addOmnivore(omnivoreTypeSelect.value);
        await island.update();
    });

    addRandomAnimalButton.addEventListener('click', async () => {
        await animalService.addRandomAnimal();
        await island.update();
    });

    const configResponse = await fetch('/api/config/refreshInterval');
    const refreshInterval = await configResponse.json();

    setInterval(async function () {
        if (!modal.isModalOpen) {
            location.reload();
        }
    }, refreshInterval);

    window.closeModal = () => {
        modal.closeModal();
    };
});


