# Island Simulation Application 🌴🐾

This project is a comprehensive island simulation application developed using Spring Boot. It simulates an ecosystem where animals and plants interact based on predefined behaviors and environmental factors.

## Table of Contents

- [Technologies Used](#technologies-used) 🛠️
- [Services](#services) 🚀
- [Behavioral Strategies](#behavioral-strategies) 🐋
- [Scheduled Jobs](#scheduled-jobs) 🕒
- [Frontend Components](#frontend-components) 🖥️
- [YAML Configuration](#yaml-configuration) 📝
- [Animal Types](#animal-types) 🐻
- [Features](#features) ✨
- [Getting Started](#getting-started) 🚀
- [Contributing](#contributing) 🤝
- [License](#license) 📜

---

## Technologies Used 🛠️

- **Spring Boot**: Framework for creating standalone, production-grade Spring-based applications.
- **Factory Pattern**: Used to instantiate various types of animals and plants based on input parameters.
- **Lightweight (or Dependency Injection) Pattern**: Utilized throughout the application for managing component dependencies.
- **Strategy Pattern**: Implemented for defining behaviors (e.g., eating, moving) that can vary independently.
- **Microservice Architecture**: Structured as a set of loosely coupled services interacting through APIs.
- **YAML Configuration**: Configuration settings for simulation parameters (e.g., terrain type, climate) are defined in YAML files (`animalCharacteristics.yml`, `application.yml`).
- **Configuration Classes**: Java classes annotated with `@ConfigurationProperties` to bind YAML settings to POJOs.
- **DTOs (Data Transfer Objects)**: Used to transfer data between layers, ensuring clean separation of concerns.
- **Controllers**: RESTful endpoints defined using Spring MVC for handling HTTP requests and responses.
- **Animal and Plant Class Hierarchy**: Object-oriented design with inheritance and polymorphism to model different types of animals and plants.
- **Enums**: Used to represent types (e.g., HerbivoreType, PlantType) and categories in a type-safe manner.
- **Quartz Scheduler**: Integrated for scheduling tasks (e.g., simulation updates, feeding cycles).

---

## Services 🚀

- **AnimalBreedingService**: Manages animal reproduction cycles based on predefined rules and environmental conditions.
- **AnimalCharacteristicsService**: Provides methods to retrieve and manage characteristics (e.g., weight, age) of animals.
- **AnimalEatingService**: Handles feeding behaviors of animals, including interactions with plants and other animals.
- **AnimalManagementService**: Manages the lifecycle of animals, including creation, movement, and removal from the simulation environment.
- **AnimalMovementService**: Controls movement and navigation behaviors of animals across the island terrain.
- **AnimalSymbolService**: Generates graphical symbols (e.g., emojis) for displaying animals in the simulation UI.
- **IslandInformationService**: Provides general information about the island environment, such as size, terrain types, and climate conditions.
- **PlantEatingService**: Manages consumption of plants by herbivorous and omnivorous animals, ensuring ecosystem balance.
- **PlantManagementService**: Controls growth, propagation, and removal of plants within the simulation environment.
- **RandomManager**: Utility service for generating random numbers and selecting random elements from collections.

---

## Behavioral Strategies 🐋

- **DefaultMovingBehavior**: Defines default movement strategy for animals, guiding navigation across the island terrain.
- **DefaultReproducingBehavior**: Specifies default behavior for animal reproduction, including mate selection and offspring production.
- **OmnivoresEatingBehavior**: Governs eating habits of omnivorous animals, balancing between plant-based and animal-based diets.
- **PlantEatingBehavior**: Defines interaction and consumption of plants by herbivorous and omnivorous animals within the simulation.
- **PredatorEatingBehavior**: Manages predatory instincts of animals when hunting and consuming other animals.

---

## Scheduled Jobs 🕒

- **AnimalBreedingJob**: Scheduled task managing animal breeding and reproduction cycles based on predefined rules.
- **AnimalEatingJob**: Scheduled task handling feeding behaviors of animals to ensure they consume necessary food.
- **AnimalMovementJob**: Scheduled job controlling movement and navigation behaviors of animals across the island terrain.
- **PlantAppearJob**: Scheduled task managing appearance and propagation of plants within the simulation environment.
- **PlantEatingJob**: Scheduled task managing consumption of plants by herbivorous and omnivorous animals.
- **PopulateIslandJob**: Scheduled job initializing and populating the island environment with initial animals and plants.

---

## Frontend Components 🖥️

### `styles.css`
CSS stylesheet defining visual appearance and layout of the frontend interface.

### `js`

- **`animalService.js`**: JavaScript module providing functionalities related to animal management and interaction with the backend API.
- **`apiService.js`**: JavaScript module for making HTTP requests to the backend API, handling data retrieval and updates.
- **`island.js`**: JavaScript module responsible for rendering and managing the island simulation interface, including animal and plant representations.
- **`main.js`**: Main entry point JavaScript file orchestrating initialization and setup of the frontend application.
- **`modal.js`**: JavaScript module defining reusable modal components for displaying information and user interactions.

### `templates`

- **`index.html`**: HTML template file serving as main entry point for the frontend application, including references to CSS stylesheets and JavaScript files.

---

## YAML Configuration 📝

### `animalCharacteristics.yml`

File containing configurable characteristics of animals within the simulation. Allows adjusting attributes such as weight, age, health, and reproduction parameters.

### `application.yml`

Main configuration file for the Spring Boot application, used to set general application settings, database configurations, and other environment-specific parameters.

---

## Animal Types 🐻

- **Predators**: Bear, Boa, Eagle, Fox, Wolf
- **Omnivores**: Boar, Duck, Goat, Rabbit
- **Herbivores**: Buffalo, Caterpillar, Deer, Horse, Mouse, Sheep

---

## Features ✨

- Simulates an ecosystem with animals and plants interacting dynamically.
- Customizable simulation parameters via YAML configuration files.
- Scheduled tasks for automated management of simulation elements.
- Responsive frontend interface for visualizing and interacting with the simulation.

---

## Getting Started 🚀

To run the simulation locally:

1. Clone the repository.
2. Configure `application.yml` and `animalCharacteristics.yml` to adjust simulation parameters if needed.
3. Build the project using Maven: `gradlew clean install`.
4. Run the application: `java -jar src/main/java/ru/pr1nkos/islandsimulation/IslandSimulationApplication.java`.
5. Access the simulation UI at `http://localhost:8080/api/island`.

---

## Contributing 🤝

Contributions are welcome! Feel free to fork the repository and submit pull requests to suggest improvements or add new features.

---

## License 📜

This project is licensed under the [MIT License](LICENSE).
