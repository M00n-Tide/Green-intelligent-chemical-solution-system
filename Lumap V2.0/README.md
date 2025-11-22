# Green Intelligent Chemistry System

A professional chemical management platform supporting Chinese-English bilingual switching, providing chemical management, safety data management, experiment management, risk monitoring, cost calculation, and data analysis functions.

## Features

### Core Features
- **Chemical Management**: Complete chemical catalog management, including hazard level assessment and inventory tracking
- **Safety Data Management**: Safety Data Sheet (SDS) management, providing safety operation guidelines and emergency measures
- **Experiment Management**: Experiment project management, supporting experiment process tracking and risk assessment
- **Experiment Cost Management**: Automatic cost calculation based on experiment resources, with categorization and analysis
- **Experiment Data Analysis**: Comprehensive data visualization and statistical analysis of experimental parameters
- **Risk Monitor**: Real-time risk monitoring, providing alarm system and safety notifications

### Technical Features
- 🌍 **Multilingual Support**: Complete Chinese-English bilingual interface, one-click switching
- 💾 **Data Persistence**: Language settings are automatically saved, maintaining user preferences after page refresh
- 📱 **Responsive Design**: Modern UI based on Element Plus, adaptable to various screen sizes
- ⚡ **Real-time Updates**: Language switching without page refresh, all interface elements update instantly

## Technology Stack

- **Frontend Framework**: Vue 3
- **UI Library**: Element Plus
- **Internationalization**: Vue I18n
- **Styling**: Material Design + Professional Tech Style
- **HTTP Requests**: Axios
- **Backend Framework**: Spring Boot
- **Database**: H2 Embedded Database (Default), supports MySQL, PostgreSQL

## Quick Start

### Prerequisites
- Modern browser (Chrome, Firefox, Safari, Edge)
- Local HTTP server (for development environment)
- Java 11 or higher
- Apache Maven 3.6 or higher

### Installation and Running

1. **Clone or Download Project**
   ```bash
   # If using Git
   git clone [project address]
   # Or download ZIP file directly and unzip
   ```

2. **Start Application**
   
   **For Windows Users:**
   ```bash
   # Double-click and run the start.bat script
   start.bat
   ```
   
   **For Linux/Mac Users:**
   ```bash
   # Make executable and run
   chmod +x start.sh && ./start.sh
   ```

3. **Access Application**
   Open browser and visit: http://localhost:8080/GreenIntelligentChemistrySystem-Frontend.html

## Database Options

### 1. Default: H2 Embedded Database
- No database installation required
- Data stored in project directory
- Web console access at http://localhost:8080/h2-console
- Suitable for personal users, small teams, or demonstration environments

### 2. Professional Databases
For users with special requirements, the system supports switching to MySQL, PostgreSQL, or SQLite databases.

#### Database Configuration Details

The system supports multiple database configurations to meet different user needs:

**Default Configuration (H2 Embedded Database)**

```properties
# Current configuration (src/main/resources/application.properties)
spring.datasource.url=jdbc:h2:file:./data/lumap_db;DB_CLOSE_ON_EXIT=FALSE;AUTO_RECONNECT=TRUE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
```

**MySQL Configuration**

Suitable for scenarios requiring multi-user access, high concurrency, and large data volumes:

1. Modify pom.xml, add MySQL driver:
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```

2. Modify application.properties:
```properties
# MySQL configuration
spring.datasource.url=jdbc:mysql://localhost:3306/lumap_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

**PostgreSQL Configuration**

Suitable for scenarios requiring advanced features and complex queries:

1. Add PostgreSQL dependency to pom.xml:
```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```

