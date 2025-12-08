/*
spring demo
class exercise
jasmine tu
*/

DROP DATABASE IF EXISTS springdemo;
CREATE DATABASE springdemo;
USE springdemo;

DROP TABLE IF EXISTS artists;

CREATE TABLE artists (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    album_title VARCHAR(200) NOT NULL,
    song_title VARCHAR(200) NOT NULL
);

INSERT INTO artists (name, album_title, song_title) 
VALUES
	('C.A.S', "X's", 'Hideaway'),
    ('Mitski', 'The Land is Inhospitable and So Are We', "I'm Your Man"),
    ('The Marias', 'CINEMA', 'Heavy'),
    ('Not for Radio', 'Melt', 'Back to You'),
    ('Laufey', 'Goddess', 'Goddess'),
    ('Adrianne Lenker', 'songs', 'forwards beckon rebound'),
    ('Alice Phoebe Lou', 'Shelter', 'Open My Door'),
    ('Lana Del Rey', 'Norman F*cking Rockwell!', 'Love song');
