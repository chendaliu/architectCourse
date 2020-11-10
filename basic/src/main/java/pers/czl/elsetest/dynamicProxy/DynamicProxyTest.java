package pers.czl.elsetest.dynamicProxy;

import java.lang.reflect.Method;


public class DynamicProxyTest {

	public static void main(String[] args) {
		DynamicProxyTest dynamicProxyTest = new DynamicProxyTest();

		BookService bookService = dynamicProxyTest.testJdk();

		System.out.println("我们得到的bean是：" + bookService.getClass());
		System.out.println("实际调用者的父类：" + bookService.getClass().getSuperclass());

		bookService.buyBook();
		try {
			Class<?> c = Class.forName(bookService.getClass().getName());
			Class<?> beanc = Class.forName("com.czl.daliu.test.dynamicProxy.BookServiceImpl");
			
			Method[] beanc_method = beanc.getMethods();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//cgBookService.buyBook();
    }

    /*public static void createProxyClassFile()
    {
        String name = "ProxySubject";
        byte[] data = ProxyGenerator.generateProxyClass( name, new Class[] { Subject.class } );
        try
        {
            FileOutputStream out = new FileOutputStream( name + ".class" );
            out.write( data );
            out.close();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }*/

	private BookService testJdk() {
		BookService cgBookService = new JdkDynamicProxy(new BookServiceImpl()).getProxy();
		cgBookService.buyBook();

		System.out.println("我们得到的bean是：" + cgBookService.getClass());
		System.out.println("实际调用者的父类：" + cgBookService.getClass().getSuperclass());
		cgBookService.buyBook();
		return cgBookService;
	}
    
}
