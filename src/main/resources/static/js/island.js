import { ApiService } from './apiService.js';

export class Island {
    constructor(elementSelector) {
        this.islandElement = document.querySelector(elementSelector);
    }

    async update() {
        const data = await ApiService.fetchIsland();
        this.render(data);
    }

    render(data) {
        this.islandElement.innerHTML = '';
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
            this.islandElement.appendChild(rowElement);
        });
    }
}
