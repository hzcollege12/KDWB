

create table user(			// 44号古参林 P45-P49页数据库
	u_no INT NOT NULL,
	u_pwd VARCHAR(16) NOT NULL,
	u_name VARCHAR(8),
	u_email VARCHAR(18),
	u_state TINYTEXT,
	h_id  INT,
	PRIMARY KEY(u_no),
	FOREIGN	KEY(h_id)REFERENCES head(h_id)
);

create table friend(
	f_id INT NOT NULL,
	u_noz INT NOT NULL,
	u_noy INT NOT NULL,
	f_date TIMESTAMP,
	PRIMARY KEY(f_id), 
	FOREIGN KEY(u_noz)REFERENCES user(u_no),
	FOREIGN KEY(u_noy)REFERENCES user(u_no)10
 
 
);

create table diary(
	r_id INT NOT NULL,
	r_title VARCHAR(18) NOT NULL,
	r_content TEXT NOT NULL,
	r_date TIMESTAMP,
	r_no INT NOT NULL,
	PRIMARY KEY(r_id),
	FOREIGN KEY(u_no)REFERENCES user(u_no)
);

create table album(
	x_id INT NOT NULL,
	x_name VARCHAR(18) NOT NULL,
	x_no INT NOT NULL,
	x_access INT DEFAULT 0,
	x_date TIMESTAMP,
	PRIMARY KEY(x_id),
	FOREIGN KEY(u_no)REFERENCES user(u_no)
	
);

create table photo(
	p_id INT NOT NULL,
	p_name VARCHAR(18) NOT NULL,
	p_des VARCHAR(50) NOT NULL,
	P_data MEDIUMBLOB,
	x_id INT NOT NULL,
	PRIMARY KEY(p_id),
	FOREIGN KEY(x_id)REFERENCES album(x_id)
);

create table comment(
	c_id INT NOT NULL,
	c_content TEXT NOT NULL,
	c_no INT NOT NULL,
	r_id INT NOT NULL,
	c_date TIMESTAMP,
	PRIMARY KEY(c_id),
	FOREIGN KEY(u_no)REFERENCES user(u_no),
	FOREIGN KEY(r_id)REFERENCES diary(r_id)		
);

create table p_comment(
	c_id INT NOT NULL,
	c_content TEXT NOT NULL,
	u_no INT NOT NULL,
	p_id INT NOT NULL,
	c_date TIMESTAMP,
	PRIMARY KEY(c_id),
	FOREIGN KEY(u_no)REFERENCES user(u_no),	
	FOREIGN KEY(p_id)REFERENCES diary(p_id)
);

create table(
	v_id INT NOT NULL,
	u_no INT NOT NULL,
	v_no INT NOT NULL,
	v_date INT NOT NULL,
	PRIMARY KEY(v_id),
	FOREIGN KEY(u_no)REFERENCES user(u_no),	
	FOREIGN KEY(v_no)REFERENCES diary(u_no)
);

create table(
	h_id INT NOT NULL,
	h_des  VARCHAR(18) NOT NULL,
	h_data MEDIUMBLOB,NOT NULL,
	u_no INT,
	PRIMARY KEY(h_id),
	FOREIGN KEY(u_no)REFERENCES user(u_no),	
);
create table max(
	friend_max INT NOT NULL DEFAULT 0,
	diary_max INT NOT NULL DEFAULT 0,
	album_max INT NOT NULL DEFAULT 0,
	photo_max INT NOT NULL DEFAULT 0,
	comment_max INT NOT NULL DEFAULT 0,
	visit_max INT NOT NULL DEFAULT 0,
	user_max INT NOT NULL DEFAULT 0,
	head_max INT NOT NULL DEFAULT 0,
	p_comment_max INT NOT NULL DEFAULT 0
);








