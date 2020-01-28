package by.stn.java_exercises.modul_3.ex_7;

import by.stn.java_exercises.modul_3.ex_7.expense.ExpenseDaoImpl;
import by.stn.java_exercises.modul_3.ex_7.expense.ExpenseEntry;
import by.stn.java_exercises.modul_3.ex_7.receiver.ReceiverDaoImpl;
import by.stn.java_exercises.modul_3.ex_7.receiver.ReceiverInfo;

import java.sql.SQLException;


public class Launcher {

	public static void main(String args[]) {
		ExpenseDaoImpl expenseDaoImpl;
		ReceiverDaoImpl receiverDaoImpl;
		try {
			expenseDaoImpl = new ExpenseDaoImpl();
			receiverDaoImpl = new ReceiverDaoImpl();

			ExpenseEntry list1 = expenseDaoImpl.get(1);
			ReceiverInfo list2 = receiverDaoImpl.get(2);

			System.out.println(list1);
			System.out.println(list2);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}


	}
}
