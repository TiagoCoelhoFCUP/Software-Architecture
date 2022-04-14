package rsa.client;

import rsa.service.User;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import rsa.shared.Location;
import rsa.shared.PreferredMatch;
import rsa.shared.RideMatchInfo;
import rsa.shared.RideRole;
import rsa.shared.RideSharingAppException;
import rsa.shared.UserStars;

@RemoteServiceRelativePath("rideSharingService")
public interface RsaService extends RemoteService {	
	boolean register(String nick, String name, String password);

	boolean updatePassword(String nick, String oldPassword, String newPassword);

	boolean authenticate(String nick, String password);

	PreferredMatch getPreferredMatch(String nick, String password) throws RideSharingAppException;

	void setPreferredMatch(String nick, String password, PreferredMatch preferred) throws RideSharingAppException;

	long addRide(String nick, String password, Location from, Location to, String plate, float cost) throws RideSharingAppException;

	java.util.Set<RideMatchInfo> updateRide(long rideId, Location current);

	void acceptMatch(long rideId, long matchId);

	void concludeRide(long rideId, UserStars classification);

	double getAverage(String nick, RideRole role) throws RideSharingAppException;

	User getUser(String nick, String password) throws RideSharingAppException;
}