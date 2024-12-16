# Tech Blog

A Tech Blog application that allows users to register, create blog posts, and interact with other users. The application supports user authentication, blog management, and likes functionality.

## Project Structure

- **Controller**: Handles HTTP requests and responses.
- **Service**: Contains business logic.
- **Persistence**: Interacts with the database to fetch and store data.
- **DTO**: Represents the structure of data.
- **Util**: Contains utility classes such as database connections.

## Database Description

The database for the Tech-Blog project consists of several tables that store information related to users, posts, likes, and contact information. Below are the key tables in the database:

### Tables

#### 1. `users`

- **Description**: Stores user information such as name, email, and password.
- **Columns**:
  - `id` (integer, primary key)
  - `name` (varchar(100), NOT NULL)
  - `email` (varchar(100), NOT NULL, unique)
  - `password` (varchar(255), NOT NULL)
  - `gender` (varchar(10), optional)
  - `about` (text, optional)
  - `profile` (varchar(255), optional)
  
#### 2. `posts`

- **Description**: Stores blog posts created by users.
- **Columns**:
  - `pid` (integer, primary key)
  - `ptitle` (varchar(200), NOT NULL)
  - `pcontent` (text, NOT NULL)
  - `pcode` (text, optional)
  - `ppic` (varchar(200), optional)
  - `catid` (integer, foreign key referencing `categories(cid)`)
  - `userid` (integer, foreign key referencing `users(id)`)
  
#### 3. `liked`

- **Description**: Stores the "like" information for blog posts.
- **Columns**:
  - `id` (integer, primary key)
  - `pid` (integer, foreign key referencing `posts(pid)`)
  - `uid` (integer, foreign key referencing `users(id)`)

#### 4. `contact`

- **Description**: Stores contact information submitted by users or visitors.
- **Columns**:
  - `id` (integer, primary key, auto-incremented)
  - `cname` (varchar(100), NOT NULL) - Name of the person
  - `cemail` (varchar(150), NOT NULL) - Email of the person
  - `cnumber` (varchar(15), NOT NULL) - Phone number of the person

### Sample SQL Queries

#### Create Tables

-- Users Table: Stores information about users (username, email, password)
```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,                   -- auto-incrementing primary key
    name VARCHAR(100) NOT NULL,               -- name of the user
    email VARCHAR(100) UNIQUE NOT NULL,       -- unique email address
    password VARCHAR(255) NOT NULL,           -- hashed password
    gender VARCHAR(10),                      -- gender of the user (optional)
    about TEXT,                              -- additional information about the user (optional)
    profile VARCHAR(255),                    -- profile picture or other related data (optional)
);
```

-- Posts Table: Stores blog posts created by users
```sql
CREATE TABLE posts (
    pid SERIAL PRIMARY KEY,                   -- auto-incrementing primary key
    ptitle VARCHAR(200) NOT NULL,             -- title of the blog post
    pcontent TEXT NOT NULL,                   -- main content of the post
    pcode TEXT,                              -- code snippet related to the post (optional)
    ppic VARCHAR(200),                       -- image URL related to the post (optional)
    catid INT NOT NULL,                       -- category ID of the post
    userid INT NOT NULL,                      -- foreign key reference to the users table
);
```

-- Contact Table: Stores contact messages associated with blog posts and users
```sql
CREATE TABLE contact (
    id SERIAL PRIMARY KEY,                   -- auto-incrementing primary key
    cname VARCHAR(100) NOT NULL,              -- name of the person contacting
    cemail VARCHAR(150) NOT NULL,             -- email address of the person contacting
    cnumber VARCHAR(15) NOT NULL,             -- phone number of the person contacting
);
```

-- Likes Table: Stores likes associated with blog posts and users
```sql
CREATE TABLE liked (
    id SERIAL PRIMARY KEY,                   -- auto-incrementing primary key
    pid INT NOT NULL,                         -- foreign key reference to the posts table
    uid INT NOT NULL,                         -- foreign key reference to the users table
);
```
