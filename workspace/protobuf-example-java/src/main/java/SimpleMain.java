import com.examples.simple.Simple.SimpleMessage;
import com.google.protobuf.util.JsonFormat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class SimpleMain {

    public static void main(String[] args) throws Exception {
        SimpleMessage.Builder builder = SimpleMessage.newBuilder();

        // simple fields
        builder.setId(42)
                .setIsSimple(true)
                .setName("My Simple Message Name");

        // repeated fields
        builder.addSampleList(1)
                .addSampleList(2)
                .addSampleList(3)
                .addAllSampleList(Arrays.asList(5,6,4));

        System.out.println("Builder Object: " + builder.toString());

        SimpleMessage message = builder.build();

        String jsonString = JsonFormat.printer().print(builder);
        System.out.println(jsonString);

        SimpleMessage.Builder builder2 = SimpleMessage.newBuilder();

        JsonFormat.parser()
                .ignoringUnknownFields()
                .merge(jsonString, builder2);

        //byte[] bytes = message.toByteArray();
        //System.out.println("Byte Array: " + bytes);

        // write protocol buffer binary to a file
        FileOutputStream fileOutputStream = new FileOutputStream("simple_message.bin");
        message.writeTo(fileOutputStream);
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("simple_message.bin");
        SimpleMessage messageFromFile = SimpleMessage.parseFrom(fileInputStream);
        fileInputStream.close();
        System.out.println("From File: " + messageFromFile);
    }
}
