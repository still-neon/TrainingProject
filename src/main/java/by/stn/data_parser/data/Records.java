package by.stn.data_parser.data;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@AllArgsConstructor
public class Records {
    List<Record> records;

    @XmlRootElement
    public class Record {
        String date;
        Pairs pairs;

        @XmlRootElement
        public class Pairs {
            List<Pair> pairs;

            @XmlRootElement
            public class Pair {
                String text;
                String value;
            }
        }
    }
}