USE blog_db;
INSERT INTO users (username, password, email, role) VALUES ('test_user', 'test123', 'test@test.com', 'USER');

INSERT INTO posts (user_id, title, content) VALUES (1, 'Babys First Post', 'Do not be alarmed. This is only a test.');

INSERT INTO categories (name) VALUES ('test_tag');

INSERT INTO post_category (post_id, category_id) VALUES (1, 1);

SELECT * FROM users;

SELECT * FROM posts;
SELECT * FROM post_category;