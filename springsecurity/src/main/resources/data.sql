INSERT INTO users (userName, password, enabled)
  values ('mohan','bro',true);

INSERT INTO users (userName, password, enabled)
  values ('arun','bro',true);

INSERT INTO authorities (userName, authority)
  values ('mohan', 'ROLE_USER');

INSERT INTO authorities (userName, authority)
  values ('arun', 'ROLE_ADMIN');