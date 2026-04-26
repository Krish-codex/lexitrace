-- ===================================================================
-- LexiTrace Seed Data
-- Users are created by DataInitializer with proper BCrypt hashing
-- ===================================================================

-- ===================================================================
-- Languages
-- ===================================================================
INSERT INTO languages (name, code, flag_emoji, is_active) VALUES
('French', 'fr', '🇫🇷', TRUE),
('Spanish', 'es', '🇪🇸', TRUE),
('Japanese', 'ja', '🇯🇵', TRUE);

-- ===================================================================
-- French Lessons
-- ===================================================================
INSERT INTO lessons (language_id, title, description, content, difficulty, order_index) VALUES
(1, 'Greetings', 'Learn basic French greetings and introductions', '<h2>French Greetings</h2><p>Welcome! In French, "Bonjour" is used for Hello during the day. "Au revoir" means Goodbye. To introduce yourself, you can say "Je m''appelle..." (My name is...).</p>', 'Beginner', 1),
(1, 'Numbers', 'Master French numbers from 1 to 100', '<h2>French Numbers 1-10</h2><p>1: un<br>2: deux<br>3: trois<br>4: quatre<br>5: cinq<br>6: six<br>7: sept<br>8: huit<br>9: neuf<br>10: dix</p>', 'Beginner', 2),
(1, 'Colors', 'Learn the colors in French', '<h2>French Colors</h2><p>Red: rouge<br>Blue: bleu<br>Green: vert<br>Yellow: jaune<br>Black: noir<br>White: blanc</p>', 'Beginner', 3),
(1, 'Food & Dining', 'Essential food vocabulary and dining phrases', '<h2>Food & Dining</h2><p>Water: l''eau<br>Bread: le pain<br>Cheese: le fromage<br>To eat: manger</p>', 'Intermediate', 4),
(1, 'Travel', 'Useful phrases for traveling in France', '<h2>Travel Basics</h2><p>Where is the train station?: Où est la gare?<br>Ticket: le billet<br>Hotel: l''hôtel</p>', 'Intermediate', 5);

-- ===================================================================
-- Spanish Lessons
-- ===================================================================
INSERT INTO lessons (language_id, title, description, content, difficulty, order_index) VALUES
(2, 'Greetings', 'Learn basic Spanish greetings and farewells', '<h2>Spanish Greetings</h2><p>Hola means Hello. Adiós means Goodbye. Good morning is Buenos días.</p>', 'Beginner', 1),
(2, 'Family', 'Talk about your family in Spanish', '<h2>Family Vocabulary</h2><p>Mother: madre<br>Father: padre<br>Brother: hermano<br>Sister: hermana</p>', 'Beginner', 2),
(2, 'Animals', 'Learn animal names in Spanish', '<h2>Animals</h2><p>Dog: perro<br>Cat: gato<br>Bird: pájaro</p>', 'Beginner', 3),
(2, 'Weather', 'Discuss weather and seasons in Spanish', '<h2>Weather</h2><p>It is sunny: Hace sol<br>It is raining: Llueve<br>It is cold: Hace frío</p>', 'Intermediate', 4),
(2, 'Shopping', 'Essential shopping phrases and vocabulary', '<h2>Shopping</h2><p>How much does it cost?: ¿Cuánto cuesta?<br>Store: la tienda<br>Money: el dinero</p>', 'Intermediate', 5);

-- ===================================================================
-- Japanese Lessons
-- ===================================================================
INSERT INTO lessons (language_id, title, description, content, difficulty, order_index) VALUES
(3, 'Hiragana Basics', 'Introduction to the Hiragana writing system', '<h2>Hiragana Vowels</h2><p>Japanese has 5 basic vowels:<br>あ (a)<br>い (i)<br>う (u)<br>え (e)<br>お (o)</p>', 'Beginner', 1),
(3, 'Greetings', 'Common Japanese greetings and polite expressions', '<h2>Japanese Greetings</h2><p>Hello: Konnichiwa<br>Good morning: Ohayou gozaimasu<br>Thank you: Arigatou gozaimasu</p>', 'Beginner', 2),
(3, 'Numbers', 'Learn to count in Japanese', '<h2>Numbers 1-5</h2><p>1: ichi<br>2: ni<br>3: san<br>4: shi / yon<br>5: go</p>', 'Beginner', 3),
(3, 'Food', 'Japanese food vocabulary and ordering phrases', '<h2>Food Vocabulary</h2><p>Water: mizu<br>Tea: ocha<br>Delicious: oishii</p>', 'Intermediate', 4),
(3, 'Directions', 'Ask for and give directions in Japanese', '<h2>Directions</h2><p>Right: migi<br>Left: hidari<br>Straight: massugu</p>', 'Intermediate', 5);

