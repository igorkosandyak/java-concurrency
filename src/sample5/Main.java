package sample5;


public class Main {
	public static void main(String[] args) throws InterruptedException {
		Account account = new Account(1000);

		Transaction[] transactions = {
				new Transaction(account, 100),
				new Transaction(account, 500),
				new Transaction(account, 200),
				new Transaction(account, 50),
				new Transaction(account, 150),
		};


		for (Transaction tr : transactions) {
			tr.start();
		}

		for (Transaction tr : transactions) {
			tr.join();
		}

		System.out.println("Total left: " + account.getMoney());
	}
}
