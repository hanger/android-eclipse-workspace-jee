/**
 * �����쳣��ʵ���Լ����쳣��
 * ͨ���̳�Exception����ʵ���Լ����쳣�ࡣ��ʹ��try��catch����������쳣��
 */
class MyException extends Exception {
  public MyException() {}
  public MyException(String msg) {
    super(msg);
  }
  public MyException(String msg, int x) {
    super(msg);
    i = x;
  }
  public int val() { return i; }
  private int i;
}

public class DemoException {
/**
 *����˵����ʹ��MyException����Ĭ�ϵĹ�����
 *���������
 *�������ͣ�
 */
  public static void a() throws MyException {
    System.out.println(
      "Throwing MyException from a()");
    throw new MyException();
  }
/**
 *����˵����ʹ��MyException���д���Ϣ�Ĺ�����
 *���������
 *�������ͣ�
 */
  public static void b() throws MyException {
    System.out.println(
      "Throwing MyException from b()");
    throw new MyException("Originated in b()");
  }
/**
 *����˵����ʹ����MyException���б���Ĺ�����
 *���������
 *�������ͣ�
 */
  public static void c() throws MyException {
    System.out.println(
      "Throwing MyException from c()");
    throw new MyException(
      "Originated in c()", 47);
  }
  public static void main(String[] args) {
    try {
      a();
    } catch(MyException e) {
      e.getMessage();
    }
    try {
      b();
    } catch(MyException e) {
      e.toString();
    }
    try {
      c();
    } catch(MyException e) {
      e.printStackTrace();
      System.out.println("error code: " + e.val());
    }
  }
} //end :)