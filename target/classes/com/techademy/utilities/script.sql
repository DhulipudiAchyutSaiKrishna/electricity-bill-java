create database billdb;
use billdb;
create table bills
(
  consumer_no integer not null,
  prev_read decimal not null,
  curr_read decimal not null,
  units decimal,
  tot_charge decimal,
  bill_date date,
  due_date date
);