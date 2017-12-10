package chen0040.github.com.sbclient;


import com.github.chen0040.sbclient.SpringBootWebSocketClient;
import com.github.chen0040.sbclient.StompMessage;
import com.github.chen0040.sbclient.StompMessageListener;
import com.github.chen0040.sbclient.TopicHandler;
import org.testng.annotations.Test;

/**
 * Created by xschen on 12/6/2017.
 */
public class SpringBootWebSocketClientUnitTest {



   @Test
   public void testWebSocket() throws InterruptedException {
      SpringBootWebSocketClient client = new SpringBootWebSocketClient();
      TopicHandler handler = client.subscribe("/topics/event");
      handler.addListener(message -> System.out.println(message.getHeader("destination") + ": " + message.getContent()));
      client.connect("ws://localhost:8080/my-ws/websocket");
      Thread.sleep(60000L);
      client.disconnect();
   }


}
