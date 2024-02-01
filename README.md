
# TaxiToGo

Java Project for the Course Programmazione 3 e Laboratorio di Programmazione 3 from the Computer Science Graduation from University Parthenope Napoli


![Logo](https://github.com/Emanuele-Chiummo/Taxi-Project/blob/main/Front-End/my-app/src/assets/logo.png)

# TaxiToGo - Information 

TaxiToGo was born to meet the needs of those looking for a quick and efficient taxi service. The application provides a user-friendly platform to swiftly request and manage taxi rides. With TaxiToGo, users can easily request a taxi, track the status of their ride, and enjoy a reliable and convenient transportation service.


# Features

TaxiToGo will allow us to: 

## Admin Features
- Add New Cars:

Easily expand the taxi fleet by adding new vehicles, ensuring effective control over resource availability.
Update Fare Rates:

- Modyfy rates

Modify and update fare rates to provide flexibility in cost management based on market dynamics and business needs.
View Statistics:

- View Statistics

Access detailed statistics on completed routes through a comprehensive dashboard for informed decision-making.
Manage Routes:

- Add new Route & location

Admins can add new routes, modify existing ones, or deactivate routes to adapt to changing requirements.
User Management:

- Users Administration

Full control over user profiles, including adding new users, making modifications, or setting user profiles as inactive.


## Customer Features


- Taxi Booking:
Customers can conveniently book a taxi through two methods:
 - Web Interface: Fill out a request form and pay online.
 - Email Booking: Send an email to taxitogo2024@gmail.com and pay in cash upon completion of the ride.


## Driver Features

- Accept or Reject Calls:
  Drivers have the flexibility to accept or reject service calls, ensuring efficient call management.


# Use

To use TaxiToGo we should login with: 
- email
- password



## Privacy

TaxiToGo has visibility criteria for which each user will only and exclusively see their data.


## Test User

To gain access in the development phase we could use the users for test :

Admin: 
email: admin@example.com
password: admin

Tassista: 
email: tassista@example.com
password: tassista

Cliente: 
email: cliente@example.com
password: cliente

## Getting Started


Follow these steps to get TaxiToGo up and running:

- Clone the repository: git clone https://github.com/your-username/TaxiToGo.git
- Navigate to the project directory: 

```bash
cd TaxiToGo
```
Install dependencies Angular:

```bash
  npm install
```

Start Angular application

```bash
npm start
```

Install Spriboot dependencies

- Open folder 'BackEnd' in SpringToolSuite and import project. 
- Right-Click and Run As...
- Run Configuration and choice Maven build and run with this parameter

    - Goals : `install`
    - Profiles : `pom.xml`
    - check `Skip Tests`
    - click `run`

Install Database dependencies

- Open folder 'Database' and import dumps into MySql Workbeanch Server / Data Import /

- Load all data and select Taxi-Management

- Upload Data 


## Environment Variables

To run this project, you will need to add the following environment variables to your spring-app.

Into `scr/main/resources/application.properties` change this value

- `spring.datasource.username` username for DB Connection
- `spring.datasource.password` password for DB Connection


## Tech Stack

**Front-End:** HTML, CSS, Bootstrap, Angular, Typescript

**Back-End:** Springboot, MySql

**Utility-Sites:**
- [UML Diagram](https://www.planttext.com/)
- [Sequence Diagram](https://sequencediagram.org/)
- [Documentation](https://www.overleaf.com/)
- [Official Documentation Spring](https://spring.io/)
- [Official Documentation Angular](https://angular.io/)

## Roadmap

- Responsive layouts for all devices [Completed]
- Email Server for listener email and save prenotation on db [Completed]
- Integration with Gooogle OAuth [In Progress]


## License

[Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0)

## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://www.emanuelechiummo.it/)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/emanuele-chiummo-8327a4233/)
