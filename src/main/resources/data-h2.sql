-- Cleanup all tables --
DELETE FROM ACCOUNT;
DELETE FROM ACCOUNT_ACCOUNTID;
DELETE FROM BRANCH;
DELETE FROM BRANCH_CUSTOMER_SEGMENT;
DELETE FROM BRANCH_ACCESSIBILITY;
DELETE FROM BRAND;
DELETE FROM OFFER;
DELETE FROM PARTY;
DELETE FROM BENEFICIARY_CREDITOR_ACCOUNT;
DELETE FROM BENEFICIARY_CREDITOR_AGENT;
DELETE FROM BENEFICIARY;
DELETE FROM SCHEDULED_PAYMENT;
DELETE FROM SCHEDULED_PAYMENT_CREDITOR_ACCOUNT;
DELETE FROM SCHEDULED_PAYMENT_CREDITOR_AGENT;

-- Insert Brand and Branches --
INSERT INTO BRAND (ID, BRAND_NAME) VALUES (1, 'Open Bank Switzerland');

INSERT INTO BRANCH(ID, IDENTIFICATION, BRANCH_TYPE, NAME, SEQUENCE_NUMBER, COUNTRY, BRAND_ID) VALUES (1, '77720400','Physical','BOURNE', '00', 'CH',1);
INSERT INTO BRANCH_CUSTOMER_SEGMENT(BRANCH_ID, CUSTOMER_SEGMENT) VALUES(1, 'Business');
INSERT INTO BRANCH_CUSTOMER_SEGMENT(BRANCH_ID, CUSTOMER_SEGMENT) VALUES(1, 'Personal');
INSERT INTO BRANCH_ACCESSIBILITY(BRANCH_ID, ACCESSIBILITY) VALUES(1, 'WheelChairAccess');

-- Insert ACCOUNTS --
INSERT INTO ACCOUNT (ACCOUNT_ID, ACCOUNT_SUB_TYPE, ACCOUNT_TYPE, CURRENCY, DESCRIPTION, NICKNAME, servicer_id) VALUES ('22289', 'CurrentAccount', 'Personal', 'CHF', null, 'Barbara', null);
INSERT INTO ACCOUNT (ACCOUNT_ID, ACCOUNT_SUB_TYPE, ACCOUNT_TYPE, CURRENCY, DESCRIPTION, NICKNAME, servicer_id) VALUES ('22288', 'CurrentAccount', 'Personal', 'CHF', null, 'Reto', null);
INSERT INTO ACCOUNT (ACCOUNT_ID, ACCOUNT_SUB_TYPE, ACCOUNT_TYPE, CURRENCY, DESCRIPTION, NICKNAME, servicer_id) VALUES ('22232', 'CurrentAccount', 'Personal', 'CHF', null, 'konto', null);
INSERT INTO ACCOUNT (ACCOUNT_ID, ACCOUNT_SUB_TYPE, ACCOUNT_TYPE, CURRENCY, DESCRIPTION, NICKNAME, servicer_id) VALUES ('37373', 'Mortgage', 'Personal', 'CHF', null, 'house ', null);
INSERT INTO ACCOUNT (ACCOUNT_ID, ACCOUNT_SUB_TYPE, ACCOUNT_TYPE, CURRENCY, DESCRIPTION, NICKNAME, servicer_id) VALUES ('22231', 'Savings', 'Personal', 'CHF', null, 'new car', null);
INSERT INTO ACCOUNT_ACCOUNTID (id, IDENTIFICATION, NAME, SCHEME_NAME, SECONDARY_IDENTIFICATION, ACCOUNT_ID) VALUES (1, 'CH2981011000000000001', 'Barbara Muster', 'IBAN', null, '22289');
INSERT INTO ACCOUNT_ACCOUNTID (id, IDENTIFICATION, NAME, SCHEME_NAME, SECONDARY_IDENTIFICATION, ACCOUNT_ID) VALUES (2, 'CH2981011000000000004', 'Reto Muster', 'IBAN', null, '22288');
INSERT INTO ACCOUNT_ACCOUNTID (id, IDENTIFICATION, NAME, SCHEME_NAME, SECONDARY_IDENTIFICATION, ACCOUNT_ID) VALUES (4, 'CH4380005000000000001', 'Peter Peterson', 'IBAN', null, '37373');
INSERT INTO ACCOUNT_ACCOUNTID (id, IDENTIFICATION, NAME, SCHEME_NAME, SECONDARY_IDENTIFICATION, ACCOUNT_ID) VALUES (3, 'CH6880005000099998888', 'Lenny', 'IBAN', null, '22232');
INSERT INTO ACCOUNT_ACCOUNTID (id, IDENTIFICATION, NAME, SCHEME_NAME, SECONDARY_IDENTIFICATION, ACCOUNT_ID) VALUES (5, 'CH3580005000000220044', 'Rick', 'IBAN', null, '22231');


