CREATE DATABASE wildlife_tracker;
CREATE DATABASE  wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
\c wildlife_tracker;
CREATE TABLE animals (id SERIAL PRIMARY KEY, name VARCHAR, health VARCHAR, age VARCHAR, endangered BOOLEAN);
CREATE TABLE sightings (sightId SERIAL PRIMARY KEY, animal_Id int, location VARCHAR, ranger VARCHAR);
CREATE TABLE rangers (badge_no SERIAL PRIMARY KEY, name VARCHAR, phone VARCHAR);