-- ===================================================================
-- French Exercises
-- ===================================================================
-- Lesson 1: Greetings
INSERT INTO exercises (lesson_id, type, question, correct_answer, options, points) VALUES
(1, 'MCQ', 'What does "Bonjour" mean?', 'Hello', '["Hello","Goodbye","Thank you","Please"]', 10),
(1, 'FILL_BLANK', 'Complete: "_____ , je m''appelle Marie." (Hello)', 'Bonjour', NULL, 10),
(1, 'MCQ', 'How do you say "Goodbye" in French?', 'Au revoir', '["Merci","Au revoir","Bonjour","Salut"]', 10),
(1, 'TRANSLATION', 'Translate to French: "My name is John"', 'Je m''appelle John', NULL, 15);

-- Lesson 2: Numbers
INSERT INTO exercises (lesson_id, type, question, correct_answer, options, points) VALUES
(2, 'MCQ', 'What is "trois" in English?', 'Three', '["One","Two","Three","Four"]', 10),
(2, 'FILL_BLANK', 'Write the French word for the number 5:', 'cinq', NULL, 10),
(2, 'MCQ', 'What number is "dix"?', '10', '["5","8","10","12"]', 10),
(2, 'MATCHING', 'Match the French numbers with English', 'un=one,deux=two,trois=three', '["un","deux","trois","one","two","three"]', 20);

-- Lesson 3: Colors
INSERT INTO exercises (lesson_id, type, question, correct_answer, options, points) VALUES
(3, 'MCQ', 'What color is "rouge"?', 'Red', '["Blue","Red","Green","Yellow"]', 10),
(3, 'FILL_BLANK', 'The French word for "blue" is _____.', 'bleu', NULL, 10),
(3, 'MCQ', 'What does "vert" mean?', 'Green', '["White","Black","Green","Orange"]', 10),
(3, 'TRANSLATION', 'Translate to English: "Le ciel est bleu"', 'The sky is blue', NULL, 15);

-- Lesson 4: Food & Dining
INSERT INTO exercises (lesson_id, type, question, correct_answer, options, points) VALUES
(4, 'MCQ', 'What is "pain" in English?', 'Bread', '["Water","Bread","Cheese","Wine"]', 10),
(4, 'FILL_BLANK', 'I would like water: "Je voudrais de l''_____"', 'eau', NULL, 10),
(4, 'TRANSLATION', 'Translate: "The menu, please"', 'Le menu, s''il vous plaît', NULL, 15),
(4, 'MCQ', 'What does "fromage" mean?', 'Cheese', '["Ham","Cheese","Butter","Milk"]', 10);

-- Lesson 5: Travel
INSERT INTO exercises (lesson_id, type, question, correct_answer, options, points) VALUES
(5, 'MCQ', 'What does "Où est la gare?" mean?', 'Where is the train station?', '["Where is the hotel?","Where is the train station?","Where is the airport?","Where is the museum?"]', 10),
(5, 'FILL_BLANK', 'I need a taxi: "J''ai besoin d''un _____"', 'taxi', NULL, 10),
(5, 'TRANSLATION', 'Translate: "How much does it cost?"', 'Combien ça coûte?', NULL, 15),
(5, 'MCQ', 'What is "l''aéroport"?', 'The airport', '["The hotel","The airport","The restaurant","The beach"]', 10);

