

CREATE TABLE blog_posts (
	id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1),
	created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	title VARCHAR(255),
	message VARCHAR(4000),
	PRIMARY KEY(id)
);