2. Modify application.properties:
```properties
# PostgreSQL configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/lumap_db
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

#### Database Switching Methods

**Method 1: Use Database Switching Tool**

1. Run `switch-database.bat` (Windows) script
2. Follow prompts to select target database type
3. Modify database connection information as prompted
4. Restart application

**Method 2: Manual Configuration**

1. Backup current configuration file:
   ```
   cp src/main/resources/application.properties src/main/resources/application.properties.bak
   ```

2. Copy target database configuration template:
   ```
   # MySQL
   cp src/main/resources/application-mysql.properties src/main/resources/application.properties
   
   # PostgreSQL
   cp src/main/resources/application-postgresql.properties src/main/resources/application.properties
   ```

3. Modify database connection parameters (username, password, etc.)
4. Add corresponding database driver dependency to pom.xml
5. Create target database and user
6. Restart application

#### Data Migration

**Export from H2**
1. Start the application and visit: http://localhost:8080/h2-console
2. Execute SQL export using H2 console:
   ```sql
   SCRIPT TO 'data/export.sql';
   ```

**Import to New Database**
1. Adjust exported SQL syntax according to target database
2. Execute modified SQL in new database

#### Performance Comparison

| Feature | H2 Embedded Database | MySQL | PostgreSQL |
|---------|----------------------|-------|------------|
| Installation Complexity | No installation required | Medium | Medium |
| Configuration Difficulty | No configuration required | Medium | Medium |
| Concurrency Performance | Low | High | High |
| Data Volume | Small-Medium | Medium-Large | Medium-Large |
| Suitable Scenarios | Personal/Small Teams | Medium-Large Applications | Medium-Large Applications |
| Management Tools | Web Console | Rich | Rich |
| Data Backup | File Copy | Professional Tools | Professional Tools |

## Project Structure

```
Lumap V2.0/
├── src/
│   └── main/
│       ├── java/com/lumap/     # Java source code
│       │   ├── entity/         # Entity classes
│       │   ├── repository/     # Data access interfaces
│       │   ├── service/        # Service layer
│       │   └── controller/     # Controllers
│       └── resources/
│           ├── application.properties  # Configuration file
│           ├── data.sql         # Initialization data script
│           └── static/          # Static resources
├── pom.xml                     # Maven configuration file
├── start.bat                   # Windows startup script
├── start.sh                    # Linux/Mac startup script
├── switch-database.bat         # Database switching tool
└── GreenIntelligentChemistrySystem-Frontend.html  # Frontend page
```

## User Guide

### Language Switching
1. Click the language switch dropdown menu in the top right corner
2. Select "🇨🇳 中文" or "🇺🇸 English"
3. The interface will immediately switch to the selected language
4. Language settings are automatically saved and restored on next visit

### Module Navigation
- Use the left navigation bar to switch between different modules
- Currently active module will be highlighted
- Each module has complete functional interface

### Experiment Cost Management
- View detailed cost breakdowns by category (reagents, equipment, labor, consumables)
- Add new cost items with automatic calculation
- Export cost data to CSV for further analysis
- View cost summary cards showing total and category costs

### Experiment Data Analysis
- View comprehensive statistics for experiment parameters
- Analyze trends with interactive charts
- Compare different parameters using visual representations
- Add new data points and export analysis results

## New Features: Cost Management and Data Analysis

### 1. Experiment Cost Management

#### Functionality
- Automatic cost calculation based on experiment resources
- Cost categorization (reagents, equipment, labor, consumables)
- Cost summary with category breakdown
- Export cost data to CSV format

#### API Endpoints
- `GET /api/experiments/costs/experiment/{experimentRecordId}` - Get cost items for an experiment
- `GET /api/experiments/costs/total/{experimentRecordId}` - Get total cost for an experiment
- `GET /api/experiments/costs/category/{experimentRecordId}` - Get cost breakdown by category
- `POST /api/experiments/costs` - Add a cost item
- `PUT /api/experiments/costs/{id}` - Update a cost item
- `DELETE /api/experiments/costs/{id}` - Delete a cost item
- `POST /api/experiments/costs/estimate/{experimentDesignId}` - Estimate experiment cost

#### Data Model
```
ExperimentCost {
  id: Long
  experimentRecordId: Long
  costCategory: String  // Reagents, Equipment, Labor, Consumables
  itemName: String
  unitPrice: BigDecimal
  quantity: BigDecimal
  totalCost: BigDecimal
  currency: String
  createdTime: LocalDateTime
}
```

### 2. Experiment Data Analysis

#### Functionality
- Parameter tracking with measurement values and expected values
- Automatic deviation calculation
- Statistical analysis (average, max, min)
- Data visualization with charts and graphs
- Trend analysis for parameters over time
- Data export capabilities

#### API Endpoints
- `GET /api/experiments/data/experiment/{experimentRecordId}` - Get all data for an experiment
- `GET /api/experiments/data/experiment/{experimentRecordId}/parameter/{parameterName}` - Get data for a specific parameter
- `GET /api/experiments/data/statistics/{experimentRecordId}/parameter/{parameterName}` - Get parameter statistics
- `GET /api/experiments/data/analysis/{experimentRecordId}` - Get complete data analysis
- `POST /api/experiments/data` - Add experimental data
- `POST /api/experiments/data/batch` - Add multiple data points
- `PUT /api/experiments/data/{id}` - Update experimental data
- `DELETE /api/experiments/data/{id}` - Delete experimental data

#### Data Model
```
ExperimentData {
  id: Long
  experimentRecordId: Long
  parameterName: String
  parameterUnit: String
  measurementValue: BigDecimal
  expectedValue: BigDecimal
  deviation: BigDecimal
  measurementTime: LocalDateTime
  notes: String
  dataType: String
}
```

### Frontend Implementation

#### 1. New Menu Items

Two new menu items have been added:
- Experiment Cost (menu.experimentCost)
- Data Analysis (menu.dataAnalysis)

#### 2. Experiment Cost Management Interface

**Features**
- Experiment selection dropdown
- Cost item table with categories
- Cost summary cards showing total cost and category breakdowns
- Add/Edit/Delete cost items
- Export to CSV functionality
- Cost estimation based on experiment design

**Key Components**
- Cost summary cards with visual breakdown
- Editable cost table
- Add cost dialog with form validation
- Automatic total calculation

#### 3. Data Analysis Interface

**Features**
- Experiment selection dropdown
- Tabbed interface for different views:
  - Parameter Statistics Table
  - Trend Analysis Charts
  - Data Comparison Charts
- Parameter-specific data points
- Statistical analysis (mean, variance, etc.)
- Interactive charts using ECharts library
- Data export capabilities

**Key Components**
- Parameter statistics table
- Line charts for trend analysis
- Bar charts for comparison
- Pie charts for distribution
- Add data dialog

## Advanced Configuration

### Backend Setup

1. Update your database with new entities:
   ```sql
   -- Database tables are automatically created by Hibernate
   -- You can use the provided data.sql for sample data
   ```

2. Ensure your application.properties includes the correct data initialization:
   ```properties
   spring.sql.init.data-locations=classpath:data.sql
   ```

3. Restart application to load new entities and data

### Technical Dependencies

- Backend: Spring Boot, JPA, H2 Database
- Frontend: Vue 3, Element Plus, ECharts for visualization
- Data Format: BigDecimal for precise financial calculations

### Security Considerations

- Cost data is sensitive and should have appropriate access controls
- Experiment data may contain proprietary information requiring protection

## Browser Compatibility

| Browser | Version | Support |
|---------|---------|---------|
| Chrome | 90+ | ✅ Full Support |
| Firefox | 88+ | ✅ Full Support |
| Safari | 14+ | ✅ Full Support |
| Edge | 90+ | ✅ Full Support |

## Contributing

Welcome to submit Issues and Pull Requests to improve this project!

### Development Process
1. Fork the project
2. Create a feature branch
3. Submit changes
4. Push to the branch
5. Create a Pull Request

### Code Standards
- Use ES6+ syntax
- Follow Vue 3 Composition API specifications
- All new features need to support Chinese-English bilingual
- Keep code comments and documentation updated

## Frequently Asked Questions

### Q: Can I use multiple databases simultaneously in the same environment?
A: No. The application can only connect to one database at a time, but you can use different databases at different times by modifying the configuration file.

### Q: Will original data be lost after switching databases?
A: No. Each database's data is stored independently. Switching databases only changes the connection target and does not delete data from other databases.

### Q: How to synchronize data between different databases?
A: Data synchronization needs to be done through SQL export/import, or develop specialized synchronization tools.

### Q: Is H2 database suitable for production environments?
A: H2 is mainly used for development and demonstration, but can also be used for small-scale production environments. It is not suitable for high-concurrency, large-data-volume scenarios.

## Technical Support

If you encounter any issues, please check the project logs or submit an Issue.