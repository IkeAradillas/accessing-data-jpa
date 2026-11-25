INSERT INTO customers (first_name, last_name, email)
VALUES ('linux', 'torvalds', 'ltorvalds@gmail.com'),('Noam', 'Chomsky', 'nchomsky@gmail.com'),('Ada', 'Lovelace', 'alovelace@gmail.com');

INSERT INTO incidents(titol, descripcio, data_obertura, estat, customer_id)
VALUES ('Disc dur ple', 'El servidor...', CURRENT_TIMESTAMP, 2, 1),
       ('Wifi lenta', 'La connexio...', '2025-12-01 09:00:00', 1, 2);

