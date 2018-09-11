package sample4;


public class Main {
	public static void main(String[] args) throws InterruptedException {
		TestThread thread = new TestThread();
		thread.start();

		Thread.sleep(5000);
		thread.myInterrupt();
	}
}

class TestThread extends Thread {

	private volatile boolean stop;

	@Override
	public void run() {
		while ( ! stop) {
			System.out.println("Thread is running...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}

	public void myInterrupt() {
		stop = true;
	}
}