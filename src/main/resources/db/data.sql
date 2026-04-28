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
('Japanese', 'ja', '🇯🇵', TRUE),
('German', 'de', '🇩🇪', TRUE),
('Italian', 'it', '🇮🇹', TRUE),
('Korean', 'ko', '🇰🇷', TRUE);

-- ===================================================================
-- French Lessons
-- ===================================================================
INSERT INTO lessons (language_id, title, description, content, difficulty, order_index) VALUES
(1, 'Greetings', 'Learn basic French greetings and introductions', '<h2>French Greetings</h2><p>Welcome to LexiTrace! In French, greetings change depending on the time of day.</p><table class="vocab-table"><tr><th>French</th><th>English</th></tr><tr><td>Bonjour</td><td>Hello / Good day</td></tr><tr><td>Au revoir</td><td>Goodbye</td></tr><tr><td>Salut</td><td>Hi / Bye (informal)</td></tr><tr><td>Merci</td><td>Thank you</td></tr><tr><td>S''il vous plaît</td><td>Please</td></tr></table><p>To introduce yourself: <strong>Je m''appelle...</strong> (My name is...).</p>', 'Beginner', 1),
(1, 'Numbers', 'Master French numbers from 1 to 10', '<h2>French Numbers 1-10</h2><p>Counting in French is essential for shopping and travel.</p><table class="vocab-table"><tr><th>Number</th><th>French</th></tr><tr><td>1</td><td>un</td></tr><tr><td>2</td><td>deux</td></tr><tr><td>3</td><td>trois</td></tr><tr><td>4</td><td>quatre</td></tr><tr><td>5</td><td>cinq</td></tr><tr><td>6</td><td>six</td></tr><tr><td>7</td><td>sept</td></tr><tr><td>8</td><td>huit</td></tr><tr><td>9</td><td>neuf</td></tr><tr><td>10</td><td>dix</td></tr></table>', 'Beginner', 2),
(1, 'Colors', 'Learn common colors in French', '<h2>French Colors</h2><p>Describe the world around you!</p><table class="vocab-table"><tr><th>Color</th><th>French</th></tr><tr><td>Red</td><td>rouge</td></tr><tr><td>Blue</td><td>bleu</td></tr><tr><td>Green</td><td>vert</td></tr><tr><td>Yellow</td><td>jaune</td></tr><tr><td>Black</td><td>noir</td></tr><tr><td>White</td><td>blanc</td></tr></table><p>Example: <strong>Le ciel est bleu.</strong> (The sky is blue.)</p>', 'Beginner', 3),
(1, 'Food & Dining', 'Essential food vocabulary and dining phrases', '<h2>Food & Dining</h2><p>French cuisine is world-famous. Here is the basics for your first meal.</p><table class="vocab-table"><tr><th>French</th><th>English</th></tr><tr><td>le pain</td><td>bread</td></tr><tr><td>l''eau</td><td>water</td></tr><tr><td>le fromage</td><td>cheese</td></tr><tr><td>le menu</td><td>the menu</td></tr><tr><td>S''il vous plaît</td><td>please</td></tr><tr><td>manger</td><td>to eat</td></tr></table><p>Useful phrase: <strong>Le menu, s''il vous plaît.</strong> (The menu, please.)</p>', 'Intermediate', 4),
(1, 'Travel', 'Useful phrases for traveling in France', '<h2>Travel Basics</h2><p>Navigate your way through France with these essential phrases.</p><table class="vocab-table"><tr><th>French</th><th>English</th></tr><tr><td>Où est...?</td><td>Where is...?</td></tr><tr><td>la gare</td><td>the train station</td></tr><tr><td>l''aéroport</td><td>the airport</td></tr><tr><td>l''hôtel</td><td>the hotel</td></tr><tr><td>le billet</td><td>the ticket</td></tr><tr><td>un taxi</td><td>a taxi</td></tr><tr><td>Combien ça coûte?</td><td>How much does it cost?</td></tr></table>', 'Intermediate', 5);

