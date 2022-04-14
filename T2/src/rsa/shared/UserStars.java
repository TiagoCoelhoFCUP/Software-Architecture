package rsa.shared;

public enum UserStars {
	FIVE_STARS,
	FOUR_STARS,
	THREE_STARS,
	TWO_STARS,
	ONE_STAR;
	
	int stars;
	String value;
	
	public int getStars() {
		switch(this) {
			case FIVE_STARS:
				stars = 5;
				break;
			case FOUR_STARS:
				stars = 4;
				break;
			case THREE_STARS:
				stars = 3;
				break;
			case TWO_STARS:
				stars = 2;
				break;
			case ONE_STAR:
				stars = 1;
				break;
		}
		return stars;
	}
}
