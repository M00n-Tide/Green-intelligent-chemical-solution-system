# Green Intelligent Chemistry System

A professional chemical management platform with bilingual (Chinese/English) support, providing chemical management, safety data management, experiment management, and risk monitoring functionalities.

## Features

### Core Features
- **Chemical Management**: Complete chemical catalog management including hazard level assessment and inventory tracking
- **Safety Data Management**: Safety Data Sheet (SDS) management with safety operation guidelines and emergency measures
- **Experiment Management**: Experiment project management supporting workflow tracking and risk assessment
- **Risk Monitor**: Real-time risk monitoring with alert system and safety notifications

### Technical Features
- 🌍 **Multilingual Support**: Complete Chinese/English bilingual interface with one-click switching
- 💾 **Data Persistence**: Language settings are automatically saved and restored after page refresh
- 📱 **Responsive Design**: Modern UI based on Element Plus, adaptable to various screen sizes
- ⚡ **Real-time Updates**: Language switching without page refresh, all interface elements update instantly

## Technology Stack

- **Frontend Framework**: Vue 3
- **UI Library**: Element Plus
- **Internationalization**: Vue I18n
- **Styling**: Material Design + Professional Technology Style
- **HTTP Requests**: Axios

## Quick Start

### Prerequisites
- Modern browsers (Chrome, Firefox, Safari, Edge)
- Local HTTP server (for development environment)

### Installation and Running

1. **Clone or Download Project**
   ```bash
   # Using Git
   git clone [repository-url]
   # Or download ZIP file and extract
   ```

2. **Start Local Server**
   ```bash
   # Navigate to project directory
   cd "Lumap V1.1"
   
   # Start HTTP server using Python (recommended)
   python -m http.server 8000
   
   # Or using Node.js
   npx http-server -p 8000
   ```

3. **Access Application**
   Open browser and visit: `http://localhost:8000/GreenIntelligentChemistrySystem-Frontend.html`

## User Guide

### Language Switching
1. Click the language switch dropdown menu in the top right corner
2. Select "🇨🇳 中文" or "🇺🇸 English"
3. Interface will immediately switch to the selected language
4. Language settings are automatically saved and restored on next visit

### Module Navigation
- Use the left navigation bar to switch between different modules
- Currently active module is highlighted
- Each module has a complete functional interface

### Chemical Management
- View chemical catalog including names, CAS numbers, and hazard levels
- Click "Inventory" button to view inventory information for specific chemicals
- Use "Add Chemical" button to add new chemical records

### Safety Data Management
- Use search box to quickly find chemical safety data
- View detailed safety data sheets including emergency contacts and handling precautions
- Download relevant safety documents

### Experiment Management
- View all experiment projects and their statuses
- Approve or reject pending experiment applications
- Track experiment progress and results

### Risk Monitor
- View current system risk level
- Monitor real-time alerts and safety notifications
- View risk history records and trends

## Project Structure

```
Lumap V1.1/
├── GreenIntelligentChemistrySystem-Frontend.html  # Main application file
├── ChemicalManagement-Core.java                  # Backend core - Chemical Management
├── SafetyDataManagement-Core.java                # Backend core - Safety Data Management
├── ExperimentManagement-Core.java                # Backend core - Experiment Management
└── RiskMonitor-Core.java                          # Backend core - Risk Monitor
```

## Development Notes

### Internationalization Implementation
- Multi-language support implemented using Vue I18n plugin
- All text content translated through `$t()` function
- Supports multilingual display of dynamic data
- Page state maintained during language switching

### Data Structure
- Each module has independent data models
- Supports storage of mixed Chinese/English content
- Standardized translation mapping for status labels and risk levels

### Component Architecture
- Modular design with independent encapsulation of functional modules
- Reusable translation functions and state management
- Unified UI interaction patterns and error handling

## Browser Compatibility

| Browser | Version | Support |
|---------|---------|---------|
| Chrome | 90+ | ✅ Full Support |
| Firefox | 88+ | ✅ Full Support |
| Safari | 14+ | ✅ Full Support |
| Edge | 90+ | ✅ Full Support |

## Contributing

Issues and Pull Requests are welcome to improve this project!

### Development Process
1. Fork the project
2. Create feature branch
3. Commit changes
4. Push to branch
5. Create Pull Request

### Code Standards
- Use ES6+ syntax
- Follow Vue 3 Composition API specifications
- All new features need to support Chinese/English bilingual
- Keep code comments and documentation updated

**Note**: This is a demonstration project with simulated backend data. When using in a production environment, you need to connect to actual databases and API services.