-- ===================================================================
-- Spanish Lessons
-- ===================================================================
INSERT INTO lessons (language_id, title, description, content, difficulty, order_index) VALUES
(2, 'Greetings', 'Learn basic Spanish greetings and farewells', '<h2>Spanish Greetings</h2><p>Spanish is a warm and friendly language.</p><table class="vocab-table"><tr><th>Spanish</th><th>English</th></tr><tr><td>¡Hola!</td><td>Hello!</td></tr><tr><td>¡Adiós!</td><td>Goodbye!</td></tr><tr><td>Buenos días</td><td>Good morning</td></tr><tr><td>Buenas noches</td><td>Good night</td></tr><tr><td>¿Cómo estás?</td><td>How are you?</td></tr></table>', 'Beginner', 1),
(2, 'Family', 'Talk about your family members in Spanish', '<h2>Family Vocabulary</h2><p>Family (la familia) is very important in Spanish-speaking cultures.</p><table class="vocab-table"><tr><th>Spanish</th><th>English</th></tr><tr><td>madre</td><td>mother</td></tr><tr><td>padre</td><td>father</td></tr><tr><td>hermano</td><td>brother</td></tr><tr><td>hermana</td><td>sister</td></tr><tr><td>hijo</td><td>son</td></tr><tr><td>abuelo</td><td>grandfather</td></tr></table>', 'Beginner', 2),
(2, 'Animals', 'Learn animal names in Spanish', '<h2>Animals (Animales)</h2><table class="vocab-table"><tr><th>Spanish</th><th>English</th></tr><tr><td>perro</td><td>dog</td></tr><tr><td>gato</td><td>cat</td></tr><tr><td>pájaro</td><td>bird</td></tr><tr><td>pez</td><td>fish</td></tr><tr><td>caballo</td><td>horse</td></tr></table>', 'Beginner', 3),
(2, 'Weather', 'Discuss weather and seasons in Spanish', '<h2>Weather (El Tiempo)</h2><p>Learn how to describe the day.</p><table class="vocab-table"><tr><th>Spanish</th><th>English</th></tr><tr><td>Hace sol</td><td>It is sunny</td></tr><tr><td>Llueve</td><td>It is raining / It rains</td></tr><tr><td>Hace frío</td><td>It is cold</td></tr><tr><td>¿Qué tiempo hace hoy?</td><td>What is the weather like today?</td></tr></table>', 'Intermediate', 4),
(2, 'Shopping', 'Essential shopping phrases and vocabulary', '<h2>Shopping (Compras)</h2><table class="vocab-table"><tr><th>Spanish</th><th>English</th></tr><tr><td>¿Cuánto cuesta?</td><td>How much does it cost?</td></tr><tr><td>la tienda</td><td>the store</td></tr><tr><td>el dinero</td><td>the money</td></tr><tr><td>comprar</td><td>to buy</td></tr><tr><td>cerrado/a</td><td>closed</td></tr></table>', 'Intermediate', 5);

