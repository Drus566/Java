class ShutDownHook {
	public ShutDownHook() {
			
	}
	
	public static void main(String[] args) {
		Runtime rtm = Runtime.getRuntime();
		rtm.addShutdownHook(new ShutDownThread());
		rtm = null;
		
		try {
			System.out.println("Программа будет ждать 100 секунд перед тем, как закрыться");
			System.out.println("Нажатие клавиш Ctrl+C не завершит работу программы");
			System.out.println("а вызовет переход к следующей ее части.");
			Thread.sleep(100000);
		} catch (InterruptedException ie) {
			System.out.println(ie.getMessage());	
		}
	}
}

class ShutDownThread extends Thread {
	public void run() {
		System.out.println("\tПрограмма завершена");	
		System.out.println("\tНо можно еще что-то изменить");
	}
}
