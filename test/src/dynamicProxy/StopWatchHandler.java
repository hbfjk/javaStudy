package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import Utils.Printer;

public class StopWatchHandler implements InvocationHandler {
	
	private Object proxied;
	
	public StopWatchHandler(Object proxied) {
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		long startTime = System.currentTimeMillis();
		Printer.print(proxied.getClass().getName()+":" + method.getName() + "执行前时间:" + startTime);
		Object obj = method.invoke(proxied, args);
		long finishTime = System.currentTimeMillis();
		Printer.print(proxied.getClass().getName()+":" + method.getName() + "执行后时间:" + finishTime);
		Printer.print(proxied.getClass().getName()+":" + method.getName() + "执行时间：" + (finishTime-startTime));
		return obj;
	}

}
