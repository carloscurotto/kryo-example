package ar.com.carloscurotto.kryo.example;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import ar.com.carloscurotto.kryo.model.Address;
import ar.com.carloscurotto.kryo.model.Person;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class ByteArrayExample {

    public static void main(String[] args) throws Exception {

        Kryo kryo = new Kryo();

        Output output = new Output(new ByteArrayOutputStream());
        Person toKryo = new Person("Carlos", "Curotto", 33, new Address("Camacua", 134, "Buenos Aires", "1406"));
        kryo.writeObject(output, toKryo);
        output.close();

        System.out.println("Size=" + output.getBuffer().length + " bytes");

        Input input = new Input(new ByteArrayInputStream(output.getBuffer()));
        Person fromKryo = kryo.readObject(input, Person.class);
        input.close();

        if (!toKryo.equals(fromKryo)) {
            throw new RuntimeException("The serialization does not work properly.");
        } else {
            System.out.println("The person [" + toKryo
                    + "] was serialized/deserialized properly to [" + fromKryo + "].");
        }
    }

}