-- ===================================================================
-- Japanese Lessons
-- ===================================================================
INSERT INTO lessons (language_id, title, description, content, difficulty, order_index) VALUES
(3, 'Hiragana Basics', 'Introduction to the Hiragana writing system', '<h2>Hiragana Vowels</h2><p>Japanese has 3 writing systems. Hiragana is the basic phonetic alphabet.</p><table class="vocab-table"><tr><th>Character</th><th>Romaji (Sound)</th></tr><tr><td>あ</td><td>a</td></tr><tr><td>い</td><td>i</td></tr><tr><td>う</td><td>u</td></tr><tr><td>え</td><td>e</td></tr><tr><td>お</td><td>o</td></tr><tr><td>か</td><td>ka</td></tr><tr><td>さ</td><td>sa</td></tr></table>', 'Beginner', 1),
(3, 'Greetings', 'Common Japanese greetings and polite expressions', '<h2>Japanese Greetings</h2><p>Politeness is key in Japanese culture.</p><table class="vocab-table"><tr><th>Japanese</th><th>Romaji</th><th>English</th></tr><tr><td>こんにちは</td><td>Konnichiwa</td><td>Hello (daytime)</td></tr><tr><td>おはよう</td><td>Ohayou</td><td>Good morning</td></tr><tr><td>ありがとう</td><td>Arigatou</td><td>Thank you</td></tr><tr><td>さようなら</td><td>Sayounara</td><td>Goodbye</td></tr></table>', 'Beginner', 2),
(3, 'Numbers', 'Learn to count in Japanese', '<h2>Numbers 1-10</h2><table class="vocab-table"><tr><th>Number</th><th>Hiragana</th><th>Romaji</th></tr><tr><td>1</td><td>いち</td><td>ichi</td></tr><tr><td>2</td><td>に</td><td>ni</td></tr><tr><td>3</td><td>さん</td><td>san</td></tr><tr><td>4</td><td>し / よん</td><td>shi / yon</td></tr><tr><td>5</td><td>ご</td><td>go</td></tr><tr><td>10</td><td>じゅう</td><td>juu</td></tr></table>', 'Beginner', 3),
(3, 'Food', 'Japanese food vocabulary and ordering phrases', '<h2>Food Vocabulary</h2><table class="vocab-table"><tr><th>Japanese</th><th>Romaji</th><th>English</th></tr><tr><td>すし</td><td>sushi</td><td>Sushi</td></tr><tr><td>ラーメン</td><td>raamen</td><td>Ramen</td></tr><tr><td>みず</td><td>mizu</td><td>Water</td></tr><tr><td>おちゃ</td><td>ocha</td><td>Tea</td></tr><tr><td>たべたい</td><td>tabetai</td><td>want to eat</td></tr><tr><td>おいしい</td><td>oishii</td><td>delicious</td></tr></table>', 'Intermediate', 4),
(3, 'Directions', 'Ask for and give directions in Japanese', '<h2>Directions</h2><table class="vocab-table"><tr><th>Japanese</th><th>Romaji</th><th>English</th></tr><tr><td>みぎ</td><td>migi</td><td>right</td></tr><tr><td>ひだり</td><td>hidari</td><td>left</td></tr><tr><td>まっすぐ</td><td>massugu</td><td>straight</td></tr><tr><td>どこ</td><td>doko</td><td>where</td></tr><tr><td>えき</td><td>eki</td><td>station</td></tr></table>', 'Intermediate', 5);

-- ===================================================================
-- German Lessons
-- ===================================================================
INSERT INTO lessons (language_id, title, description, content, difficulty, order_index) VALUES
((SELECT id FROM languages WHERE code='de'), 'Greetings', 'Basic German greetings', '<h2>German Greetings</h2><table class="vocab-table"><tr><th>German</th><th>English</th></tr><tr><td>Hallo</td><td>Hello</td></tr><tr><td>Guten Morgen</td><td>Good morning</td></tr><tr><td>Auf Wiedersehen</td><td>Goodbye</td></tr><tr><td>Danke</td><td>Thank you</td></tr><tr><td>Vielen Dank</td><td>Thank you very much</td></tr></table>', 'Beginner', 1),
((SELECT id FROM languages WHERE code='de'), 'Numbers', 'Count in German', '<h2>German Numbers</h2><table class="vocab-table"><tr><th>Number</th><th>German</th></tr><tr><td>1</td><td>eins</td></tr><tr><td>2</td><td>zwei</td></tr><tr><td>3</td><td>drei</td></tr><tr><td>5</td><td>fuenf</td></tr><tr><td>10</td><td>zehn</td></tr></table>', 'Beginner', 2),
((SELECT id FROM languages WHERE code='de'), 'Colors', 'Learn German colors', '<h2>German Colors</h2><table class="vocab-table"><tr><th>Color</th><th>German</th></tr><tr><td>Red</td><td>rot</td></tr><tr><td>Blue</td><td>blau</td></tr><tr><td>Green</td><td>gruen</td></tr><tr><td>Yellow</td><td>gelb</td></tr><tr><td>Black</td><td>schwarz</td></tr><tr><td>White</td><td>weiss</td></tr></table>', 'Beginner', 3),
((SELECT id FROM languages WHERE code='de'), 'Food', 'German food vocabulary', '<h2>German Food</h2><table class="vocab-table"><tr><th>German</th><th>English</th></tr><tr><td>das Brot</td><td>bread</td></tr><tr><td>das Wasser</td><td>water</td></tr><tr><td>die Milch</td><td>milk</td></tr><tr><td>der Kaese</td><td>cheese</td></tr><tr><td>der Apfel</td><td>apple</td></tr></table>', 'Intermediate', 4),
((SELECT id FROM languages WHERE code='de'), 'Travel', 'Travel phrases in German', '<h2>Travel in German</h2><table class="vocab-table"><tr><th>German</th><th>English</th></tr><tr><td>Wo ist...?</td><td>Where is...?</td></tr><tr><td>der Bahnhof</td><td>the train station</td></tr><tr><td>der Flughafen</td><td>the airport</td></tr><tr><td>das Hotel</td><td>the hotel</td></tr></table>', 'Intermediate', 5);

