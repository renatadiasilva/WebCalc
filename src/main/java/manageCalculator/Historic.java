package manageCalculator;

import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class Historic implements Serializable {
	
	private static final long serialVersionUID = -282702558525389183L;
	private ArrayList<ExpressionC> list;

	public Historic() {
		list = new ArrayList<>();
	}

	public ArrayList<ExpressionC> getList() {
		return list;
	}

	public void addToList(String e, String r, String t) {
		String rred = r.substring(0, (int) Math.min(10,r.length()));
		ExpressionC ex = new ExpressionC(e, rred, t);
		list.add(0,ex);
	}

}
