package man;

import robocode.*;
import java.awt.Color;

public class MyFirstRobot extends AdvancedRobot {
	private EnemyRobot enemy = new EnemyRobot();
	private byte radarDirection = 1;
	private byte moveDirection = 1;
	private double length = 64;
	public void run() {
		setColors(Color.black, Color.black, Color.orange);
		setAdjustRadarForGunTurn(true);
		setAdjustGunForRobotTurn(true);
		while (true) {
			doRadar();
			doGun();
			execute();
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		doMove(e);
		enemy.update(e);
	}

	public void onRobotDeath(RobotDeathEvent e) {
		enemy.reset();
		radarDirection = 1;
		moveDirection = 1;
	}
	
	void doRadar() {
		if (enemy.none()) {
			// look around if we have no enemy
			setTurnRadarRight(Double.POSITIVE_INFINITY);
		} else {
			// oscillate the radar
			double turn = getHeading() - getRadarHeading() + enemy.getBearing();
			turn += 30 * radarDirection;
			setTurnRadarRight(normalizeBearing(turn));
			radarDirection *= -1;
		}
	}

	public void doMove(ScannedRobotEvent e) {
		if(enemy.none()==false) {
			//energy monitoring
			double diference = enemy.getEnergy() - e.getEnergy();
			if(getDistanceRemaining()== 0.0 &&  diference > 0.0 ){
				// turn slightly toward our enemy
				setTurnRight(normalizeBearing(enemy.getBearing() + 90 - (15 * moveDirection)));
				if(0.0 < diference && diference < 0.5) {
					length = 19;
				}
				if(0.5 < diference && diference < 0.1) {
					length = 27;
				}
				if(1.0 < diference && diference < 1.5) {
					length = 33;
				}
				if(1.5 < diference && diference < 2.0) {
					length = 37;
				}
				if(2.0 < diference && diference < 2.5) {
					length = 48;
				}
				if(2.5 < diference && diference < 3) {
					length = 56;
				}
				else {
					length = 64;
				}
				setAhead(length*moveDirection);
				moveDirection *= -1;
			}
		}
	}

	void doGun() {
		if (enemy.none())
			return;
		setTurnGunRight(normalizeBearing(getHeading() - getGunHeading() + enemy.getBearing()));
		if (getGunHeat() == 0 && Math.abs(getGunTurnRemaining()) < 10 && enemy.getDistance()<600) {
			setFire(400 / enemy.getDistance());
		}
	}
	
	// normalizes a bearing to between +180 and -180
	double normalizeBearing(double angle) {
		while (angle >  180) angle -= 360;
		while (angle < -180) angle += 360;
		return angle;
	}
}