-- ===================================================================
-- Spanish Exercises
-- ===================================================================
-- Lesson 6: Greetings
INSERT INTO exercises (lesson_id, type, question, correct_answer, options, points) VALUES
(6, 'MCQ', 'What does "Hola" mean?', 'Hello', '["Hello","Goodbye","Thanks","Please"]', 10),
(6, 'FILL_BLANK', 'Good morning in Spanish: "Buenos _____"', 'días', NULL, 10),
(6, 'MCQ', 'How do you say "Good night" in Spanish?', 'Buenas noches', '["Buenos días","Buenas tardes","Buenas noches","Hasta luego"]', 10),
(6, 'TRANSLATION', 'Translate to Spanish: "How are you?"', '¿Cómo estás?', NULL, 15);

-- Lesson 7: Family
INSERT INTO exercises (lesson_id, type, question, correct_answer, options, points) VALUES
(7, 'MCQ', 'What is "madre" in English?', 'Mother', '["Father","Mother","Sister","Brother"]', 10),
(7, 'FILL_BLANK', 'My father: "Mi _____"', 'padre', NULL, 10),
(7, 'MATCHING', 'Match family members', 'hermano=brother,hermana=sister,hijo=son', '["hermano","hermana","hijo","brother","sister","son"]', 20),
(7, 'MCQ', 'What does "abuelo" mean?', 'Grandfather', '["Uncle","Cousin","Grandfather","Nephew"]', 10);

-- Lesson 8: Animals
INSERT INTO exercises (lesson_id, type, question, correct_answer, options, points) VALUES
(8, 'MCQ', 'What animal is "gato"?', 'Cat', '["Dog","Cat","Bird","Fish"]', 10),
(8, 'FILL_BLANK', 'Dog in Spanish is _____.', 'perro', NULL, 10),
(8, 'MCQ', 'What does "pájaro" mean?', 'Bird', '["Fish","Bird","Horse","Rabbit"]', 10),
(8, 'TRANSLATION', 'Translate: "I have a cat and a dog"', 'Tengo un gato y un perro', NULL, 15);

-- Lesson 9: Weather
INSERT INTO exercises (lesson_id, type, question, correct_answer, options, points) VALUES
(9, 'MCQ', 'What does "Hace sol" mean?', 'It is sunny', '["It is raining","It is sunny","It is cold","It is windy"]', 10),
(9, 'FILL_BLANK', 'It is raining: "Está _____"', 'lloviendo', NULL, 10),
(9, 'MCQ', 'How do you say "cold" in Spanish?', 'frío', '["caliente","frío","nublado","ventoso"]', 10),
(9, 'TRANSLATION', 'Translate: "What is the weather like today?"', '¿Qué tiempo hace hoy?', NULL, 15);

-- Lesson 10: Shopping
INSERT INTO exercises (lesson_id, type, question, correct_answer, options, points) VALUES
(10, 'MCQ', 'What does "¿Cuánto cuesta?" mean?', 'How much does it cost?', '["Where is it?","How much does it cost?","What is this?","Do you have it?"]', 10),
(10, 'FILL_BLANK', 'I want to buy: "Quiero _____"', 'comprar', NULL, 10),
(10, 'TRANSLATION', 'Translate: "The store is closed"', 'La tienda está cerrada', NULL, 15),
(10, 'MCQ', 'What is "dinero"?', 'Money', '["Change","Money","Price","Receipt"]', 10);

-- ===================================================================
-- Japanese Exercises
-- ===================================================================
-- Lesson 11: Hiragana Basics
INSERT INTO exercises (lesson_id, type, question, correct_answer, options, points) VALUES
(11, 'MCQ', 'What sound does "あ" make?', 'a', '["a","i","u","e"]', 10),
(11, 'MCQ', 'Which hiragana represents "ka"?', 'か', '["き","く","か","け"]', 10),
(11, 'MATCHING', 'Match hiragana to romaji', 'あ=a,い=i,う=u', '["あ","い","う","a","i","u"]', 20),
(11, 'FILL_BLANK', 'Write the romaji for "さ":', 'sa', NULL, 10);

