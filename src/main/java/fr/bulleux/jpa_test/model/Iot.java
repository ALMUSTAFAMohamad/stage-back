package fr.bulleux.jpa_test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "IOT")
public class Iot {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "mac")
    private String mac;

    @Column(name = "sensor")
    private String sensor;

    @Column(name = "value")
    private String value;

    @Column(name = "timestamp")
    private OffsetDateTime date;

    @Override
    public String toString() {
        return "Iot{" +
                "id=" + id +
                ", mac='" + mac + '\'' +
                ", sensor='" + sensor + '\'' +
                ", value='" + value + '\'' +
                ", date=" + date +
                '}';
    }
}
