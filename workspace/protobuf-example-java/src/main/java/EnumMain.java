import examples.enumerations.EnumExample;
import examples.enumerations.EnumExample.EnumMessage;

public class EnumMain {

    public static void main(String[] args) {
        EnumMessage.Builder builder = EnumMessage.newBuilder();

        builder.setId(239)
                .setDayOfTheWeek(EnumExample.DayOfTheWeek.THURSDAY);

        EnumMessage message = builder.build();

        System.out.println(message);

    }
}
