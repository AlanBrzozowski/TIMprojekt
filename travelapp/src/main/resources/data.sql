INSERT INTO USER_ROLE_ENTITY (ID, LABEL) VALUES
  (1, 'Administrator'),
  (2, 'Użytkownik');

INSERT INTO USER_ENTITY (ID, USERNAME, PASSWORD, ACTIVE, USER_ROLE_ID) VALUES
  (1, 'admin', 'admin', true, 1),
  (2, 'krysjacz', 'haslomaslo', true, 2),
  (3, 'alanbrzo', 'podajehaslookon', true, 2);

INSERT INTO PLACE_ENTITY (NAME, ADDRESS, INFO, LATITUDE, LONGITUDE, ACCEPTED, ACTIVE, USER_ID) VALUES
  ('Kopiec Powstania Warszawskiego', 'Aleja Godziny W, 00-716 Warszawa', 'Kopiec upamiętniający ofiary Powstania Warszawskiego', 52.211155, 21.055765, true, true, 1),
  ('Pomnik Braterstwa Broni w Warszawie', 'Plac Wileński, 03-403 Warszawa', 'Pomnik poświęcony żołnierzom Armii Czerwonej', 52.255070, 21.034454, true, false, 1),
  ('Zamek Królewski w Warszawie', 'plac Zamkowy 4, 00-277 Warszawa', 'Zamek Królewski znajdujący się na Warszawskiej Starówce', 52.247743, 21.013990, true, true, 1),
  ('Kino Femina', 'Aleja Solidarności 115, 00-140 Warszawa', 'Otwarte w 1938 roku, najdłużej działające kino w Warszawie', 52.241936, 20.994431, true, false, 2),
  ('Zamek Królewski na Wawelu', 'Wawel 5, 31-001 Kraków', 'Zamek obronno-rezydencyjny w Krakowie, na Wawelu', 50.054091, 19.935487, true, true, 2),
  ('Kościół Mariacki w Krakowie','plac Mariacki 5, 31-042 Kraków', 'Jeden z największych i najważniejszych, po archikatedrze wawelskiej, kościołów Krakowa', 50.061675, 19.939154, true, true, 3),
  ('Fontanna Neptuna w Gdańsku', 'Długi Targ 44, 80-833 Gdańsk', 'Zabytkowa fontanna przedstawiająca postać Neptuna z trójzębem', 54.348534, 18.653241, true, true, 3);


