
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import service.demo.HelloWorld;

public class HWClient {
    public static void main(String[] args){
        try {
            TTransport tTransport = getTTransport();
            TProtocol protocol = new TBinaryProtocol(tTransport);
            HelloWorld.Client client = new HelloWorld.Client(protocol);
            String result = client.helloWorld("system");
            System.out.println("The result is: " + result);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static TTransport getTTransport() throws Exception{
        try{
            TTransport tTransport = getTTransport("127.0.0.1", 7911, 5000000);
            if(!tTransport.isOpen()){
                tTransport.open();
            }
            return tTransport;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static TTransport getTTransport(String host, int port, int timeout) {
        final TSocket tSocket = new TSocket(host, port, timeout);
        final TTransport transport = new TFramedTransport(tSocket);
        return transport;
    }
}
