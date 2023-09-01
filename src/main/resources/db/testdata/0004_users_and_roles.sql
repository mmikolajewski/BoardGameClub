insert into
    users (email, password)
VALUES
    ('admin@example.com', '{noop}123'),
    ('user@example.com', '{noop}123'),
    ('editor@example.com', '{noop}123');

insert into
    user_role (name, description)
VALUES
    ('ADMIN', 'pełne uprawnienia'),
    ('USER', 'podstawowe uprawnienia, możliwość dodawania głosów'),
    ('EDITOR', 'podstawowe uprawnienia, możliwość zarządzania treściami');

insert into
    user_roles (user_id, role_id)
VALUES
    (1,1),
    (2,2),
    (3,3);
