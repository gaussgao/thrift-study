
import org.apache.thrift.TException;
import service.demo.HelloWorld;

public class HelloWorldImpl implements HelloWorld.Iface{
    @Override
    public String helloWorld(String para) throws TException {
        System.out.println("Hello World:"+para);
        return para + ",good day!";
    }
}