-- ===================================================================
-- Italian Lessons
-- ===================================================================
INSERT INTO lessons (language_id, title, description, content, difficulty, order_index) VALUES
((SELECT id FROM languages WHERE code='it'), 'Greetings', 'Basic Italian greetings', '<h2>Italian Greetings</h2><table class="vocab-table"><tr><th>Italian</th><th>English</th></tr><tr><td>Ciao</td><td>Hello / Bye</td></tr><tr><td>Buongiorno</td><td>Good morning</td></tr><tr><td>Arrivederci</td><td>Goodbye</td></tr><tr><td>Grazie</td><td>Thank you</td></tr><tr><td>Come stai?</td><td>How are you?</td></tr></table>', 'Beginner', 1),
((SELECT id FROM languages WHERE code='it'), 'Numbers', 'Count in Italian', '<h2>Italian Numbers</h2><table class="vocab-table"><tr><th>Number</th><th>Italian</th></tr><tr><td>1</td><td>uno</td></tr><tr><td>2</td><td>due</td></tr><tr><td>3</td><td>tre</td></tr><tr><td>5</td><td>cinque</td></tr><tr><td>10</td><td>dieci</td></tr></table>', 'Beginner', 2),
((SELECT id FROM languages WHERE code='it'), 'Colors', 'Learn Italian colors', '<h2>Italian Colors</h2><table class="vocab-table"><tr><th>Color</th><th>Italian</th></tr><tr><td>Red</td><td>rosso</td></tr><tr><td>Blue</td><td>blu</td></tr><tr><td>Green</td><td>verde</td></tr><tr><td>Yellow</td><td>giallo</td></tr><tr><td>Black</td><td>nero</td></tr><tr><td>White</td><td>bianco</td></tr></table>', 'Beginner', 3),
((SELECT id FROM languages WHERE code='it'), 'Food', 'Italian food vocabulary', '<h2>Italian Food</h2><table class="vocab-table"><tr><th>Italian</th><th>English</th></tr><tr><td>la pizza</td><td>pizza</td></tr><tr><td>la pasta</td><td>pasta</td></tr><tr><td>acqua</td><td>water</td></tr><tr><td>il vino</td><td>wine</td></tr><tr><td>il formaggio</td><td>cheese</td></tr><tr><td>Voglio...</td><td>I want...</td></tr></table>', 'Intermediate', 4),
((SELECT id FROM languages WHERE code='it'), 'Travel', 'Travel phrases in Italian', '<h2>Travel in Italian</h2><table class="vocab-table"><tr><th>Italian</th><th>English</th></tr><tr><td>Dove...?</td><td>Where...?</td></tr><tr><td>la stazione</td><td>the station</td></tr><tr><td>aeroporto</td><td>airport</td></tr><tr><td>albergo</td><td>hotel</td></tr></table>', 'Intermediate', 5);

