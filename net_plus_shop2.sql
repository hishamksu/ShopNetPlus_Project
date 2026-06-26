use net_plus_shop2;

create table PlatformAdmin(
id int Primary key,
emailAddress varchar(255),
passwordHash varchar(255),
registrationDate date,
adminRole varchar(255),
departmentName varchar(255));

create table customer(
id int primary key,
emailAddress varchar(255),
passwordHash varchar(255),
registrationDate date,
shippingAddress varchar(255),
dateOfBirth date,
notificationPreferences varchar(255));

create table subscriptionTier(
id int primary key,
tierName varchar(255),
monthlyPrice decimal(10,2),
annualPrice decimal(10,2));

create table benefit(
id int primary key AUTO_INCREMENT,
benefitName varchar(255),
benefitDescription varchar(255));

create table subscription(
id int primary key AUTO_INCREMENT,
cid int,
stid int,
startDate date,
nextRenewalDate Date,
billingCycle varchar(255),
subscriptionStatus varchar(255),
foreign key (cid) references customer(id),
foreign key (stid) references subscriptionTier(id));

create table payment(
id int primary key AUTO_INCREMENT,
sid int,
transactionAmount decimal(10,2),
paymentDate date,
paymentMethod varchar(255),
transactionStatus varchar(255),
foreign key (sid) references subscription(id));

create table customerOrder(
id int primary key AUTO_INCREMENT,
cid int,
orderDate date,
totalOrderValue decimal(10,2),
appliedCashBack decimal(10,2),
deliveryPriority varchar(255),
foreign key (cid) references customer(id));

CREATE TABLE benefit_tier(
stid INT,
bid INT,
PRIMARY KEY (stid, bid),
FOREIGN KEY (stid) REFERENCES subscriptionTier(id),
FOREIGN KEY (bid) REFERENCES benefit(id));