-- Lesson 12: Greetings (Japanese)
INSERT INTO exercises (lesson_id, type, question, correct_answer, options, points) VALUES
(12, 'MCQ', 'What does "こんにちは" mean?', 'Hello (daytime)', '["Good morning","Hello (daytime)","Good evening","Goodbye"]', 10),
(12, 'FILL_BLANK', 'Good morning in Japanese: "_____ございます"', 'おはよう', NULL, 10),
(12, 'MCQ', 'How do you say "Thank you" in Japanese?', 'ありがとう', '["すみません","ありがとう","こんばんは","さようなら"]', 10),
(12, 'TRANSLATION', 'Translate to English: "さようなら"', 'Goodbye', NULL, 15);

-- Lesson 13: Numbers (Japanese)
INSERT INTO exercises (lesson_id, type, question, correct_answer, options, points) VALUES
(13, 'MCQ', 'What number is "いち"?', '1', '["1","2","3","4"]', 10),
(13, 'FILL_BLANK', 'The Japanese word for 3 is _____.', 'さん', NULL, 10),
(13, 'MCQ', 'What is "じゅう"?', '10', '["5","7","10","100"]', 10),
(13, 'MATCHING', 'Match Japanese numbers', 'いち=1,に=2,さん=3', '["いち","に","さん","1","2","3"]', 20);

-- Lesson 14: Food (Japanese)
INSERT INTO exercises (lesson_id, type, question, correct_answer, options, points) VALUES
(14, 'MCQ', 'What is "すし" in English?', 'Sushi', '["Ramen","Sushi","Tempura","Rice"]', 10),
(14, 'FILL_BLANK', 'Water in Japanese is _____.', 'みず', NULL, 10),
(14, 'TRANSLATION', 'Translate: "I want to eat ramen"', 'ラーメンが食べたいです', NULL, 15),
(14, 'MCQ', 'What does "おいしい" mean?', 'Delicious', '["Expensive","Delicious","Spicy","Sweet"]', 10);

-- Lesson 15: Directions (Japanese)
INSERT INTO exercises (lesson_id, type, question, correct_answer, options, points) VALUES
(15, 'MCQ', 'What does "みぎ" mean?', 'Right', '["Left","Right","Straight","Back"]', 10),
(15, 'FILL_BLANK', 'Left in Japanese is _____.', 'ひだり', NULL, 10),
(15, 'MCQ', 'What is "まっすぐ"?', 'Straight ahead', '["Turn","Straight ahead","Behind","Next to"]', 10),
(15, 'TRANSLATION', 'Translate: "Where is the station?"', '駅はどこですか？', NULL, 15);

-- ===================================================================
-- Additional Languages
-- ===================================================================
INSERT INTO languages (name, code, flag_emoji, is_active) VALUES
('German', 'de', '????', TRUE),
('Italian', 'it', '????', TRUE),
('Korean', 'ko', '????', TRUE);

-- ===================================================================
-- German Lessons
-- ===================================================================
INSERT INTO lessons (language_id, title, description, content, difficulty, order_index) VALUES
((SELECT id FROM languages WHERE code='de'), 'Greetings', 'Basic German greetings', '<h2>German Greetings</h2><p>Hallo = Hello<br>Guten Morgen = Good morning<br>Auf Wiedersehen = Goodbye<br>Danke = Thank you</p>', 'Beginner', 1),
((SELECT id FROM languages WHERE code='de'), 'Numbers', 'Count in German', '<h2>German Numbers</h2><p>1: eins<br>2: zwei<br>3: drei<br>4: vier<br>5: fuenf<br>6: sechs<br>7: sieben<br>8: acht<br>9: neun<br>10: zehn</p>', 'Beginner', 2),
((SELECT id FROM languages WHERE code='de'), 'Colors', 'Learn German colors', '<h2>German Colors</h2><p>Red: rot<br>Blue: blau<br>Green: gruen<br>Yellow: gelb<br>Black: schwarz<br>White: weiss</p>', 'Beginner', 3),
((SELECT id FROM languages WHERE code='de'), 'Food', 'German food vocabulary', '<h2>German Food</h2><p>Bread: das Brot<br>Water: das Wasser<br>Milk: die Milch<br>Cheese: der Kaese<br>Apple: der Apfel</p>', 'Intermediate', 4),
((SELECT id FROM languages WHERE code='de'), 'Travel', 'Travel phrases in German', '<h2>Travel in German</h2><p>Where is...?: Wo ist...?<br>Train station: der Bahnhof<br>Airport: der Flughafen<br>Hotel: das Hotel</p>', 'Intermediate', 5);

