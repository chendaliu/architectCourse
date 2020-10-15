package pers.czl.elsetest.dynamicProxy;

import java.lang.reflect.Method;


public class DynamicProxyTest {

	public static void main(String[] args) {
		/*BookService cgBookService = new JdkDynamicProxy(new BookServiceImpl()).getProxy();
		cgBookService.buyBook();*/

		//BookService cgBookService1 = new JdkDynamicProxy(BookService.class.getName()).getProxy();
		BookServiceImpl cgBookService1 = CGLibDynamicProxy.getInstance().getProxy(BookServiceImpl.class);

		System.out.println("我们得到的bean是：" + cgBookService1.getClass());
		System.out.println("实际调用者的父类：" + cgBookService1.getClass().getSuperclass());
		cgBookService1.buyBook();
		try {
			Class<?> c = Class.forName(cgBookService1.getClass().getName());
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
    
}
