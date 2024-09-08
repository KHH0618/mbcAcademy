package arithmetic;

public class Arithmetic {
	private int from;
	private int to;
	private int result;
	//생성자
	public Arithmetic() {}
	public Arithmetic(int from, int to) {
		this.from = from;
		this.to = to;
	}
	
	public int sum() {
		for (int i = from; i<=to; i++) {
			result += i ;
		}
		return result;
	}
	
	public String envnOdd() {
		String envn = (result%2 == 0)? "짝수입니다" : "홀수입니다";
		return envn;
	}
	
	//setter & getter
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	
}
