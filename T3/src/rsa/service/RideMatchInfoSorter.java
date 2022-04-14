package rsa.service;

import rsa.shared.RideMatchInfo;

/**
 * A type proving a comparator of RideMatchInfo instances.
 * @author Tiago Coelho e Vasco Soares;
 */

public interface RideMatchInfoSorter {
	java.util.Comparator<RideMatchInfo> getComparator();
}
