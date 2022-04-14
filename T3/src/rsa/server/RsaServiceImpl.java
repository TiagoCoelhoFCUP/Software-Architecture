package rsa.server;

import java.util.Set;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import rsa.client.RsaService;
import rsa.service.Manager;
import rsa.service.User;
import rsa.shared.Location;
import rsa.shared.PreferredMatch;
import rsa.shared.RideMatchInfo;
import rsa.shared.RideRole;
import rsa.shared.RideSharingAppException;
import rsa.shared.UserStars;

public class RsaServiceImpl extends RemoteServiceServlet implements RsaService{
	private static final long serialVersionUID = 1L;
	Manager manager = Manager.getInstance();

	@Override
	public boolean register(String nick, String name, String password) {
		return manager.register(nick, name, password);
	}

	@Override
	public boolean updatePassword(String nick, String oldPassword, String newPassword) {
		return manager.updatePassword(nick, oldPassword, newPassword);
	}

	@Override
	public boolean authenticate(String nick, String password) {
		return manager.authenticate(nick, password);
	}

	@Override
	public PreferredMatch getPreferredMatch(String nick, String password) throws RideSharingAppException {
		return manager.getPreferredMatch(nick, password);
	}

	@Override
	public void setPreferredMatch(String nick, String password, PreferredMatch preferred)throws RideSharingAppException {
		manager.setPreferredMatch(nick, password, preferred);
	}

	@Override
	public long addRide(String nick, String password, Location from, Location to, String plate, float cost) throws RideSharingAppException {
		return manager.addRide(nick, password, from, to, plate, cost);
	}

	@Override
	public Set<RideMatchInfo> updateRide(long rideId, Location current) {
		return manager.updateRide(rideId, current);
	}

	@Override
	public void acceptMatch(long rideId, long matchId) {
		manager.acceptMatch(rideId, matchId);
	}

	@Override
	public void concludeRide(long rideId, UserStars classification) {
		manager.concludeRide(rideId, classification);
	}

	@Override
	public double getAverage(String nick, RideRole role) throws RideSharingAppException {
		return manager.getAverage(nick, role);
	}

	@Override
	public User getUser(String nick, String password) throws RideSharingAppException {
		return manager.getUser(nick, password);
	}

}
