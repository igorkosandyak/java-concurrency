package sample5;


public class Transaction extends Thread {

	private Account account;
	private int withdraw;

	public Transaction(Account account, int withdraw) {
		this.account = account;
		this.withdraw = withdraw;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(System.currentTimeMillis() % 300);
		}catch (InterruptedException e) {
			return;
		}
		System.out.println("Getting money from account...");
		synchronized (account) {
			int total = account.getMoney();
			if (total >= withdraw) {
				account.setMoney(total - withdraw);
			}
		}
	}
}
