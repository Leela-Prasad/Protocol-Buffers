import examples.complex.Complex.*;

import java.util.Arrays;

public class ComplexMain {

   public static void main(String[] args) {
        ComplexMessage.Builder builder = ComplexMessage.newBuilder();

        builder.setOneDummy(newDummyMessage(239, "one dummy message"));

        builder.addMultipleDummy(newDummyMessage(240, "second dummy"));
        builder.addMultipleDummy(newDummyMessage(241, "third dummy"));
        builder.addMultipleDummy(newDummyMessage(242, "fourth dummy"));

        builder.addAllMultipleDummy(Arrays.asList(
                newDummyMessage(243, "other dummy"),
                newDummyMessage(244, "other other dummy")
        ));

        ComplexMessage message = builder.build();

        System.out.println(message.toString());
    }

    private static DummyMessage newDummyMessage(int id, String name) {
        DummyMessage.Builder builder = DummyMessage.newBuilder();

        builder.setId(id)
                .setName(name);

        return builder.build();
    }
}