-- ===================================================================
-- Korean Lessons
-- ===================================================================
INSERT INTO lessons (language_id, title, description, content, difficulty, order_index) VALUES
((SELECT id FROM languages WHERE code='ko'), 'Hangul Basics', 'Learn Korean alphabet', '<h2>Korean Vowels</h2><table class="vocab-table"><tr><th>Character</th><th>Sound</th></tr><tr><td>ㅏ</td><td>a</td></tr><tr><td>ㅓ</td><td>eo</td></tr><tr><td>ㅗ</td><td>o</td></tr><tr><td>ㅜ</td><td>u</td></tr><tr><td>ㅡ</td><td>eu</td></tr><tr><td>ㅣ</td><td>i</td></tr></table>', 'Beginner', 1),
((SELECT id FROM languages WHERE code='ko'), 'Greetings', 'Basic Korean greetings', '<h2>Korean Greetings</h2><table class="vocab-table"><tr><th>Korean</th><th>Romanization</th><th>English</th></tr><tr><td>안녕하세요</td><td>Annyeonghaseyo</td><td>Hello</td></tr><tr><td>감사합니다</td><td>Gamsahamnida</td><td>Thank you</td></tr><tr><td>안녕히 가세요</td><td>Annyeonghi gaseyo</td><td>Goodbye</td></tr><tr><td>네</td><td>Ne</td><td>Yes</td></tr><tr><td>아니요</td><td>Aniyo</td><td>No</td></tr></table>', 'Beginner', 2),
((SELECT id FROM languages WHERE code='ko'), 'Numbers', 'Count in Korean', '<h2>Korean Numbers (Sino-Korean)</h2><table class="vocab-table"><tr><th>Number</th><th>Korean</th><th>Romanization</th></tr><tr><td>1</td><td>일</td><td>il</td></tr><tr><td>2</td><td>이</td><td>i</td></tr><tr><td>3</td><td>삼</td><td>sam</td></tr><tr><td>4</td><td>사</td><td>sa</td></tr><tr><td>5</td><td>오</td><td>o</td></tr></table>', 'Beginner', 3),
((SELECT id FROM languages WHERE code='ko'), 'Food', 'Korean food vocabulary', '<h2>Korean Food</h2><table class="vocab-table"><tr><th>Korean</th><th>Romanization</th><th>English</th></tr><tr><td>밥</td><td>bap</td><td>rice / meal</td></tr><tr><td>물</td><td>mul</td><td>water</td></tr><tr><td>김치</td><td>kimchi</td><td>kimchi</td></tr><tr><td>맛있어요</td><td>masisseoyo</td><td>delicious</td></tr></table>', 'Intermediate', 4),
((SELECT id FROM languages WHERE code='ko'), 'Directions', 'Directions in Korean', '<h2>Korean Directions</h2><table class="vocab-table"><tr><th>Korean</th><th>Romanization</th><th>English</th></tr><tr><td>왼쪽</td><td>oenjjok</td><td>left</td></tr><tr><td>오른쪽</td><td>oreunjjok</td><td>right</td></tr><tr><td>직진</td><td>jikjin</td><td>straight ahead</td></tr></table>', 'Intermediate', 5);

-- ===================================================================
-- Clear existing exercises to prevent duplicates
-- ===================================================================
TRUNCATE TABLE exercises;

-- ===================================================================
-- French Exercises
-- ===================================================================
INSERT INTO exercises (lesson_id, type, question, correct_answer, options, points) VALUES
(1, 'MCQ', 'What does "Bonjour" mean?', 'Hello', '["Hello","Goodbye","Thank you","Please"]', 10),
(1, 'FILL_BLANK', 'Complete: "_____ , je m''appelle Marie." (Hello)', 'Bonjour', NULL, 10),
(1, 'MCQ', 'How do you say "Goodbye" in French?', 'Au revoir', '["Merci","Au revoir","Bonjour","Salut"]', 10),
(1, 'TRANSLATION', 'Translate to French: "My name is John"', 'Je m''appelle John', NULL, 15),
(2, 'MCQ', 'What is "trois" in English?', 'Three', '["One","Two","Three","Four"]', 10),
(2, 'FILL_BLANK', 'Write the French word for the number 5:', 'cinq', NULL, 10),
(2, 'MCQ', 'What number is "dix"?', '10', '["5","8","10","12"]', 10),
(2, 'MATCHING', 'Match the French numbers with English', 'un=one,deux=two,trois=three', '["un","deux","trois","one","two","three"]', 20),
(3, 'MCQ', 'What color is "rouge"?', 'Red', '["Blue","Red","Green","Yellow"]', 10),
(3, 'FILL_BLANK', 'The French word for "blue" is _____.', 'bleu', NULL, 10),
(3, 'MCQ', 'What does "vert" mean?', 'Green', '["White","Black","Green","Orange"]', 10),
(3, 'TRANSLATION', 'Translate to English: "Le ciel est bleu"', 'The sky is blue', NULL, 15),
(4, 'MCQ', 'What is "pain" in English?', 'Bread', '["Water","Bread","Cheese","Wine"]', 10),
(4, 'FILL_BLANK', 'I would like water: "Je voudrais de l''_____"', 'eau', NULL, 10),
(4, 'TRANSLATION', 'Translate: "The menu, please"', 'Le menu, s''il vous plaît', NULL, 15),
(4, 'MCQ', 'What does "fromage" mean?', 'Cheese', '["Ham","Cheese","Butter","Milk"]', 10),
(5, 'MCQ', 'What does "Où est la gare?" mean?', 'Where is the train station?', '["Where is the hotel?","Where is the train station?","Where is the airport?","Where is the museum?"]', 10),
(5, 'FILL_BLANK', 'I need a taxi: "J''ai besoin d''un _____"', 'taxi', NULL, 10),
(5, 'TRANSLATION', 'Translate: "How much does it cost?"', 'Combien ça coûte?', NULL, 15),
(5, 'MCQ', 'What is "l''aéroport"?', 'The airport', '["The hotel","The airport","The restaurant","The beach"]', 10);

