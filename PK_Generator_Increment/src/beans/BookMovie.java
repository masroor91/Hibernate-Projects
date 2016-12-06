package beans;

public class BookMovie {
	
	private int bid;
	private String movie;
	private String showTime;
	private int seatno;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	
	public String getShowTime() {
		return showTime;
	}
	
	
	public int getSeatno() {
		return seatno;
	}
	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}
	
	

}
