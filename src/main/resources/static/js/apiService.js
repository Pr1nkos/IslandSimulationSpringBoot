export class ApiService {
    static fetchPredatorTypes() {
        return fetch('/api/enums/predatorTypes').then(response => response.json());
    }

    static fetchHerbivoreTypes() {
        return fetch('/api/enums/herbivoreTypes').then(response => response.json());
    }

    static fetchOmnivoreTypes() {
        return fetch('/api/enums/omnivoreTypes').then(response => response.json());
    }

    static fetchIsland() {
        return fetch(`/api/island`).then(response => response.json());
    }


    static addAnimal(animalType, type) {
        return fetch(`/api/animals/${animalType}?${animalType}Type=${type}`, { method: 'POST' });
    }
}
