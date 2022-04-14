# Ride Sharing App

This second practical work consists of implementing the model of a web application applying design patterns.

The model developed is not be a complete application, but only the system logic of the appliction itself. A set of unit tests were provided that allow the testing of a minimum set of desired functionalities although new tests were needed to be add to further test those functionalities. For this prototype persistence is implemented simply with serialization. 

The model follows both the following application description and the proposed package and class structure:

### Description: 

In the RideSharingApp (or simply RSA) there are 2 types of users: drivers and passengers. If they are going to the same destination and are currently close the app pairs them. For this the users are regularly updating their position and if they are not yet paired they are given a set of possibilities.

App users can either give a ride or hitch a ride. That is, they can be the driver of the car and give a ride, or be the passenger and hitch a ride. The same user can be a driver at times, and a passenger at others. When they want to use the app, users can start by defining the ride they want to give or receive. Each ride has a starting point and an ending point.
The driver can ask for a share in the cost of the ride, which makes sharing more interesting for them. But this is not mandatory.
The driver giving a ride will have to specify which car he is using, one of the ones he has previously registered. For each car the make, model, color, and license plate number is stored, which serves as the key.
A ride without specifying the car will be considered a ride request, made by a possible passenger.

Once a ride is defined, the user's position is regularly updated since the user, whether passenger or driver, may be on the move.
When a ride's position is updated, an attempt will be made to pair it with a complementary ride. That is, if it's a driver a passenger will be looked for; if it's a passenger a driver will be looked for.
The pairing will consider the rides that are nearby at that moment. From these will be filtered the complementary and those that have a nearby destination.
The selected rides will be sorted according to the user's preference. For example, the best ride partner (most stars), the closest, the cheapest (makes sense only for the passenger).

### Structure:

As part of the work we were required to create the classes described by the following [Javadoc documentation](https://www.dcc.fc.up.pt/~zp/aulas/1819/asw/trabalhos/padroes/api/)