-- ===================================================================
-- Spanish Exercises
-- ===================================================================
INSERT INTO exercises (lesson_id, type, question, correct_answer, options, points) VALUES
(6, 'MCQ', 'What does "Hola" mean?', 'Hello', '["Hello","Goodbye","Thanks","Please"]', 10),
(6, 'FILL_BLANK', 'Good morning in Spanish: "Buenos _____"', 'días', NULL, 10),
(6, 'MCQ', 'How do you say "Good night" in Spanish?', 'Buenas noches', '["Buenos días","Buenas tardes","Buenas noches","Hasta luego"]', 10),
(6, 'TRANSLATION', 'Translate to Spanish: "How are you?"', '¿Cómo estás?', NULL, 15),
(7, 'MCQ', 'What is "madre" in English?', 'Mother', '["Father","Mother","Sister","Brother"]', 10),
(7, 'FILL_BLANK', 'My father: "Mi _____"', 'padre', NULL, 10),
(7, 'MATCHING', 'Match family members', 'hermano=brother,hermana=sister,hijo=son', '["hermano","hermana","hijo","brother","sister","son"]', 20),
(7, 'MCQ', 'What does "abuelo" mean?', 'Grandfather', '["Uncle","Cousin","Grandfather","Nephew"]', 10),
(8, 'MCQ', 'What animal is "gato"?', 'Cat', '["Dog","Cat","Bird","Fish"]', 10),
(8, 'FILL_BLANK', 'Dog in Spanish is _____.', 'perro', NULL, 10),
(8, 'MCQ', 'What does "pájaro" mean?', 'Bird', '["Fish","Bird","Horse","Rabbit"]', 10),
(8, 'TRANSLATION', 'Translate: "I have a cat and a dog"', 'Tengo un gato y un perro', NULL, 15),
(9, 'MCQ', 'What does "Hace sol" mean?', 'It is sunny', '["It is raining","It is sunny","It is cold","It is windy"]', 10),
(9, 'FILL_BLANK', 'It is raining: "Está _____"', 'lloviendo', NULL, 10),
(9, 'MCQ', 'How do you say "cold" in Spanish?', 'frío', '["caliente","frío","nublado","ventoso"]', 10),
(9, 'TRANSLATION', 'Translate: "What is the weather like today?"', '¿Qué tiempo hace hoy?', NULL, 15),
(10, 'MCQ', 'What does "¿Cuánto cuesta?" mean?', 'How much does it cost?', '["Where is it?","How much does it cost?","What is this?","Do you have it?"]', 10),
(10, 'FILL_BLANK', 'I want to buy: "Quiero _____"', 'comprar', NULL, 10),
(10, 'TRANSLATION', 'Translate: "The store is closed"', 'La tienda está cerrada', NULL, 15),
(10, 'MCQ', 'What is "dinero"?', 'Money', '["Change","Money","Price","Receipt"]', 10);

