package PaperTest;

public class coffee_main {

	public static void main(String[] args) {
		coffee_admin cad = new coffee_admin();
		coffee_customer cct = new coffee_customer();
		coffee_customerVO cctVO = new coffee_customerVO();
		coffee_machine cm = new coffee_machine();

		while (true) {
			cm.first_view(cad, cct, cctVO);
		}

	}

}
