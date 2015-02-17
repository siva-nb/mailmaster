-- tables
-- Table campaign
use mailmaster;

DROP TABLE campaign;
CREATE TABLE campaign (
    id int  NOT NULL,
    statid int  NOT NULL,
    name int  NOT NULL,
    contentid int  NOT NULL,
    group_id int  NOT NULL,
    stats_id int  NOT NULL,
    login_uid int  NOT NULL,
    CONSTRAINT campaign_pk PRIMARY KEY (id)
);

DROP TABLE company;
CREATE TABLE company (
    name varchar(100)  NOT NULL,
    registered_date varchar(20)  NOT NULL,
    credit int  NOT NULL,
    domain varchar(100)  NOT NULL,
    type int  NOT NULL,
    lastmodified varchar(20)  NOT NULL,
    country varchar(20)  NOT NULL,
    id int  NOT NULL,
    user_id int  NOT NULL,
    CONSTRAINT company_pk PRIMARY KEY (id)
);

-- Table contact
DROP TABLE contact;
CREATE TABLE contact (
    id int  NOT NULL,
    firstname varchar(50)  NOT NULL,
    lastname varchar(50)  NOT NULL,
    email varchar(100)  NOT NULL,
    groupid int  NOT NULL,
    status int  NOT NULL,
    group_id int  NOT NULL,
    CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table content
DROP TABLE content;
CREATE TABLE content (
    id int  NOT NULL,
    filepath varchar(250)  NOT NULL,
    type int  NOT NULL,
    attachment varchar(100)  NOT NULL,
    campaign_id int  NOT NULL,
    CONSTRAINT content_pk PRIMARY KEY (id)
);

-- Table globalbacklist
DROP TABLE globalbacklist;
CREATE TABLE globalbacklist (
    email varchar(100)  NOT NULL,
    name int  NOT NULL,
    blacklistedon timestamp  NOT NULL,
    CONSTRAINT globalbacklist_pk PRIMARY KEY (email)
);

-- Table group
DROP TABLE group_contacts;
CREATE TABLE group_contacts (
    name varchar(25)  NOT NULL,
    id int  NOT NULL,
    CONSTRAINT group_pk PRIMARY KEY (id)
);

-- Table stats
DROP TABLE stats;
CREATE TABLE stats (
    id int  NOT NULL,
    startedon varchar(20)  NOT NULL,
    completedon varchar(20)  NOT NULL,
    numofopened int  NOT NULL,
    numofclick int  NOT NULL,
    hardbounces int  NOT NULL,
    CONSTRAINT stats_pk PRIMARY KEY (id)
);

-- Table user
DROP TABLE user;
CREATE TABLE user (
    id int  NOT NULL,
    firstname varchar(50)  NOT NULL,
    lastname varchar(50)  NULL,
    email varchar(100)  NOT NULL,
    country varchar(50)  NOT NULL,
    credit int  NOT NULL,
    lastmodified varchar(20)  NOT NULL,
    companyid int  NOT NULL,
    password varchar(50)  NOT NULL,
    type int  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference:  campaign_group (table: campaign)


ALTER TABLE campaign ADD CONSTRAINT campaign_group FOREIGN KEY campaign_group (group_id)
    REFERENCES group_contacts (id);
-- Reference:  campaign_stats (table: campaign)


ALTER TABLE campaign ADD CONSTRAINT campaign_stats FOREIGN KEY campaign_stats (stats_id)
    REFERENCES stats (id);
-- Reference:  company_user (table: company)


ALTER TABLE company ADD CONSTRAINT company_user FOREIGN KEY company_user (user_id)
    REFERENCES user (id);
-- Reference:  contact_group (table: contact)


ALTER TABLE contact ADD CONSTRAINT contact_group FOREIGN KEY contact (group_id)
    REFERENCES group_contacts (id);
-- Reference:  content_campaign (table: content)


ALTER TABLE content ADD CONSTRAINT content_campaign FOREIGN KEY content_campaign (campaign_id)
    REFERENCES campaign (id);

-- End of file.

