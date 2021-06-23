DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS authors;

CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  external_id VARCHAR(250) NOT NULL UNIQUE,
  first_name VARCHAR(250)  NULL,
  last_name VARCHAR(250)  NULL,
  email VARCHAR(250)  NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  deleted VARCHAR(300)
);

CREATE TABLE authors (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  external_id VARCHAR(250) NOT NULL UNIQUE,
  first_name VARCHAR(250) NULL,
  last_name VARCHAR(250) NULL,
  email VARCHAR(250)  NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  deleted VARCHAR(300)
);

CREATE TABLE courses (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  external_id VARCHAR(250) NOT NULL UNIQUE,
  title VARCHAR(500) NOT NULL,
  description text NOT NULL,
  created_by INT REFERENCES authors(id),
  state VARCHAR(250) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  deleted VARCHAR(300)
);

CREATE TABLE user_courses (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  external_id VARCHAR(250) NOT NULL UNIQUE,
  user_id INT REFERENCES users(id),
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  deleted VARCHAR(300)
);

CREATE TABLE author_courses (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  external_id VARCHAR(250) NOT NULL UNIQUE,
  author_id INT REFERENCES authors(id),
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  deleted VARCHAR(300)
);

CREATE TABLE sections (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  external_id VARCHAR(250) NOT NULL UNIQUE,
  course_id INT REFERENCES courses(id),
  title VARCHAR(500) NOT NULL,
  description text NOT NULL,
  state VARCHAR(250) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  deleted VARCHAR(300)
);

CREATE TABLE lessons (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  external_id VARCHAR(250) NOT NULL UNIQUE,
  section INT REFERENCES sections(id),
  title VARCHAR(500) NOT NULL,
  description text NOT NULL,
  url VARCHAR(500) NOT NULL,
  type VARCHAR(250) NOT NULL,
  state VARCHAR(250) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  deleted VARCHAR(300)
);

CREATE TABLE commits (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  external_id VARCHAR(250) NOT NULL UNIQUE,
  author_id INT REFERENCES authors(id),
  previous_commit INT REFERENCES commits(id),
  message text NOT NULL,
  state VARCHAR(250) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  deleted VARCHAR(300)
);

CREATE TABLE staged_changes (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  external_id VARCHAR(250) NOT NULL UNIQUE,
  author_id INT REFERENCES authors(id),
  state VARCHAR(250) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  deleted VARCHAR(300)
);

CREATE TABLE course_commits (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  external_id VARCHAR(250) NOT NULL,
  course_id INT REFERENCES courses(id),
  title VARCHAR(500) NOT NULL,
  description text NOT NULL,
  commit_id INT REFERENCES commits(id),
  staged_id INT REFERENCES staged_changes(id),
  state VARCHAR(250) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  deleted VARCHAR(300)
);

CREATE TABLE lesson_commits (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  external_id VARCHAR(250) NOT NULL,
  section_id INT REFERENCES sections(id),
  commit_id INT REFERENCES commits(id),
  staged_id INT REFERENCES staged_changes(id),
  title VARCHAR(500) NOT NULL,
  description text NOT NULL,
  url VARCHAR(500) NOT NULL,
  type VARCHAR(250) NOT NULL,
  state VARCHAR(250) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  deleted VARCHAR(300)
);

CREATE TABLE section_commits (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  external_id VARCHAR(250) NOT NULL,
  lesson_id INT REFERENCES lessons(id),
  title VARCHAR(500) NOT NULL,
  description text NOT NULL,
  commit_id INT REFERENCES commits(id),
  staged_id INT REFERENCES staged_changes(id),
  state VARCHAR(250) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  deleted VARCHAR(300)
);









INSERT INTO users (first_name, last_name, email, created_at, updated_at, external_id) VALUES
('Nicholas','Jones', 'nicholas.jones@example.com',  '2021-04-18 13:00:01','2021-04-18 13:00:01', 'Nicholas'),
('Jason','Bond','jason.bond@example.com', '2021-04-18 13:00:01','2021-04-18 13:00:01', 'jason'),
('Amy',	'Burgess','amy.burgess@example.com', '2021-04-18 13:00:01','2021-04-18 13:00:01', 'amy'),
('Isaac','Tucker','isaac.tucker@example.com','2021-04-18 13:00:01','2021-04-18 13:00:01', 'Isaac'),
('Boris','Scott','boris.scott@example.com', '2021-04-18 13:00:01','2021-04-18 13:00:01', 'Boris');

INSERT INTO authors (first_name, last_name, email, created_at, updated_at, external_id) VALUES
('Donna','Graham','donna.graham@sample.com','2021-04-18 13:00:01','2021-04-18 13:00:01', 'Donna'),
('Richard','Tucker','richard.tucker@sample.com', '2021-04-18 13:00:01','2021-04-18 13:00:01','Richard'),
('Leonard','Ellison','leonard.ellison@sample.com', '2021-04-18 13:00:01','2021-04-18 13:00:01','Leonard'),
('Jasmine','Bell','jasmine.bell@sample.com','2021-04-18 13:00:01','2021-04-18 13:00:01','Jasmine');