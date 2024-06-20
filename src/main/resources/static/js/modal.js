export class Modal {
    constructor(modalSelector, modalContentSelector) {
        this.modal = document.querySelector(modalSelector);
        this.modalContentText = document.querySelector(modalContentSelector);
        this.isModalOpen = false;
    }

    async showCellDetails(x, y) {
        const response = await fetch(`/api/island/cell?x=${x}&y=${y}`);
        const data = await response.json();

        this.modalContentText.innerText = data.join(', ');
        this.modal.style.display = 'block';
        this.isModalOpen = true;
    }

    closeModal() {
        this.modal.style.display = 'none';
        this.isModalOpen = false;
    }
}
