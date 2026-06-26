CREATE TABLE task (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    summary text NOT NULL,
    description text NOT NULL,
    status text NOT NULL
);