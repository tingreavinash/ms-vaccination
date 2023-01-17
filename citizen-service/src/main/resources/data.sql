CREATE TABLE VACCINATION_CENTER (
 ID INT NOT NULL PRIMARY KEY,
 CENTER_NAME VARCHAR(32),
 CENTER_ADDRESS VARCHAR(32)
);

INSERT INTO VACCINATION_CENTER (ID, CENTER_ADDRESS, CENTER_NAME) VALUES (0, 'Bandra', 'Mumbai');
INSERT INTO VACCINATION_CENTER (ID, CENTER_ADDRESS, CENTER_NAME) VALUES (1, 'Vasai', 'Mumbai');
INSERT INTO VACCINATION_CENTER (ID, CENTER_ADDRESS, CENTER_NAME) VALUES (2, 'Kalyan', 'Mumbai');