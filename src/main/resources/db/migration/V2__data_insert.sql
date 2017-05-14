INSERT INTO bank_system.user_account (user_id, user_username, user_password) VALUES
  (1, 'user1', '$2a$11$a/RAO1MPYgCPIUbH6JvwcelljMPnC8BMG32XkfhN.u41vEkAUfnba'),
  (2, 'user2', '$2a$11$a/RAO1MPYgCPIUbH6JvwcelljMPnC8BMG32XkfhN.u41vEkAUfnba');


INSERT INTO bank_system.client (client_id, client_name, client_surname, client_dob) VALUES
  (1, 'Chris', 'Magro', '1984-02-04'),
  (2, 'Steph', 'Borg Bonaci', '1986-03-02');


INSERT INTO bank_system.address (address_id, address_line1, address_line2, address_city, address_county, address_primary)
VALUES
  (1, 'Clevelands, Block B, P/H 4,', 'Triq il-Fiera', 'Bahrija', 'Malta', TRUE),
  (2, 'My Nest, No. 85,', 'Peach Street', 'San Gwann', 'Malta', TRUE),
  (3, 'Block A, No.1,', 'Straight Street', 'Valletta', 'Malta', FALSE);


INSERT INTO bank_system.client_address (address_id, client_id) VALUES
  (1, 1),
  (3, 1),
  (2, 2);

INSERT INTO bank_system.account (account_id, account_number, account_type, account_balance, account_balance_status, account_overdraft_limit, client_id, account_timestamp )
VALUES
  (1, 500000000001, 'SAVINGS', 900, 'DR', 0, 1, '2017-05-14 13:49:23'),
  (2, 500000000002, 'CURRENT', 200, 'DR', 1000, 2, '2017-05-14 13:49:24'),
  (3, 500000000003, 'SAVINGS', 400, 'DR', 0, 1, '2017-05-14 13:49:25');


INSERT INTO bank_system.transaction (transaction_id, transaction_credit_account, transaction_debit_account, transaction_amount, transaction_message)
VALUES
  (1, 1, 3, 400, 'A2A Transfer'),
  (2, 1, 2, 200, 'A2A Transfer');