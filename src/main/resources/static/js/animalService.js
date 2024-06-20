import { ApiService } from './apiService.js';

export class AnimalService {
    constructor() {
        this.predatorTypes = [];
        this.herbivoreTypes = [];
        this.omnivoreTypes = [];
    }

    async fetchAllTypes() {
        const [predatorData, herbivoreData, omnivoreData] = await Promise.all([
            ApiService.fetchPredatorTypes(),
            ApiService.fetchHerbivoreTypes(),
            ApiService.fetchOmnivoreTypes()
        ]);

        this.predatorTypes = predatorData;
        this.herbivoreTypes = herbivoreData;
        this.omnivoreTypes = omnivoreData;
    }

    async addPredator(type) {
        await ApiService.addAnimal('predator', type);
    }

    async addHerbivore(type) {
        await ApiService.addAnimal('herbivore', type);
    }

    async addOmnivore(type) {
        await ApiService.addAnimal('omnivore', type);
    }

    async addRandomAnimal() {
        const random = Math.random();
        if (random < 0.33) {
            const type = this.getRandomType(this.predatorTypes);
            await this.addPredator(type);
        } else if (random < 0.66) {
            const type = this.getRandomType(this.herbivoreTypes);
            await this.addHerbivore(type);
        } else {
            const type = this.getRandomType(this.omnivoreTypes);
            await this.addOmnivore(type);
        }
    }

    getRandomType(types) {
        return types[Math.floor(Math.random() * types.length)];
    }
}
