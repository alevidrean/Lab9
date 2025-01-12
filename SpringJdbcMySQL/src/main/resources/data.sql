drop table if exists masini;
CREATE TABLE masini (nr varchar(40) not null primary key, marca varchar(40) not null, anul int, culoarea varchar(40), kilometri varchar(40));
INSERT INTO masini (nr,marca,anul,culoarea,kilometri) VALUES ('A111XYZ', 'Ford', 2019, 'negru', 80000);
INSERT INTO masini (nr,marca,anul,culoarea,kilometri) VALUES ('B2132FG', 'Toyota', 2010, 'alb', 90000);
INSERT INTO masini (nr,marca,anul,culoarea,kilometri) VALUES ('A11GS32', 'Audi', 2020, 'rosu', 200000);
INSERT INTO masini (nr,marca,anul,culoarea,kilometri) VALUES ('C32HG32', 'Nissan', 2012, 'verde', 100000);
INSERT INTO masini (nr,marca,anul,culoarea,kilometri) VALUES ('D542HD2', 'Ford', 2002, 'rosu', 500000);