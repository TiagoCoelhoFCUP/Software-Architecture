# Robocode Combat Robot

The goal of this first project is the implementation of a Java class for the real-time programming game Robocode. This class will simulate a battle tank in a battle that takes place in a rectangular arena.
Robocode can be programmed in Java and .Net but in project work we only use Java. It can also be used in different IDEs but we chose to use Eclipse, the IDE used in the development of Robocode itself.

A robot consists of three individual parts:
<ul>
  <li> Body ‒ Carries the gun with the radar on top. The body is used for moving the robot ahead and back, as well as turning left or right </li>
  <li> Gun ‒ Mounted on the body and is used for firing energy bullets. The gun can turn left or right. Carries the radar on top </li>
  <li> Radar ‒ Mounted on the gun and is used to scan for other robots when moved. The radar can turn left or right. The radar generates onScannedRobot() events when robots are detected </li>
</ul>

<br>
<p align="center">
  <img src="https://user-images.githubusercontent.com/13381706/163456920-76a25918-f685-4424-b02c-90284608b5e4.jpg" alt="Sublime's custom image"/>
</p>

For more information on Robocode Physics such as coordinates, movement physics (accelaration, velocity, distance), rotation, bullet damage, colision, etc, click [here](https://robowiki.net/wiki/Robocode/Game_Physics).