-- Insert BALANCE
INSERT INTO BALANCE (id, ACCOUNT_ID, AMOUNT, CURRENCY, TYPE, CREDIT_DEBIT_CODE, DATE_TIME) VALUES (1, '22289', 20.00, 'CHF', 'InterimBooked', 'Credit', '2015-10-08 08:00:00');
INSERT INTO BALANCE (id, ACCOUNT_ID, AMOUNT, CURRENCY, TYPE, CREDIT_DEBIT_CODE, DATE_TIME) VALUES (2, '22289', 1748.00, 'CHF', 'InterimBooked', 'Debit', '2015-10-08 08:00:00');
INSERT INTO BALANCE (id, ACCOUNT_ID, AMOUNT, CURRENCY, TYPE, CREDIT_DEBIT_CODE, DATE_TIME) VALUES (3, '22289', 3811.50, 'CHF', 'InterimBooked', 'Debit', '2015-10-08 08:00:00');
INSERT INTO BALANCE (id, ACCOUNT_ID, AMOUNT, CURRENCY, TYPE, CREDIT_DEBIT_CODE, DATE_TIME) VALUES (4, '22289', 1245.00, 'CHF', 'InterimBooked', 'Credit', '2015-10-08 08:00:00');
INSERT INTO BALANCE (id, ACCOUNT_ID, AMOUNT, CURRENCY, TYPE, CREDIT_DEBIT_CODE, DATE_TIME) VALUES (5, '22289', 600.00, 'CHF', 'InterimBooked', 'Credit', '2015-09-26 08:00:00');
INSERT INTO BALANCE (id, ACCOUNT_ID, AMOUNT, CURRENCY, TYPE, CREDIT_DEBIT_CODE, DATE_TIME) VALUES (6, '22289',  1190.00, 'CHF', 'InterimBooked', 'Credit', '2015-09-26 08:00:00');
INSERT INTO BALANCE (id, ACCOUNT_ID, AMOUNT, CURRENCY, TYPE, CREDIT_DEBIT_CODE, DATE_TIME) VALUES (7, '22289', 722.00, 'CHF', 'InterimBooked', 'Credit', '2015-09-26 08:00:00');
INSERT INTO BALANCE (id, ACCOUNT_ID, AMOUNT, CURRENCY, TYPE, CREDIT_DEBIT_CODE, DATE_TIME) VALUES (8, '22289', 536.00, 'CHF', 'InterimBooked', 'Debit', '2015-09-26 08:00:00');
INSERT INTO BALANCE (id, ACCOUNT_ID, AMOUNT, CURRENCY, TYPE, CREDIT_DEBIT_CODE, DATE_TIME) VALUES (9, '37373', 12312.00, 'CHF', 'InterimBooked', 'Credit', '2015-10-08 08:00:00');
INSERT INTO BALANCE (id, ACCOUNT_ID, AMOUNT, CURRENCY, TYPE, CREDIT_DEBIT_CODE, DATE_TIME) VALUES (10, '22231', 234.00, 'CHF', 'InterimBooked', 'Debit', '2015-10-08 08:00:00');
INSERT INTO BALANCE (id, ACCOUNT_ID, AMOUNT, CURRENCY, TYPE, CREDIT_DEBIT_CODE, DATE_TIME) VALUES (11, '22232', 123153.00, 'CHF', 'InterimBooked', 'Debit', '2015-10-08 08:00:00');

-- Insert OFFER --
INSERT INTO OFFER (id, ACCOUNT_ID, OFFER_ID, OFFER_TYPE, DESCRIPTION, AMOUNT, AMOUNT_CURRENCY) VALUES(1, '22289', 'Offer1', 'LimitIncrease', 'Credit limit increase for the account up to CHF 10000.00', 10000.00, 'CHF'); 