-- ===================================================================
-- Japanese Exercises
-- ===================================================================
INSERT INTO exercises (lesson_id, type, question, correct_answer, options, points) VALUES
(11, 'MCQ', 'What sound does "あ" make?', 'a', '["a","i","u","e"]', 10),
(11, 'MCQ', 'Which hiragana represents "ka"?', 'か', '["き","く","か","け"]', 10),
(11, 'MATCHING', 'Match hiragana to romaji', 'あ=a,い=i,う=u', '["あ","い","う","a","i","u"]', 20),
(11, 'FILL_BLANK', 'Write the romaji for "さ":', 'sa', NULL, 10),
(12, 'MCQ', 'What does "こんにちは" mean?', 'Hello (daytime)', '["Good morning","Hello (daytime)","Good evening","Goodbye"]', 10),
(12, 'FILL_BLANK', 'Good morning in Japanese: "_____ございます"', 'おはよう', NULL, 10),
(12, 'MCQ', 'How do you say "Thank you" in Japanese?', 'ありがとう', '["すみません","ありがとう","こんばんは","さようなら"]', 10),
(12, 'TRANSLATION', 'Translate to English: "さようなら"', 'Goodbye', NULL, 15),
(13, 'MCQ', 'What number is "いち"?', '1', '["1","2","3","4"]', 10),
(13, 'FILL_BLANK', 'The Japanese word for 3 is _____.', 'さん', NULL, 10),
(13, 'MCQ', 'What is "じゅう"?', '10', '["5","7","10","100"]', 10),
(13, 'MATCHING', 'Match Japanese numbers', 'いち=1,に=2,さん=3', '["いち","に","さん","1","2","3"]', 20),
(14, 'MCQ', 'What is "すし" in English?', 'Sushi', '["Ramen","Sushi","Tempura","Rice"]', 10),
(14, 'FILL_BLANK', 'Water in Japanese is _____.', 'みず', NULL, 10),
(14, 'TRANSLATION', 'Translate: "I want to eat ramen"', 'ラーメン가食べたいです', NULL, 15),
(14, 'MCQ', 'What does "おいしい" mean?', 'Delicious', '["Expensive","Delicious","Spicy","Sweet"]', 10),
(15, 'MCQ', 'What does "みぎ" mean?', 'Right', '["Left","Right","Straight","Back"]', 10),
(15, 'FILL_BLANK', 'Left in Japanese is _____.', 'ひだり', NULL, 10),
(15, 'MCQ', 'What is "まっすぐ"?', 'Straight ahead', '["Turn","Straight ahead","Behind","Next to"]', 10),
(15, 'TRANSLATION', 'Translate: "Where is the station?"', '駅はどこですか？', NULL, 15);

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
((SELECT id FROM lessons WHERE title='Hangul Basics' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'MCQ', 'What sound does "ㅏ" make?', 'a', '["a","o","u","e"]', 10),
((SELECT id FROM lessons WHERE title='Hangul Basics' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'MCQ', 'Which is the vowel "o"?', 'ㅗ', '["ㅏ","ㅓ","ㅗ","ㅜ"]', 10),
((SELECT id FROM lessons WHERE title='Hangul Basics' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'FILL_BLANK', 'The romanization of ㅣ is _____.', 'i', NULL, 10),
((SELECT id FROM lessons WHERE title='Greetings' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'MCQ', 'What does "안녕하세요" mean?', 'Hello', '["Hello","Goodbye","Thanks","Sorry"]', 10),
((SELECT id FROM lessons WHERE title='Greetings' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'MCQ', 'How do you say Thank you in Korean?', '감사합니다', '["안녕하세요","감사합니다","아니요","네"]', 10),
((SELECT id FROM lessons WHERE title='Greetings' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'TRANSLATION', 'Translate: "Goodbye"', '안녕히 가세요', NULL, 15),
((SELECT id FROM lessons WHERE title='Numbers' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'MCQ', 'What number is "삼"?', '3', '["1","2","3","4"]', 10),
((SELECT id FROM lessons WHERE title='Numbers' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'FILL_BLANK', 'The Korean word for 1 is _____.', '일', NULL, 10),
((SELECT id FROM lessons WHERE title='Food' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'MCQ', 'What is "밥"?', 'Rice', '["Water","Rice","Kimchi","Tea"]', 10),
((SELECT id FROM lessons WHERE title='Food' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'FILL_BLANK', 'Water in Korean is _____.', '물', NULL, 10),
((SELECT id FROM lessons WHERE title='Directions' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'MCQ', 'What does "왼쪽" mean?', 'Left', '["Left","Right","Straight","Back"]', 10),
((SELECT id FROM lessons WHERE title='Directions' AND language_id=(SELECT id FROM languages WHERE code='ko')), 'FILL_BLANK', 'Right in Korean is _____.', '오른쪽', NULL, 10);