-- ===================================================================
-- Italian Lessons
-- ===================================================================
INSERT INTO lessons (language_id, title, description, content, difficulty, order_index) VALUES
((SELECT id FROM languages WHERE code='it'), 'Greetings', 'Basic Italian greetings', '<h2>Italian Greetings</h2><p>Ciao = Hello/Bye<br>Buongiorno = Good morning<br>Arrivederci = Goodbye<br>Grazie = Thank you</p>', 'Beginner', 1),
((SELECT id FROM languages WHERE code='it'), 'Numbers', 'Count in Italian', '<h2>Italian Numbers</h2><p>1: uno<br>2: due<br>3: tre<br>4: quattro<br>5: cinque<br>6: sei<br>7: sette<br>8: otto<br>9: nove<br>10: dieci</p>', 'Beginner', 2),
((SELECT id FROM languages WHERE code='it'), 'Colors', 'Learn Italian colors', '<h2>Italian Colors</h2><p>Red: rosso<br>Blue: blu<br>Green: verde<br>Yellow: giallo<br>Black: nero<br>White: bianco</p>', 'Beginner', 3),
((SELECT id FROM languages WHERE code='it'), 'Food', 'Italian food vocabulary', '<h2>Italian Food</h2><p>Pizza: la pizza<br>Pasta: la pasta<br>Water: acqua<br>Wine: il vino<br>Cheese: il formaggio</p>', 'Intermediate', 4),
((SELECT id FROM languages WHERE code='it'), 'Travel', 'Travel phrases in Italian', '<h2>Travel in Italian</h2><p>Where is...?: Dove...?<br>Train station: la stazione<br>Airport: aeroporto<br>Hotel: albergo</p>', 'Intermediate', 5);

-- ===================================================================
-- Korean Lessons
-- ===================================================================
INSERT INTO lessons (language_id, title, description, content, difficulty, order_index) VALUES
((SELECT id FROM languages WHERE code='ko'), 'Hangul Basics', 'Learn Korean alphabet', '<h2>Korean Vowels</h2><p>? (a)<br>? (eo)<br>? (o)<br>? (u)<br>? (eu)<br>? (i)</p>', 'Beginner', 1),
((SELECT id FROM languages WHERE code='ko'), 'Greetings', 'Basic Korean greetings', '<h2>Korean Greetings</h2><p>????? = Hello<br>????? = Thank you<br>??? ??? = Goodbye<br>? = Yes<br>??? = No</p>', 'Beginner', 2),
((SELECT id FROM languages WHERE code='ko'), 'Numbers', 'Count in Korean', '<h2>Korean Numbers</h2><p>1: ? (il)<br>2: ? (i)<br>3: ? (sam)<br>4: ? (sa)<br>5: ? (o)</p>', 'Beginner', 3),
((SELECT id FROM languages WHERE code='ko'), 'Food', 'Korean food vocabulary', '<h2>Korean Food</h2><p>Rice: ? (bap)<br>Water: ? (mul)<br>Kimchi: ??<br>Delicious: ???? (masisseoyo)</p>', 'Intermediate', 4),
((SELECT id FROM languages WHERE code='ko'), 'Directions', 'Directions in Korean', '<h2>Korean Directions</h2><p>Left: ?? (oenjjok)<br>Right: ??? (oreunjjok)<br>Straight: ?? (jikjin)</p>', 'Intermediate', 5);

