CREATE DATABASE EventCheckIn;

USE Security;

CREATE TABLE Security(
    firstName VARCHAR(15),
    lastName VARCHAR(15),
    email VARCHAR(25),
    phoneNumber VARCHAR(15),
    age INT,
    createdAt DATE TIME,
    updatedAt DATE TIME,
    password VARCHAR(20)

);

INSERT INTO Security
VALUES("Faith", "Dike", "ftoluchi@gmail.com", "07080100701", 25, 2026-05-04 02:15),
      ("James", "Micheal", "jamesmich@gmail.com", "07045676342", 30, 2026-05004 1:00),
      ("April", "Andrew", "april01@gmail.com", "09053435366", 26, 2026-09-03 12:00),
      ("Angle", "Joe", "joeangle@gmail.com", "07187254353", 28, 2026-04-01 3:30);
