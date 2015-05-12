package manageCalculator;

public class ExpressionC {
	
	private String exp;
	private String result;
	private String time;

	public ExpressionC(String exp, String result, String time) {
		this.exp = exp;
		this.result = result;
		this.time = time;
	}
	
	public String getExp() {
		return exp;
	}
	
	public void setExp(String exp) {
		this.exp = exp;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
