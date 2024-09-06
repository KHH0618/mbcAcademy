package strategy2.interfaces;

public class FuelHybrid implements FuelImpl {

	@Override
	public String fuel() {
		return "전기 하이브리드로 움직입니다.";
	}

}
