-- Insert test data into Administrator table
INSERT INTO Administrator (username, pwd) VALUES 
('admin1', 'password1'),
('admin2', 'password2'),
('admin3', 'password3');

-- Insert test data into Equipment table
INSERT INTO Equipment (EquipmentName, needsMaintenance) VALUES
('Treadmill', FALSE),
('Dumbbells', FALSE),
('Elliptical', TRUE),
('Bench Press', TRUE);

-- Insert test data into Equipment_Log table
INSERT INTO Equipment_Log (EquipmentID, AID, MaintainedOn) VALUES
(1, 1, '2024-04-10 09:00:00'),
(2, 2, '2024-04-11 10:30:00'),
(3, 3, '2024-04-08 14:15:00'),
(4, 1, '2024-04-12 11:45:00');

-- Insert test data into personalTrainer table
INSERT INTO personalTrainer (PTName) VALUES
('John Smith'),
('Emily Johnson'),
('Michael Brown');

-- Insert test data into fitnessMember table
INSERT INTO fitnessMember (memberName, ActiveMember, Achievements) VALUES
('Alice', TRUE, 'Ran a marathon'),
('Bob', TRUE, 'Lost 10kg'),
('Charlie', FALSE, NULL);

-- Insert test data into PTSessions table
INSERT INTO PTSessions (MemberID, PTID, sessionTime, createdBy) VALUES
(1, 1, '2024-04-10 08:00:00', 1),
(2, 2, '2024-04-11 09:30:00', 2),
(3, 3, '2024-04-08 12:15:00', 3);

-- Insert test data into Goal table
INSERT INTO Goal (MemberID, achievement, dateCreated, achieved) VALUES
(1, 'Run 5 miles in under 30 minutes', '2024-04-10', TRUE),
(2, 'Lose 5kg in 2 months', '2024-04-11', FALSE),
(3, 'Complete 10 pull-ups', '2024-04-12', FALSE);

-- Insert test data into Room table
INSERT INTO Room (roomName, capacity) VALUES
('Studio A', 30),
('Studio B', 20),
('Weight Room', 50);

-- Insert test data into fitnessClass table
INSERT INTO fitnessClass (RID, className, createdBy) VALUES
(1, 'Yoga', 1),
(2, 'Spin', 2),
(3, 'Zumba', 1);

-- Insert test data into Join_Classes table
INSERT INTO Join_Classes (MemberID, classID) VALUES
(1, 1),
(2, 2),
(3, 3);

-- Insert test data into Transactions table
INSERT INTO Transactions (MemberID, Date, Amount, ProcessedBy) VALUES
(1, '2024-04-10', 50.00, 1),
(2, '2024-04-11', 60.00, 2),
(3, '2024-04-12', 70.00, 1);

-- Insert test data into Workouts table
INSERT INTO Workouts (MemberID, workoutName, splitDay) VALUES
(1, 'Cardio Blast', 'Monday'),
(2, 'Strength Training', 'Wednesday'),
(3, 'Rest Day', 'Sunday');

