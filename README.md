QA-DASHBOARD/
│
├── .editorconfig                      ← Editor formatting rules (optional)
├── .vscode/                           ← VS Code IDE settings
│
├── pom.xml                            ← Maven build & dependency config
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── janitriinnovations/
│   │               ├── pages/
│   │               │   ├── App.java               ← Optional core app logic
│   │               │   ├── DashboardPage.java     ← POM class for dashboard
│   │               │   └── LoginPage.java         ← POM class for login page
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── janitriinnovations/
│                   ├── bases/
│                   │   └── BaseTest.java          ← WebDriver init/cleanup
│                   │
│                   └── tests/
│                       ├── LoginTest.java         ← Login functionality tests
│                       └── NotificationTest.java  ← Notification feature tests
│
├── resources/                         ← Optional: configs, data files, logs
│
├── target/                            ← Maven output (compiled classes, reports)
│
└── testng.xml                         ← ✅ TestNG suite config (at the bottom now)
