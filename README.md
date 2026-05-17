
# 🚀 CI/CD Pipeline with Jenkins, Maven & Docker  
## Triangle Java Application

---

## 📌 Project Overview

This project demonstrates a complete **CI/CD pipeline implementation using Jenkins** for a simple Java Maven application.

The pipeline automatically:

- ✅ Retrieves source code from GitHub
- ✅ Builds the project using Maven
- ✅ Executes unit tests (JUnit 5)
- ✅ Builds a Docker image
- ✅ Pushes the image to Docker Hub
- ✅ Sends email notifications (success/failure)
- ✅ Triggers builds automatically via GitHub Webhook

This project illustrates DevOps best practices including **automation, integration, containerization, and continuous delivery**.

---

## 🏗️ Technology Stack

| Technology | Purpose |
|------------|----------|
| Java 8+ | Application Development |
| Maven 3.9 | Build & Dependency Management |
| JUnit 5 | Unit Testing |
| Docker | Containerization |
| Docker Hub | Image Registry |
| Jenkins | CI/CD Automation |
| Git & GitHub | Version Control |
| Ngrok | Public Webhook Exposure (Local Jenkins) |

---

## 📂 Project Structure

```
jenkins-dockerhub-pipeline/
│
├── src/
│   ├── main/java/com/example/
│   │   └── Triangle.java
│   │
│   └── test/java/com/example/
│       └── TriangleTest.java   # (JUnit 5 test class)
│
├── Dockerfile
├── pom.xml
├── Jenkinsfile
└── README.md
```

---

## 🔺 Application Description

The application determines the type of a triangle based on three side lengths.

### Supported Types:

- **Equilateral**
- **Isosceles**
- **Scalene**

### Example Usage

```java
Triangle.typeTriangle(3,3,3); // Equilateral
Triangle.typeTriangle(3,3,4); // Isosceles
Triangle.typeTriangle(3,4,5); // Scalene
```

---

## 🔄 CI/CD Pipeline Architecture

### Pipeline Stages

1. **Git Checkout**
   - Retrieves source code from GitHub repository.

2. **Build Application**
   - Executes:
     ```
     mvn clean package
     ```

3. **Unit Testing**
   - Executes:
     ```
     mvn test
     ```

4. **Docker Image Build**
   - Builds a Docker image tagged with Jenkins build number:
     ```
     bien18/triangle-app:${BUILD_NUMBER}
     ```

5. **Docker Hub Push**
   - Authenticates securely using Jenkins credentials.
   - Pushes the image to Docker Hub.

6. **Post Actions**
   - Sends email notification upon:
     - ✅ Success
     - ❌ Failure

---

## 🐳 Docker Image Versioning Strategy

Each build generates a uniquely versioned image:

```
bien18/triangle-app:<BUILD_NUMBER>
```

Example:

```
bien18/triangle-app:25
```

This ensures:

- Traceability
- Version control
- Rollback capability

---

## ⚙️ Jenkins Configuration

### Required Plugins

- ✅ Pipeline Plugin
- ✅ Git Plugin
- ✅ Maven Integration Plugin
- ✅ Credentials Binding Plugin
- ✅ Email Extension Plugin

---

### 🔐 Credentials Configuration

#### 1️⃣ GitHub Credentials
- Type: Username with password
- ID: `git_credentials`

#### 2️⃣ Docker Hub Credentials
- Type: Username with password or token
- ID: `dockerhubpass`

---

### 🛠 Global Tool Configuration

Navigate to:

```
Manage Jenkins → Global Tool Configuration
```

Configure:

- JDK → Name: `jdk-8` (or `jdk-11`, depending on your Java version)
- Maven → Name: `Maven-3.9`

These names must match those used in the Jenkins pipeline.

---

## 🌍 GitHub Webhook Integration

To enable automatic builds on each push:

### Step 1 – Enable in Jenkins

In Pipeline configuration:

```
Build Triggers → GitHub hook trigger for GITScm polling
```

---

### Step 2 – Expose Local Jenkins (if applicable)

If Jenkins runs locally:

```bash
ngrok http 8080
```

Copy the generated public URL.

---

### Step 3 – Configure Webhook in GitHub

Repository → Settings → Webhooks → Add Webhook

Payload URL:

```
http://<ngrok-url>/github-webhook/
```

Content Type:

```
application/json
```

---

## 📧 Email Notifications

Configured under:

```
Manage Jenkins → Configure System → Extended Email Notification
```

Example SMTP (Gmail):

- SMTP Server: `smtp.gmail.com`
- Port: `465`
- SSL: Enabled

Notifications are sent automatically for:

- Successful builds
- Failed builds

---

## ▶️ Running the Project Locally

### 1️⃣ Clone Repository

```bash
git clone https://github.com/FANOMEZANTSOA-Bien-Aime-Louison/jenkins-dockerhub-pipeline.git
cd jenkins-dockerhub-pipeline
```

### 2️⃣ Build with Maven

```bash
mvn clean package
```

### 3️⃣ Run Tests

```bash
mvn test
```

### 4️⃣ Build Docker Image

```bash
docker build -t bien18/triangle-app .
```

### 5️⃣ Run Container

```bash
docker run bien18/triangle-app
```

---

## 📊 CI/CD Workflow Diagram

```
Developer
   │
   ▼
GitHub (Push)
   │
   ▼
Jenkins Pipeline
   ├── Build (Maven)
   ├── Test (JUnit)
   ├── Docker Build
   ├── Docker Push
   └── Email Notification
   │
   ▼
Docker Hub
```

---

## 🎯 Learning Objectives

This project demonstrates:

- Continuous Integration (CI)
- Continuous Delivery (CD)
- Pipeline as Code (Jenkinsfile)
- Automated testing integration
- Docker containerization
- Secure credential handling
- Webhook-triggered automation
- Email-based monitoring

---

## 👨‍💻 Author

**Louison FANOMEZANTSOA**  
Master’s Degree – Cloud/DevOps Engineer 

---

## 📌 Conclusion

This project showcases a fully automated CI/CD pipeline integrating modern DevOps practices.  
It ensures code quality, build automation, containerization, and deployment readiness through a structured Jenkins pipeline workflow.

---