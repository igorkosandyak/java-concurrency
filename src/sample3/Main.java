package sample3;


public class Main {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new TestThread());
		thread.start();

		Thread.sleep(5000);
		thread.interrupt();

	}
}

class TestThread implements Runnable {

	@Override
	public void run() {
		while ( ! Thread.currentThread().isInterrupted()) {
			System.out.println("Thread " + Thread.currentThread().getName() + " is working...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}
