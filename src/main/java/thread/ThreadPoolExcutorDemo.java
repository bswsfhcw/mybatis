package thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExcutorDemo {

	
	private static int corePoolSize = 5;//核心线程数，默认情况下核心线程会一直存活，即使处于闲置状态也不会受存keepAliveTime限制。除非将allowCoreThreadTimeOut设置为true。
	private static int maximumPoolSize = 6;//线程池所能容纳的最大线程数。超过这个数的线程将被阻塞。当任务队列为没有设置大小的LinkedBlockingDeque时，这个值无效
	private static Long keepAliveTime = 1L;//非核心线程的闲置超时时间，超过这个时间就会被回收。
	//TimeUnit 指定keepAliveTime的单位，如TimeUnit.SECONDS。当将allowCoreThreadTimeOut设置为true时对corePoolSize生效
	
	//是否允许核心线程空闲退出，默认值为false。
	
	private static int produceTaskSleepTime = 3000;
	private static int produceTaskMaxNumber = 10; // 定义最大添加N个线程到线程池中

	public static void main(String[] args) {
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		threadPool.allowCoreThreadTimeOut(true);
		
		for (int i = 1; i <= produceTaskMaxNumber; i++) {
			try {
				// 一个任务，并将其加入到线程池
				String work = "work@ " + i;
				System.out.println("put ：" + work);
				threadPool.execute(new ThreadPoolTask(work));
				// 便于观察，等待一段时间
				Thread.sleep(produceTaskSleepTime);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(5000L);
			threadPool.execute(new ThreadPoolTask("new"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