-- ===================================================================
-- German Exercises
-- ===================================================================
INSERT INTO exercises (lesson_id, type, question, correct_answer, options, points) VALUES
((SELECT id FROM lessons WHERE title='Greetings' AND language_id=(SELECT id FROM languages WHERE code='de')), 'MCQ', 'What does "Hallo" mean?', 'Hello', '["Hello","Goodbye","Thanks","Please"]', 10),
((SELECT id FROM lessons WHERE title='Greetings' AND language_id=(SELECT id FROM languages WHERE code='de')), 'FILL_BLANK', 'Good morning in German: "Guten _____"', 'Morgen', NULL, 10),
((SELECT id FROM lessons WHERE title='Greetings' AND language_id=(SELECT id FROM languages WHERE code='de')), 'MCQ', 'How do you say Goodbye in German?', 'Auf Wiedersehen', '["Danke","Bitte","Auf Wiedersehen","Hallo"]', 10),
((SELECT id FROM lessons WHERE title='Greetings' AND language_id=(SELECT id FROM languages WHERE code='de')), 'TRANSLATION', 'Translate: "Thank you very much"', 'Vielen Dank', NULL, 15),
((SELECT id FROM lessons WHERE title='Numbers' AND language_id=(SELECT id FROM languages WHERE code='de')), 'MCQ', 'What is "drei" in English?', 'Three', '["One","Two","Three","Four"]', 10),
((SELECT id FROM lessons WHERE title='Numbers' AND language_id=(SELECT id FROM languages WHERE code='de')), 'FILL_BLANK', 'The German word for 5 is _____.', 'fuenf', NULL, 10),
((SELECT id FROM lessons WHERE title='Numbers' AND language_id=(SELECT id FROM languages WHERE code='de')), 'MCQ', 'What number is "zehn"?', '10', '["5","8","10","12"]', 10),
((SELECT id FROM lessons WHERE title='Colors' AND language_id=(SELECT id FROM languages WHERE code='de')), 'MCQ', 'What color is "rot"?', 'Red', '["Blue","Red","Green","Yellow"]', 10),
((SELECT id FROM lessons WHERE title='Colors' AND language_id=(SELECT id FROM languages WHERE code='de')), 'FILL_BLANK', 'The German word for blue is _____.', 'blau', NULL, 10),
((SELECT id FROM lessons WHERE title='Colors' AND language_id=(SELECT id FROM languages WHERE code='de')), 'TRANSLATION', 'Translate: "The sky is blue"', 'Der Himmel ist blau', NULL, 15),
((SELECT id FROM lessons WHERE title='Food' AND language_id=(SELECT id FROM languages WHERE code='de')), 'MCQ', 'What is "Brot" in English?', 'Bread', '["Water","Bread","Cheese","Wine"]', 10),
((SELECT id FROM lessons WHERE title='Food' AND language_id=(SELECT id FROM languages WHERE code='de')), 'FILL_BLANK', 'Water in German is _____.', 'Wasser', NULL, 10),
((SELECT id FROM lessons WHERE title='Travel' AND language_id=(SELECT id FROM languages WHERE code='de')), 'MCQ', 'What is "der Bahnhof"?', 'Train station', '["Airport","Train station","Hotel","Museum"]', 10),
((SELECT id FROM lessons WHERE title='Travel' AND language_id=(SELECT id FROM languages WHERE code='de')), 'TRANSLATION', 'Translate: "Where is the airport?"', 'Wo ist der Flughafen?', NULL, 15);

