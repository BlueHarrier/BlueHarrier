1. `SELECT * FROM family_members;`
2. `SELECT name, species FROM family_members;`
3. `SELECT * FROM family_members WHERE species = 'dog';`
4. `SELECT * FROM family_members WHERE num_books_read > 190;`
5. `SELECT * FROM family_members WHERE num_books_read >= 180;`
6. `SELECT * FROM friends_of_pickles WHERE species = 'dog' AND height_cm < 45;`
7. `SELECT * FROM friends_of_pickles WHERE species = 'dog' OR height_cm < 45;`
8. `SELECT * FROM friends_of_pickles WHERE species NOT IN ('cat', 'dog');` # Corregido
9. `SELECT DISTINCT species FROM friends_of_pickles WHERE height_cm > 50;`
10. `SELECT * FROM friends_of_pickles ORDER BY height_cm DESC;`
11. `SELECT * FROM friends_of_pickles ORDER BY height_cm DESC LIMIT 1;`
12. `SELECT COUNT(*) FROM friends_of_pickles;`
13. `SELECT COUNT(*) FROM friends_of_pickles WHERE species = 'dog';`
14. `SELECT SUM(num_books_read) FROM family_members;`
15. `SELECT AVG(num_books_read) FROM family_members;`
16. `SELECT MAX(num_books_read) FROM family_members;`
17. `SELECT MAX(height_cm), species FROM friends_of_pickles GROUP BY species;`
18. `SELECT * FROM family_members WHERE num_books_read = (SELECT MAX(num_books_read) FROM family_members);`
19. `SELECT * FROM family_members WHERE favorite_book IS NOT NULL;`
20. `SELECT * FROM celebs_born WHERE birthdate > '1980-09-1';`
21. `SELECT character.name, character_actor.actor_name FROM character INNER JOIN character_actor ON character.id = character_actor.character_id;`
22. `SELECT character.name, actor.name FROM character INNER JOIN character_actor ON character.id = character_actor.character_id INNER JOIN actor ON actor.id = character_actor.actor_id;`
23. `SELECT character.name, tv_show.name FROM character INNER JOIN character_tv_show ON character.id = character_tv_show.character_id INNER JOIN tv_show ON character_tv_show.tv_show_id = tv_show.id WHERE character.name != "Willow Rosenberg" AND tv_show.name != "How I Met Your Mother";`
24. `SELECT character.name, actor.name FROM character LEFT JOIN character_actor ON character.id = character_actor.character_id LEFT JOIN actor ON actor.id = character_actor.actor_id;`
25. `SELECT c.name, a.name FROM character AS c LEFT JOIN character_actor AS ca ON c.id = ca.character_id LEFT JOIN actor AS a ON a.id = ca.actor_id;`
26. `SELECT character.name AS character, actor.name AS actor FROM character LEFT JOIN character_actor ON character.id = character_actor.character_id LEFT JOIN actor ON actor.id = character_actor.actor_id;`
27. `SELECT r1.name AS employee_name, r2.name AS boss_name FROM employees AS r1 INNER JOIN employees  AS r2 ON r1.boss_id = r2.id;`
28. `SELECT * FROM robots WHERE name LIKE "%Robot 20%";`
29. `SELECT *, CASE WHEN species = 'human' THEN 'talk' WHEN species = 'dog' THEN 'bark' WHEN species = 'cat' THEN 'meow' END AS sound FROM friends_of_pickles;`
30. `SELECT * FROM robots WHERE SUBSTR(location, -2) LIKE 'NY';`
31. `SELECT name, COALESCE(tank, gun, sword) AS weapon FROM fighters;`
