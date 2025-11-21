# Green Intelligent Chemistry System / 绿色智能化学系统

一个专业的化学品管理平台，支持中英文双语切换，提供化学品管理、安全数据管理、实验管理和风险监控等功能。

## 功能特性 / Features

### 核心功能 / Core Features
- **化学品管理 / Chemical Management**: 完整的化学品目录管理，包括危险等级评估和库存跟踪
- **安全数据管理 / Safety Data Management**: 安全数据表(SDS)管理，提供安全操作指南和应急措施
- **实验管理 / Experiment Management**: 实验项目管理，支持实验流程跟踪和风险评估
- **风险监控 / Risk Monitor**: 实时风险监控，提供警报系统和安全通知

### 技术特点 / Technical Features
- 🌍 **多语言支持 / Multilingual Support**: 完整的中英文双语界面，一键切换
- 💾 **数据持久化 / Data Persistence**: 语言设置自动保存，刷新页面后保持用户偏好
- 📱 **响应式设计 / Responsive Design**: 基于Element Plus的现代UI，适配各种屏幕尺寸
- ⚡ **实时更新 / Real-time Updates**: 语言切换无需刷新页面，所有界面元素即时更新

## 技术栈 / Technology Stack

- **前端框架 / Frontend Framework**: Vue 3
- **UI组件库 / UI Library**: Element Plus
- **国际化 / Internationalization**: Vue I18n
- **样式 / Styling**: Material Design + 专业科技风格
- **HTTP请求 / HTTP Requests**: Axios

## 快速开始 / Quick Start

### 环境要求 / Prerequisites
- 现代浏览器 (Chrome, Firefox, Safari, Edge)
- 本地HTTP服务器 (用于开发环境)

### 安装和运行 / Installation and Running

1. **克隆或下载项目 / Clone or Download Project**
   ```bash
   # 如果使用Git
   git clone [项目地址]
   # 或者直接下载ZIP文件并解压
   ```

2. **启动本地服务器 / Start Local Server**
   ```bash
   # 进入项目目录
   cd "Lumap V1.1"
   
   # 使用Python启动HTTP服务器 (推荐)
   python -m http.server 8000
   
   # 或者使用Node.js
   npx http-server -p 8000
   ```

3. **访问应用 / Access Application**
   打开浏览器访问: `http://localhost:8000/GreenIntelligentChemistrySystem-Frontend.html`

## 使用指南 / User Guide

### 语言切换 / Language Switching
1. 点击右上角的语言切换下拉菜单
2. 选择"🇨🇳 中文"或"🇺🇸 English"
3. 界面将立即切换到所选语言
4. 语言设置会自动保存，下次访问时恢复

### 模块导航 / Module Navigation
- 使用左侧导航栏在不同模块间切换
- 当前活动模块会高亮显示
- 每个模块都有完整的功能界面

### 化学品管理 / Chemical Management
- 查看化学品目录，包括名称、CAS号和危险等级
- 点击"库存"按钮查看特定化学品的库存信息
- 使用"新增化学品"按钮添加新的化学品记录

### 安全数据管理 / Safety Data Management
- 使用搜索框快速查找化学品安全数据
- 查看详细的安全数据表，包括应急联系人和操作注意事项
- 下载相关安全文档

### 实验管理 / Experiment Management
- 查看所有实验项目及其状态
- 批准或拒绝待处理的实验申请
- 跟踪实验进度和结果

### 风险监控 / Risk Monitor
- 查看当前系统风险级别
- 监控实时警报和安全通知
- 查看风险历史记录和趋势

## 项目结构 / Project Structure

```
Lumap V1.1/
├── GreenIntelligentChemistrySystem-Frontend.html  # 主应用文件
├── ChemicalManagement-Core.java                  # 后端核心 - 化学品管理
├── SafetyDataManagement-Core.java                # 后端核心 - 安全数据管理
├── ExperimentManagement-Core.java                # 后端核心 - 实验管理
└── RiskMonitor-Core.java                          # 后端核心 - 风险监控
```

## 开发说明 / Development Notes

### 国际化实现 / Internationalization Implementation
- 使用Vue I18n插件实现多语言支持
- 所有文本内容都通过`$t()`函数进行翻译
- 支持动态数据的多语言显示
- 语言切换时保持页面状态不变

### 数据结构 / Data Structure
- 每个模块都有独立的数据模型
- 支持中英文混合内容存储
- 状态标签和风险等级有标准化的翻译映射

### 组件架构 / Component Architecture
- 模块化设计，每个功能模块独立封装
- 可复用的翻译函数和状态管理
- 统一的UI交互模式和错误处理

## 浏览器兼容性 / Browser Compatibility

| Browser | Version | Support |
|---------|---------|---------|
| Chrome | 90+ | ✅ Full Support |
| Firefox | 88+ | ✅ Full Support |
| Safari | 14+ | ✅ Full Support |
| Edge | 90+ | ✅ Full Support |

## 贡献指南 / Contributing

欢迎提交Issue和Pull Request来改进这个项目！

### 开发流程 / Development Process
1. Fork项目
2. 创建功能分支
3. 提交更改
4. 推送到分支
5. 创建Pull Request

### 代码规范 / Code Standards
- 使用ES6+语法
- 遵循Vue 3组合式API规范
- 所有新功能需要支持中英文双语
- 保持代码注释和文档更新

**注意 / Note**: 这是一个演示项目，后端接口为模拟数据。在生产环境中使用时，需要连接实际的数据库和API服务。

**Notice**: This is a demonstration project with simulated backend data. When using in a production environment, you need to connect to actual databases and API services.