﻿CREATE ROLE wc_admin LOGIN ENCRYPTED PASSWORD 'md587a4b048b15b70390a89488f48d1ac4d'
  CREATEDB CREATEROLE
   VALID UNTIL 'infinity';

   

CREATE DATABASE "waiProject"
  WITH ENCODING='UTF8'
       OWNER=wc_admin
       CONNECTION LIMIT=-1;

	   
