CREATE TABLE Administrator (
	AID SERIAL PRIMARY KEY UNIQUE,
	username VARCHAR(255),
	pwd VARCHAR(255)
);

CREATE TABLE Equipment (
	EquipmentID SERIAL PRIMARY KEY UNIQUE,
	EquipmentName VARCHAR(255) UNIQUE,
	needsMaintenance BOOLEAN
);

CREATE TABLE Equipment_Log(
	MaintenanceID SERIAL PRIMARY KEY UNIQUE,
	EquipmentID INTEGER,
	AID INTEGER,
	MaintainedOn TIMESTAMP,
	FOREIGN KEY (AID) REFERENCES Administrator(AID),
	FOREIGN KEY (EquipmentID) REFERENCES Equipment(EquipmentID)
);

CREATE TABLE personalTrainer (
	PTID SERIAL PRIMARY KEY UNIQUE,
	PTName VARCHAR(255),
	PTAge INTEGER
);

CREATE TABLE fitnessMember (
	MemberID SERIAL PRIMARY KEY UNIQUE,
	memberName VARCHAR(100),
	ActiveMember BOOLEAN,
	Achievements VARCHAR(255),
	age INTEGER
);

CREATE TABLE PTSessions (
	PTSessionID SERIAL PRIMARY KEY UNIQUE,
	MemberID INTEGER,
	PTID INTEGER,
	sessionTime TIMESTAMP,
	createdBy INTEGER,
	FOREIGN KEY (createdBy) REFERENCES personalTrainer(PTID),
	FOREIGN KEY (PTID) REFERENCES personalTrainer(PTID),
	FOREIGN KEY (MemberID) REFERENCES fitnessMember(MemberID)
);


CREATE TABLE Goal (
	GID SERIAL PRIMARY KEY,
	MemberID INTEGER,
	achievement VARCHAR(255),
	dateCreated DATE,
	achieved BOOLEAN,
	FOREIGN KEY (MemberID) REFERENCES fitnessMember(MemberID)
);

CREATE TABLE Room (
	RID SERIAL PRIMARY KEY UNIQUE,
	roomName VARCHAR(255),
	capacity INTEGER
);


CREATE TABLE fitnessClass (
	ClassID SERIAL PRIMARY KEY,
	RID INTEGER,
	className VARCHAR(255),
	createdBy INTEGER,
	FOREIGN KEY (createdBy) REFERENCES Administrator(AID),
	FOREIGN KEY (RID) REFERENCES Room(RID)

);

CREATE TABLE Join_Classes(
	joinID SERIAL PRIMARY KEY UNIQUE,
	MemberID INTEGER,
	classID INTEGER,
	FOREIGN KEY (classID) REFERENCES fitnessClass(ClassID),
	FOREIGN KEY (MemberID) REFERENCES fitnessMember(MemberID)
);


CREATE TABLE Transactions (
	TransactionID SERIAL PRIMARY KEY UNIQUE,
	MemberID INTEGER,
	Date DATE,
	Amount DECIMAL(10,2),
	ProcessedBy INTEGER,
	FOREIGN KEY (MemberID) REFERENCES fitnessMember(MemberID),
	FOREIGN KEY (ProcessedBy) REFERENCES Administrator(AID)
);

CREATE TABLE Workouts(
	WorkoutID SERIAL PRIMARY KEY UNIQUE,
	MemberID INTEGER,
	workoutName VARCHAR(255),
	splitDay VARCHAR(255),
	FOREIGN KEY (MemberID) REFERENCES fitnessMember(MemberID)
);


