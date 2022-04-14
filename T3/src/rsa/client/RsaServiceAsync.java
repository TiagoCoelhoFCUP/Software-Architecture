package rsa.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import rsa.service.User;
import rsa.shared.Location;
import rsa.shared.PreferredMatch;
import rsa.shared.RideMatchInfo;
import rsa.shared.RideRole;
import rsa.shared.RideSharingAppException;
import rsa.shared.UserStars;

public interface RsaServiceAsync {
	void register(String nick, String name, String password, AsyncCallback<Boolean> callback);

	void updatePassword(String nick, String oldPassword, String newPassword, AsyncCallback<Boolean> callback);

	void authenticate(String nick, String password,AsyncCallback<Boolean> callback);

	void getPreferredMatch(String nick, String password, AsyncCallback<PreferredMatch> callback) throws RideSharingAppException;

	void setPreferredMatch(String nick, String password, PreferredMatch preferred, AsyncCallback<Void> callback) throws RideSharingAppException;

	void addRide(String nick, String password, Location from, Location to, String plate, float cost, AsyncCallback<Long> callback) throws RideSharingAppException;

	void updateRide(long rideId, Location current, AsyncCallback<java.util.Set<RideMatchInfo>> callback);

	void acceptMatch(long rideId, long matchId, AsyncCallback<Void> callback);

	void concludeRide(long rideId, UserStars classification, AsyncCallback<Void> callback);

	void getAverage(String nick, RideRole role, AsyncCallback<Double> callback) throws RideSharingAppException;

	void getUser(String nick, String password, AsyncCallback<User> callback) throws RideSharingAppException;

}
