package report_card;

public class report_print {
	public void report_output(report_list rl) {
		for (int i = 0; i < rl.grade_List.size(); i++) {
			System.out.println("gkey:	" + rl.grade_List.get(i).getGrade_key());
			System.out.println("ukey:	" + rl.user_List.get(i).getUser_key());
			System.out.println("name:	" + rl.user_List.get(i).getName());
			System.out.println("c:	" + rl.grade_List.get(i).getC());
			System.out.println("java:	" + rl.grade_List.get(i).getJava());
			System.out.println("py:	" + rl.grade_List.get(i).getPy());
			System.out.println("js:	" + rl.grade_List.get(i).getJs());
			System.out.println("aver:	" + rl.grade_List.get(i).getAver());
			System.out.println("--------------------");
		}
	}
}