-- Insert PARTY
INSERT INTO PARTY (id, ACCOUNT_ID, ADDRESS_TYPE, BUILDING_NUMBER, COUNTRY, COUNTRY_SUB_DIVISION, POSTAL_CODE, STREET_NAME, TOWN_NAME, EMAIL, MOBILE, NAME, PARTY_ID, PARTY_NUMBER, PARTY_TYPE, PHONE) VALUES (1, '22289', 'Residential', null, 'CH', null, '8000', 'Bahnhofstrasse', 'Zurich', 'barbara@zurich.ch', '+41796002565', 'Barbara Muster', 'PXSIF023', null, 'Sole ', '+416125625');
INSERT INTO PARTY (id, ACCOUNT_ID, ADDRESS_TYPE, BUILDING_NUMBER, COUNTRY, COUNTRY_SUB_DIVISION, POSTAL_CODE, STREET_NAME, TOWN_NAME, EMAIL, MOBILE, NAME, PARTY_ID, PARTY_NUMBER, PARTY_TYPE, PHONE) VALUES (2, '22288', 'Residential', null, 'CH', null, '8000', 'Bahnhofstrasse', 'Zurich', 'reto@zurich.ch', '+41796002564', 'Reto Muster', 'PXSIM021', null, 'Sole', '+416125625');
INSERT INTO PARTY (id, ACCOUNT_ID, ADDRESS_TYPE, BUILDING_NUMBER, COUNTRY, COUNTRY_SUB_DIVISION, POSTAL_CODE, STREET_NAME, TOWN_NAME, EMAIL, MOBILE, NAME, PARTY_ID, PARTY_NUMBER, PARTY_TYPE, PHONE) VALUES (3, '37373', 'Postal', '1', 'CH', null, '8931', 'Lerzenstrasse', 'Dietikon', 'peterson@yahoo.com', '+41797447372', 'Peter Peterson', 'PXSIC022', null, 'Sole', '+41797447372');
INSERT INTO PARTY (id, ACCOUNT_ID, ADDRESS_TYPE, BUILDING_NUMBER, COUNTRY, COUNTRY_SUB_DIVISION, POSTAL_CODE, STREET_NAME, TOWN_NAME, EMAIL, MOBILE, NAME, PARTY_ID, PARTY_NUMBER, PARTY_TYPE, PHONE) VALUES (4, '22231', 'Postal', '123', 'CH', null, '8038', 'Badenerstrasse', 'Zurich', 'Lenny@yandex.ru', '+41786444535', 'Lehnard Sutter', 'JKSIF211', null, 'Sole', '+41786444535');
INSERT INTO PARTY (id, ACCOUNT_ID, ADDRESS_TYPE, BUILDING_NUMBER, COUNTRY, COUNTRY_SUB_DIVISION, POSTAL_CODE, STREET_NAME, TOWN_NAME, EMAIL, MOBILE, NAME, PARTY_ID, PARTY_NUMBER, PARTY_TYPE, PHONE) VALUES (5, '22232', 'Residential', '23', 'CH', null, '8048', 'Leimbachweg', 'Zurich', 'Rick@gmail.com', '+41797337677', 'Richard Hoffman', 'PXDIF322', null, 'Sole', '+41797337677');


-- Insert BENEFICIARY with BENEFICIARY_CREDITOR_ACCOUNT --
INSERT INTO BENEFICIARY (ID, ACCOUNT_ID, BENEFICIARY_ID, REFERENCE) VALUES (100, '22289', 'Ben1', 'Towbar Club');
INSERT INTO BENEFICIARY_CREDITOR_ACCOUNT (ID, IDENTIFICATION, NAME, SCHEME_NAME, SECONDARY_IDENTIFICATION, BENEFICIARY_ID) VALUES (200, '80200112345678', 'Mrs Juniper', 'SortCodeAccountNumber', null, 100);

INSERT INTO BENEFICIARY (ID, ACCOUNT_ID, BENEFICIARY_ID, REFERENCE) VALUES (101, '31820', 'Ben37', 'Golf Club');
INSERT INTO BENEFICIARY_CREDITOR_ACCOUNT (ID, IDENTIFICATION, NAME, SCHEME_NAME, SECONDARY_IDENTIFICATION, BENEFICIARY_ID) VALUES (201, '87562298675421', 'Mr Large', 'SortCodeAccountNumber', null, 101);


-- Insert SCHEDULED_PAYMENT with SCHEDULED_PAYMENT_CREDITOR_ACCOUNT --
INSERT INTO SCHEDULED_PAYMENT (ID, ACCOUNT_ID, AMOUNT, CURRENCY, REFERENCE, SCHEDULED_PAYMENT_DATETIME, SCHEDULED_PAYMENT_ID, SCHEDULED_TYPE) VALUES (300, '22289', 10.00, 'GBP', null, '2017-05-05 00:00:00', 'SP03', 'Execution');
INSERT INTO SCHEDULED_PAYMENT_CREDITOR_ACCOUNT (ID, IDENTIFICATION, NAME, SCHEME_NAME, SECONDARY_IDENTIFICATION, SCHEDULED_PAYMENT_ID) VALUES (202, '23605490179017', 'Mr Tee', 'SortCodeAccountNumber', null, 300);

INSERT INTO SCHEDULED_PAYMENT (ID, ACCOUNT_ID, AMOUNT, CURRENCY, REFERENCE, SCHEDULED_PAYMENT_DATETIME, SCHEDULED_PAYMENT_ID, SCHEDULED_TYPE) VALUES (301, '39570', 12.00, 'GBP', null, '2017-04-05 00:00:00', 'SP77', 'Execution');
INSERT INTO SCHEDULED_PAYMENT_CREDITOR_ACCOUNT (ID, IDENTIFICATION, NAME, SCHEME_NAME, SECONDARY_IDENTIFICATION, SCHEDULED_PAYMENT_ID) VALUES (203, '23605490179017', 'Mr Tee', 'SortCodeAccountNumber', null, 301);