-- ===================================================================
-- Italian Exercises
-- ===================================================================
INSERT INTO exercises (lesson_id, type, question, correct_answer, options, points) VALUES
((SELECT id FROM lessons WHERE title='Greetings' AND language_id=(SELECT id FROM languages WHERE code='it')), 'MCQ', 'What does "Ciao" mean?', 'Hello', '["Hello","Goodbye","Thanks","Please"]', 10),
((SELECT id FROM lessons WHERE title='Greetings' AND language_id=(SELECT id FROM languages WHERE code='it')), 'FILL_BLANK', 'Good morning in Italian: "_____"', 'Buongiorno', NULL, 10),
((SELECT id FROM lessons WHERE title='Greetings' AND language_id=(SELECT id FROM languages WHERE code='it')), 'TRANSLATION', 'Translate: "How are you?"', 'Come stai?', NULL, 15),
((SELECT id FROM lessons WHERE title='Numbers' AND language_id=(SELECT id FROM languages WHERE code='it')), 'MCQ', 'What is "tre" in English?', 'Three', '["One","Two","Three","Four"]', 10),
((SELECT id FROM lessons WHERE title='Numbers' AND language_id=(SELECT id FROM languages WHERE code='it')), 'FILL_BLANK', 'The Italian word for 5 is _____.', 'cinque', NULL, 10),
((SELECT id FROM lessons WHERE title='Numbers' AND language_id=(SELECT id FROM languages WHERE code='it')), 'MCQ', 'What number is "dieci"?', '10', '["5","8","10","12"]', 10),
((SELECT id FROM lessons WHERE title='Colors' AND language_id=(SELECT id FROM languages WHERE code='it')), 'MCQ', 'What color is "rosso"?', 'Red', '["Blue","Red","Green","Yellow"]', 10),
((SELECT id FROM lessons WHERE title='Colors' AND language_id=(SELECT id FROM languages WHERE code='it')), 'FILL_BLANK', 'The Italian word for green is _____.', 'verde', NULL, 10),
((SELECT id FROM lessons WHERE title='Food' AND language_id=(SELECT id FROM languages WHERE code='it')), 'MCQ', 'What is "acqua"?', 'Water', '["Water","Wine","Bread","Cheese"]', 10),
((SELECT id FROM lessons WHERE title='Food' AND language_id=(SELECT id FROM languages WHERE code='it')), 'TRANSLATION', 'Translate: "I want pizza"', 'Voglio la pizza', NULL, 15),
((SELECT id FROM lessons WHERE title='Travel' AND language_id=(SELECT id FROM languages WHERE code='it')), 'MCQ', 'What is "la stazione"?', 'Train station', '["Airport","Train station","Hotel","Museum"]', 10),
((SELECT id FROM lessons WHERE title='Travel' AND language_id=(SELECT id FROM languages WHERE code='it')), 'TRANSLATION', 'Translate: "Where is the hotel?"', 'Dov''e'' l''albergo?', NULL, 15);

-- ===================================================================
-- Korean Exercises
-- ===================================================================
INSERT INTO exercises (lesson_id, type, question, correct_answer, options, points) VALUES
((SELECT id FROM lessons WHERE title='Hangul Basics' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'MCQ', 'What sound does "?" make?', 'a', '["a","o","u","e"]', 10),
((SELECT id FROM lessons WHERE title='Hangul Basics' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'MCQ', 'Which is the vowel "o"?', '?', '["?","?","?","?"]', 10),
((SELECT id FROM lessons WHERE title='Hangul Basics' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'FILL_BLANK', 'The romanization of ? is _____.', 'i', NULL, 10),
((SELECT id FROM lessons WHERE title='Greetings' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'MCQ', 'What does "?????" mean?', 'Hello', '["Hello","Goodbye","Thanks","Sorry"]', 10),
((SELECT id FROM lessons WHERE title='Greetings' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'MCQ', 'How do you say Thank you in Korean?', '?????', '["?????","?????","???","?"]', 10),
((SELECT id FROM lessons WHERE title='Greetings' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'TRANSLATION', 'Translate: "Goodbye"', '??? ???', NULL, 15),
((SELECT id FROM lessons WHERE title='Numbers' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'MCQ', 'What number is "?"?', '3', '["1","2","3","4"]', 10),
((SELECT id FROM lessons WHERE title='Numbers' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'FILL_BLANK', 'The Korean word for 1 is _____.', '?', NULL, 10),
((SELECT id FROM lessons WHERE title='Food' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'MCQ', 'What is "?"?', 'Rice', '["Water","Rice","Kimchi","Tea"]', 10),
((SELECT id FROM lessons WHERE title='Food' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'FILL_BLANK', 'Water in Korean is _____.', '?', NULL, 10),
((SELECT id FROM lessons WHERE title='Directions' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'MCQ', 'What does "??" mean?', 'Left', '["Left","Right","Straight","Back"]', 10),
((SELECT id FROM lessons WHERE title='Directions' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'FILL_BLANK', 'Right in Korean is _____.', '???', NULL, 10);
