# 🏥 CureBridge – AI-Powered Telehealth Platform

CureBridge is an intelligent telehealth platform designed to improve doctor-patient communication, enhance diagnosis efficiency, and ensure secure, real-time medical consultations using AI-driven features.

---

## 🚀 Overview

CureBridge bridges the gap between patients and healthcare providers by offering:

* 📞 Real-time video/audio consultations
* 🧠 AI-based symptom extraction
* 🩺 Disease prediction support for doctors
* 📝 Live speech-to-text transcription
* 📊 Sentiment analysis for safety monitoring

The system is built to address common healthcare issues such as:

* Patients forgetting prescriptions
* Doctors missing key symptoms
* Lack of proper documentation in consultations

---

## 🧩 Key Features

### 👨‍⚕️ Doctor Portal

* Start consultation sessions
* View real-time transcription
* Extract symptoms using AI
* Select symptoms and trigger disease prediction
* Access patient history

### 👤 Patient Portal

* Book appointments
* Join video consultations
* View prescriptions and consultation history

### 🤖 AI Modules

* **Symptom Extraction**
  * Extracts symptoms from live conversation using NLP
* **Disease Prediction**
  * Suggests possible diseases based on selected symptoms
* **Sentiment Analysis**
  * Detects abnormal or abusive behavior during consultations

### 📡 Real-Time Communication

* Video calls powered by **Daily.co**
* Live transcription using **Deepgram WebSocket API**
* Speaker labeling (Doctor / Patient)

---

## 🏗️ Project Structure

```
CureBridgeBackend/
│
├── src/                         # Backend source code
├── models/                      # AI/ML modules
│   ├── DiseasePrediction_fyp/
│   ├── SymptomExtraction_fyp/
│   └── SentimentAnalysis_fyp/
│
├── pom.xml                      # Maven configuration (Java backend)
├── README.md
└── .gitignore
```

---

## ⚙️ Tech Stack

### 🔹 Backend

* Java (Spring Boot)
* REST APIs

### 🔹 Frontend

* React.js

### 🔹 AI / ML

* Python
* NLP (Symptom Extraction)
* Machine Learning (Disease Prediction)
* Sentiment Analysis

### 🔹 Real-Time Services

* Daily.co (Video Calls)
* Deepgram (Live Transcription via WebSocket)

### 🔹 Database

* MySQL

---

## 🔄 System Workflow

1. Patient books an appointment
2. Doctor and patient join a video call
3. Audio stream is sent to Deepgram
4. Live transcription is displayed on both sides
5. Doctor starts a **Symptom Session (SP)**
6. Backend extracts symptoms from transcript
7. Doctor selects symptoms and clicks **Predict (DP)**
8. Disease prediction is generated
9. Consultation is stored for future reference

---

### 2️⃣ Backend Setup (Spring Boot)

```bash
mvn clean install
mvn spring-boot:run
```

### 3️⃣ AI Models Setup

```bash
cd models/SymptomExtraction_fyp
pip install -r requirements.txt

cd ../DiseasePrediction_fyp
pip install -r requirements.txt
```

---

## 📊 Future Enhancements

* 🧾 Automated prescription generation
* 📱 Mobile application (iOS/Android)
* 🔐 Enhanced security & encryption
* 🧠 Improved ML model accuracy
* 🌍 Multi-language support

---

## 💡 Inspiration

CureBridge is designed to modernize healthcare communication by combining:

* Telemedicine
* Artificial Intelligence
* Real-time data processing

